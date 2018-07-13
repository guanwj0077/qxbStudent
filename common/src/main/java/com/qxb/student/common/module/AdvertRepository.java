package com.qxb.student.common.module;

import android.arch.lifecycle.MutableLiveData;

import com.qxb.student.common.http.HttpResponse;
import com.qxb.student.common.http.HttpUtils;
import com.qxb.student.common.module.api.AdvertApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.dao.RoomUtils;

public class AdvertRepository {

    private RoomUtils roomUtils = RoomUtils.getInstance();

    public String getLiveHomeAd() {
        HttpUtils.getInstance().request(HttpUtils.create(AdvertApi.class).getLiveHomeAd(), new HttpResponse<ApiModel<String>>() {
            @Override
            public void success(ApiModel<String> result) {
                if (result.getCODE() == 1) {

                }
            }

            @Override
            public void failed(Throwable throwable) {

            }
        });
        return "";
    }
}
