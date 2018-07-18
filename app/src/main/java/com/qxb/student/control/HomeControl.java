package com.qxb.student.control;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.qxb.student.common.module.AdvertRepository;
import com.qxb.student.common.module.SchoolRepository;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.School;
import com.qxb.student.common.module.bean.SysAd;
import com.qxb.student.common.module.dao.RoomUtils;
import com.qxb.student.common.utils.ExecutorUtils;
import com.qxb.student.common.utils.Logger;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HomeControl extends AndroidViewModel {

    private SchoolRepository schoolRepository = new SchoolRepository();
    private AdvertRepository advertRepository = new AdvertRepository();
    private final RoomUtils roomUtils = RoomUtils.getInstance();
    private volatile MutableLiveData<List<School>> schoolListLiveData = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public HomeControl(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<School>> getSchoolLiveData() {
        final String proinvceCode = "420000";
        Disposable disposable = Observable.create(new ObservableOnSubscribe<List<School>>() {
            @Override
            public void subscribe(ObservableEmitter<List<School>> emitter) throws Exception {
                List<School> schoolList = roomUtils.schoolDao().getRecommendedColleges();
                if (schoolList.size() == 0) {
                    emitter.onComplete();
                } else {
                    emitter.onNext(schoolList);
                    if (roomUtils.checkCacheTime(School.class)) {
                        emitter.onComplete();
                    }
                }
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<List<School>>() {
                    @Override
                    public void accept(List<School> schools) throws Exception {
                        Logger.getInstance().e("doOnNext");
                        schoolListLiveData.setValue(schools);
                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        Logger.getInstance().e("doOnComplete");
                        schoolRepository.getSchoolLiveData(proinvceCode).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ApiModel<List<School>>>() {
                            @Override
                            public void accept(ApiModel<List<School>> listApiModel) throws Exception {
                                schoolListLiveData.setValue(listApiModel.getData());
                            }
                        });
                    }
                })
                .subscribe();
        compositeDisposable.add(disposable);
        return schoolListLiveData;
    }

    public LiveData<String> getLiveAdvert() {
        return advertRepository.getLiveHomeAd();
    }

    public LiveData<List<SysAd>> getHomeBanner() {
        return advertRepository.getHomeBanner("420000");
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
    }
}
