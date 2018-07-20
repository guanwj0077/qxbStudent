package com.qxb.student.common.module;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.qxb.student.common.http.PostApiConsumer;
import com.qxb.student.common.http.PostConsumer;
import com.qxb.student.common.http.SubscribeObj;
import com.qxb.student.common.module.api.SchoolApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.School;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

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
        String province = "420000";
        Observable<ApiModel<List<School>>> observable = httpUtils.convert(httpUtils.create(SchoolApi.class).getRecommendedCollegeList(province),
                new Consumer<ApiModel<List<School>>>() {
                    @Override
                    public void accept(ApiModel<List<School>> listApiModel) {
                        httpUtils.addCache(School.class, listApiModel.getCacheTime());
                        roomUtils.schoolDao().insertColleges(listApiModel.getData());
                    }
                });
        httpUtils.request(schoolListLiveData, new SubscribeObj<List<School>>() {
            @Override
            protected List<School> queryLocal() {
                return roomUtils.schoolDao().getRecommendedColleges();
            }
        }, observable);
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
        schoolListLiveData = null;
        schoolLiveData = null;
    }
}
