package com.qxb.student.common.module;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.qxb.student.common.http.HttpUtils;
import com.qxb.student.common.module.api.SchoolApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.School;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 学校数据仓库
 *
 * @author winky
 * @date
 */
public class SchoolRepository extends BaseRepository {

    private MutableLiveData<List<School>> schoolListLiveData = new MutableLiveData<>();
    private MutableLiveData<School> schoolLiveData = new MutableLiveData<>();

    public LiveData<List<School>> getSchoolLiveData() {
        Disposable disposable = Observable.create(new ObservableOnSubscribe<List<School>>() {
            @Override
            public void subscribe(ObservableEmitter<List<School>> emitter) {
                List<School> schoolList = roomUtils.schoolDao().getRecommendedColleges();
                if (schoolList.size() == 0) {
                    emitter.onComplete();
                } else {
                    emitter.onNext(schoolList);
                    if (checkCacheTime(School.class)) {
                        emitter.onComplete();
                    }
                }
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<List<School>>() {
                    @Override
                    public void accept(List<School> schools) {
                        schoolListLiveData.postValue(schools);
                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() {
                        String province = "420000";
                        Disposable disposable = HttpUtils.create(SchoolApi.class).getRecommendedCollegeList(province)
                                .subscribeOn(Schedulers.io())
                                .doOnNext(new Consumer<ApiModel<List<School>>>() {
                                    @Override
                                    public void accept(ApiModel<List<School>> listApiModel) {
                                        addCache(School.class, listApiModel.getCacheTime());
                                        roomUtils.schoolDao().insertColleges(listApiModel.getData());
                                    }
                                })
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<ApiModel<List<School>>>() {
                                    @Override
                                    public void accept(ApiModel<List<School>> listApiModel) {
                                        if (listApiModel.getCode() == 1) {
                                            schoolListLiveData.postValue(listApiModel.getData());
                                        }
                                    }
                                });
                        addDisposable(disposable);
                    }
                }).subscribe();
        addDisposable(disposable);
        return schoolListLiveData;
    }

    public LiveData<School> getSchoolById(final String schoolId) {
        Disposable disposable = Observable.create(new ObservableOnSubscribe<School>() {
            @Override
            public void subscribe(ObservableEmitter<School> emitter) {
                School school = roomUtils.schoolDao().getSchoolById(schoolId);
                if (school == null) {
                    emitter.onComplete();
                } else {
                    emitter.onNext(school);
                }
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<School>() {
                    @Override
                    public void accept(School schools) {
                        schoolLiveData.postValue(schools);
                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() {
                        String province = "420000";
                        Disposable disposable = HttpUtils.create(SchoolApi.class).getSchoolById(schoolId, province)
                                .subscribeOn(Schedulers.io())
                                .doOnNext(new Consumer<ApiModel<School>>() {
                                    @Override
                                    public void accept(ApiModel<School> apiModel) {
                                        if (apiModel.getCode() == 1) {
                                            roomUtils.schoolDao().insertColleges(apiModel.getData());
                                        }
                                    }
                                })
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<ApiModel<School>>() {
                                    @Override
                                    public void accept(ApiModel<School> apiModel) {
                                        if (apiModel.getCode() == 1) {
                                            schoolLiveData.postValue(apiModel.getData());
                                        }
                                    }
                                });
                        addDisposable(disposable);
                    }
                }).subscribe();
        addDisposable(disposable);
        return schoolLiveData;
    }

    @Override
    public void onCleared() {
        super.onCleared();
        schoolListLiveData = null;
        schoolLiveData = null;
    }
}
