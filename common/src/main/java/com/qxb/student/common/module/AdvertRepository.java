package com.qxb.student.common.module;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.Build;

import com.qxb.student.common.Config;
import com.qxb.student.common.Constant;
import com.qxb.student.common.http.SubscribeObj;
import com.qxb.student.common.module.api.SysAdApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.FunctionItem;
import com.qxb.student.common.module.bean.SysAd;
import com.qxb.student.common.utils.ExecutorUtils;
import com.qxb.student.common.utils.SharedUtils;
import com.qxb.student.common.utils.SysUtils;
import com.qxb.student.common.utils.UserCache;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import retrofit2.http.Field;

/**
 * 广告数据仓库
 *
 * @author winky
 */
public class AdvertRepository extends BaseRepository {


    private static final String AD_LIVE_HOME = "ad_live_home";
    private SharedUtils sharedUtils = SharedUtils.get(Constant.SHARE_FILE_DATA);
    private MutableLiveData<String> adHomeLive = new MutableLiveData<>();
    private MutableLiveData<List<SysAd>> homeBanner = new MutableLiveData<>();
    private MutableLiveData<List<FunctionItem>> functionLiveData = new MutableLiveData<>();

    public LiveData<String> getLiveHomeAd() {
        ApiModel apiModel = ApiModel.parse((String) sharedUtils.get(AD_LIVE_HOME, ""));
        if (apiModel == null || apiModel.getCacheTime() < System.currentTimeMillis()) {
            Disposable disposable = httpUtils.convert(httpUtils.create(SysAdApi.class).getLiveHomeAd()).subscribe(new Consumer<ApiModel<String>>() {
                @Override
                public void accept(ApiModel<String> apiModel) {
                    if (apiModel.getCode() == 1) {
                        apiModel.setCacheTime(apiModel.getCacheTime() * 1000 + System.currentTimeMillis());
                        sharedUtils.put(AD_LIVE_HOME, apiModel.toString());
                        adHomeLive.postValue(apiModel.getData());
                    }
                }
            });
            httpUtils.addDisposable(disposable);
        } else {
            adHomeLive.setValue(apiModel.getData().toString());
        }
        return adHomeLive;
    }

    public LiveData<List<SysAd>> getHomeBanner() {
        Observable<ApiModel<List<SysAd>>> observable = httpUtils.convert(httpUtils.create(SysAdApi.class)
                .getHomeBanner(UserCache.getInstance().getProvince()), new Consumer<ApiModel<List<SysAd>>>() {
            @Override
            public void accept(ApiModel<List<SysAd>> listApiModel) {
                httpUtils.addCache(SysAd.class, listApiModel.getCacheTime());
                roomUtils.sysAdDao().insertSysAd(listApiModel.getData());
            }
        });
        httpUtils.request(homeBanner, new SubscribeObj<List<SysAd>>() {
            @Override
            protected List<SysAd> queryLocal() {
                return roomUtils.sysAdDao().getAdByType("home_ad");
            }
        }, observable);
        return homeBanner;
    }

    public LiveData<List<SysAd>> getSysAdList(final String type) {
        Observable<ApiModel<List<SysAd>>> observable = httpUtils.convert(httpUtils.create(SysAdApi.class)
                .getSysAdList(type,
                        UserCache.getInstance().getProvince(),
                        UserCache.getInstance().getUserId()), new Consumer<ApiModel<List<SysAd>>>() {
            @Override
            public void accept(ApiModel<List<SysAd>> listApiModel) {
                httpUtils.addCache(SysAd.class, listApiModel.getCacheTime());
                roomUtils.sysAdDao().insertSysAd(listApiModel.getData());
            }
        });
        httpUtils.request(homeBanner, new SubscribeObj<List<SysAd>>() {
            @Override
            protected List<SysAd> queryLocal() {
                return roomUtils.sysAdDao().getAdByType(type);
            }
        }, observable);
        return homeBanner;
    }

    public LiveData<List<FunctionItem>> getIndexFunctions() {
        String versionCode;
        if (Build.VERSION.SDK_INT >= 28) {
            versionCode = String.valueOf(SysUtils.getInstance().getPackageInfo().getLongVersionCode());
        } else {
            versionCode = String.valueOf(SysUtils.getInstance().getPackageInfo().versionCode);
        }
        Observable<ApiModel<List<FunctionItem>>> observable = httpUtils.convert(httpUtils.create(SysAdApi.class)
                .getIndexFunctions(versionCode), new Consumer<ApiModel<List<FunctionItem>>>() {
            @Override
            public void accept(ApiModel<List<FunctionItem>> apiModel) {
                httpUtils.addCache(SysAd.class, apiModel.getCacheTime());
                roomUtils.functionItemDao().insert(apiModel.getData());
            }
        });
        httpUtils.request(functionLiveData, new SubscribeObj<List<FunctionItem>>() {
            @Override
            protected List<FunctionItem> queryLocal() {
                return roomUtils.functionItemDao().getIndexFunctions();
            }
        }, observable);

//        ExecutorUtils.getInstance().addTask(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    ApiModel<List<FunctionItem>> apiModel = httpUtils.create(SysAdApi.class).getIndexFunctions(versionCode).execute().body();
//                    if (apiModel != null && apiModel.getCode() == Config.HTTP_SUCCESS) {
//                        roomUtils.functionItemDao().insert(apiModel.getData());
//                        functionLiveData.postValue(apiModel.getData());
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
        return functionLiveData;
    }


    @Override
    public void onCleared() {

    }
}
