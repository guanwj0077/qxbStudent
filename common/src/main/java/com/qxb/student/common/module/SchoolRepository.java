package com.qxb.student.common.module;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.qxb.student.common.http.HttpResponse;
import com.qxb.student.common.http.HttpUtils;
import com.qxb.student.common.module.api.SchoolApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.School;
import com.qxb.student.common.module.dao.RoomUtils;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class SchoolRepository {

    private RoomUtils roomUtils = RoomUtils.getInstance();

    public LiveData<List<School>> getSchoolLiveData(String studId, String proinvceCode) {
        School school1 = new School();
        school1.setSchool_name("AAAAA");
        school1.setCoverRealPath("");
        School school2 = new School();
        school2.setSchool_name("BBBBB");
        school2.setCoverRealPath("");
        School school3 = new School();
        school3.setSchool_name("CCCCC");
        school3.setCoverRealPath("");
        School school4 = new School();
        school4.setSchool_name("DDDDD");
        school4.setCoverRealPath("");
        School school5 = new School();
        school5.setSchool_name("EEEEE");
        school5.setCoverRealPath("");
        MutableLiveData liveData = new MutableLiveData<List<School>>();
        liveData.setValue(Arrays.asList(school1, school2, school3, school4, school5));
        return liveData;
//        Observable<ApiModel<List<School>>> observable = HttpUtils.create(SchoolApi.class).getRecommendedColleges(studId, proinvceCode);
//        HttpUtils.getInstance().request(observable, new HttpResponse<ApiModel<List<School>>>() {
//            @Override
//            public void success(ApiModel<List<School>> result) {
//                if (result.getCODE() == 1) {
//                    roomUtils.schoolDao().insertColleges(result.getData());
//                }
//            }
//
//            @Override
//            public void failed(Throwable throwable) {
//
//            }
//        });
//        return roomUtils.schoolDao().getRecommendedColleges();
    }
}
