package com.qxb.student.common.module;

import android.arch.lifecycle.MutableLiveData;
import android.os.Build;
import android.support.annotation.NonNull;

import com.qxb.student.common.http.task.ClientTask;
import com.qxb.student.common.http.task.DataHandle;
import com.qxb.student.common.http.task.HttpTask;
import com.qxb.student.common.module.api.SysAdApi;
import com.qxb.student.common.module.bean.FunctionItem;
import com.qxb.student.common.module.bean.SysAd;
import com.qxb.student.common.utils.SysUtils;
import com.qxb.student.common.utils.UserCache;

import java.util.List;

/**
 * 广告数据仓库
 *
 * @author winky
 */
public class AdvertRepository extends BaseRepository {

    public void getLiveHomeAd(MutableLiveData<String> adHomeLive) {
        new HttpTask<String>()
                .netLive(adHomeLive)
                .call(httpUtils.create(SysAdApi.class).getLiveHomeAd())
                .start();
    }

    public void getHomeBanner(MutableLiveData<List<SysAd>> bannerLiveData) {
        new HttpTask<List<SysAd>>()
                .call(httpUtils.create(SysAdApi.class).getHomeBanner(UserCache.getInstance().getProvince()))
                .netLive(bannerLiveData)
                .localLive(new ClientTask<List<SysAd>>() {
                    @Override
                    public List<SysAd> reqInSQLite(int pageIndex) {
                        return roomUtils.sysAdDao().getAdByType("home_ad");
                    }
                })
                .handle(new DataHandle<List<SysAd>>() {
                    @Override
                    public void handle(@NonNull List<SysAd> data) {
                        roomUtils.sysAdDao().insertSysAd(data);
                    }
                })
                .start();
    }

    public void getSysAdList(final String type, MutableLiveData<List<SysAd>> bannerLiveData) {
        new HttpTask<List<SysAd>>()
                .netLive(bannerLiveData)
                .localLive(new ClientTask<List<SysAd>>() {
                    @Override
                    public List<SysAd> reqInSQLite(int pageIndex) {
                        return roomUtils.sysAdDao().getAdByType(type);
                    }
                })
                .call(httpUtils.create(SysAdApi.class)
                        .getSysAdList(type, UserCache.getInstance().getProvince(), UserCache.getInstance().getUserId()))
                .handle(new DataHandle<List<SysAd>>() {
                    @Override
                    public void handle(@NonNull List<SysAd> data) {
                        roomUtils.sysAdDao().insertSysAd(data);
                    }
                }).start();
    }

    public void getIndexFunctions(MutableLiveData<List<FunctionItem>> functionLiveData) {
        String versionCode;
        if (Build.VERSION.SDK_INT >= 28) {
            versionCode = String.valueOf(SysUtils.getInstance().getPackageInfo().getLongVersionCode());
        } else {
            versionCode = String.valueOf(SysUtils.getInstance().getPackageInfo().versionCode);
        }
        new HttpTask<List<FunctionItem>>()
                .netLive(functionLiveData)
                .localLive(new ClientTask<List<FunctionItem>>() {
                    @Override
                    public List<FunctionItem> reqInSQLite(int pageIndex) {
                        return roomUtils.functionItemDao().getIndexFunctions();
                    }
                })
                .call(httpUtils.create(SysAdApi.class).getIndexFunctions(versionCode))
                .handle(new DataHandle<List<FunctionItem>>() {
                    @Override
                    public void handle(@NonNull List<FunctionItem> data) {
                        roomUtils.functionItemDao().del();
                        roomUtils.functionItemDao().insert(data);
                    }
                }).start();
    }
}
