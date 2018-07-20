package com.qxb.student.common.module;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.qxb.student.common.Config;
import com.qxb.student.common.Constant;
import com.qxb.student.common.http.HttpResponse;
import com.qxb.student.common.http.HttpUtils;
import com.qxb.student.common.module.api.AdvertApi;
import com.qxb.student.common.module.api.SchoolApi;
import com.qxb.student.common.module.api.SysAdApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.SysAd;
import com.qxb.student.common.module.bean.SysAd;
import com.qxb.student.common.module.dao.RoomUtils;
import com.qxb.student.common.utils.SharedUtils;

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
 * 广告数据仓库
 *
 * @author winky
 */
public class AdvertRepository extends BaseRepository {


    private static final String AD_LIVE_HOME = "ad_live_home";
    private SharedUtils sharedUtils = SharedUtils.get(Constant.SHARE_FILE_DATA);
    private MutableLiveData<String> adHomeLive;
    private MutableLiveData<List<SysAd>> homeBanner;

    public LiveData<String> getLiveHomeAd() {
        adHomeLive = new MutableLiveData<>();
        ApiModel apiModel = ApiModel.parse((String) sharedUtils.get(AD_LIVE_HOME, ""));
        if (apiModel == null || apiModel.getCacheTime() < System.currentTimeMillis()) {
            Disposable disposable = HttpUtils.create(AdvertApi.class).getLiveHomeAd()
                    .subscribeOn(Schedulers.io())
                    .doOnNext(new Consumer<ApiModel<String>>() {
                        @Override
                        public void accept(ApiModel<String> listApiModel) {
                            if (listApiModel.getCode() == 1) {
                                listApiModel.setCacheTime(listApiModel.getCacheTime() * 1000 + System.currentTimeMillis());
                                sharedUtils.put(AD_LIVE_HOME, listApiModel.toString());
                            }
                        }
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<ApiModel<String>>() {
                        @Override
                        public void accept(ApiModel<String> listApiModel) {
                            if (listApiModel.getCode() == 1) {
                                adHomeLive.setValue(listApiModel.getData());
                            }
                        }
                    });
            addDisposable(disposable);
        } else {
            adHomeLive.setValue(apiModel.getData().toString());
        }
        return adHomeLive;
    }

    public LiveData<List<SysAd>> getHomeBanner() {
        homeBanner = new MutableLiveData<>();
        Disposable disposable = Observable.create(new ObservableOnSubscribe<List<SysAd>>() {
            @Override
            public void subscribe(ObservableEmitter<List<SysAd>> emitter) {
                List<SysAd> sysAdList = roomUtils.sysAdDao().getHomeBanner("home_ad");
                if (sysAdList.size() == 0) {
                    emitter.onComplete();
                } else {
                    emitter.onNext(sysAdList);
                    if (checkCacheTime(SysAd.class)) {
                        emitter.onComplete();
                    }
                }
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<List<SysAd>>() {
                    @Override
                    public void accept(List<SysAd> sysAds) {
                        homeBanner.postValue(sysAds);
                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() {
                        String province = "420000";
                        Disposable disposable = HttpUtils.create(SysAdApi.class).getHomeBanner(province)
                                .subscribeOn(Schedulers.io())
                                .doOnNext(new Consumer<ApiModel<List<SysAd>>>() {
                                    @Override
                                    public void accept(ApiModel<List<SysAd>> listApiModel) {
                                        addCache(SysAd.class, listApiModel.getCacheTime());
                                        roomUtils.sysAdDao().insertSysAd(listApiModel.getData());
                                    }
                                })
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<ApiModel<List<SysAd>>>() {
                                    @Override
                                    public void accept(ApiModel<List<SysAd>> listApiModel) {
                                        if (listApiModel.getCode() == 1) {
                                            homeBanner.postValue(listApiModel.getData());
                                        }
                                    }
                                });
                        addDisposable(disposable);
                    }
                }).subscribe();
        addDisposable(disposable);
        return homeBanner;
    }
}
