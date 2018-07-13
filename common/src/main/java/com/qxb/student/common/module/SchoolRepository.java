package com.qxb.student.common.module;

import android.arch.lifecycle.MutableLiveData;

import com.qxb.student.common.http.HttpResponse;
import com.qxb.student.common.http.HttpUtils;
import com.qxb.student.common.module.api.SchoolApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.School;
import com.qxb.student.common.module.dao.RoomUtils;

import java.util.List;

public class SchoolRepository {

    private RoomUtils roomUtils = RoomUtils.getInstance();

    public MutableLiveData<List<School>> getSchoolLiveData(String studId, String proinvceCode) {
        HttpUtils.getInstance().request(HttpUtils.create(SchoolApi.class).getRecommendedColleges(studId, proinvceCode), new HttpResponse<ApiModel<List<School>>>() {
            @Override
            public void success(ApiModel<List<School>> result) {
                if (result.getCODE() == 1) {
                    roomUtils.getDefDatabase().schoolDao().insertColleges(result.getData());
                }
            }

            @Override
            public void failed(Throwable throwable) {

            }
        });
        return roomUtils.getDefDatabase().schoolDao().getRecommendedColleges();
    }
}
