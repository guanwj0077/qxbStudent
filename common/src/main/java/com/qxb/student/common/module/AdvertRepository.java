package com.qxb.student.common.module;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.qxb.student.common.Config;
import com.qxb.student.common.http.HttpUtils;
import com.qxb.student.common.http.PostApiConsumer;
import com.qxb.student.common.http.SubscribeObj;
import com.qxb.student.common.module.api.AdvertApi;
import com.qxb.student.common.module.api.SchoolApi;
import com.qxb.student.common.module.api.SysAdApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.School;
import com.qxb.student.common.module.bean.SysAd;
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
    private SharedUtils sharedUtils = SharedUtils.get(Config.SHARE_DATA);
    private MutableLiveData<String> adHomeLive = new MutableLiveData<>();
    private MutableLiveData<List<SysAd>> homeBanner = new MutableLiveData<>();

    public LiveData<String> getLiveHomeAd() {
        ApiModel apiModel = ApiModel.parse((String) sharedUtils.get(AD_LIVE_HOME, ""));
        if (apiModel == null || apiModel.getCacheTime() < System.currentTimeMillis()) {
            Disposable disposable = httpUtils.convert(httpUtils.create(AdvertApi.class).getLiveHomeAd(),
                    new Consumer<ApiModel<String>>() {
                        @Override
                        public void accept(ApiModel<String> apiModel) {
                            if (apiModel.getCode() == 1) {
                                apiModel.setCacheTime(apiModel.getCacheTime() * 1000 + System.currentTimeMillis());
                                sharedUtils.put(AD_LIVE_HOME, apiModel.toString());
                            }
                        }
                    }).subscribe(new PostApiConsumer<>(adHomeLive));
            httpUtils.addDisposable(disposable);
        } else {
            adHomeLive.setValue(apiModel.getData().toString());
        }
        return adHomeLive;
    }

    public LiveData<List<SysAd>> getHomeBanner() {
        String province = "420000";
        Observable<ApiModel<List<SysAd>>> observable = httpUtils.convert(httpUtils.create(SysAdApi.class).getHomeBanner(province), new Consumer<ApiModel<List<SysAd>>>() {
            @Override
            public void accept(ApiModel<List<SysAd>> listApiModel) {
                httpUtils.addCache(SysAd.class, listApiModel.getCacheTime());
                roomUtils.sysAdDao().insertSysAd(listApiModel.getData());
            }
        });
        httpUtils.request(homeBanner, new SubscribeObj<List<SysAd>>() {
            @Override
            protected List<SysAd> queryLocal() {
                return roomUtils.sysAdDao().getHomeBanner("home_ad");
            }
        }, observable);
        return homeBanner;
    }

    @Override
    public void onCleared() {

    }
}
