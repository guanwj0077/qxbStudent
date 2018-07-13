package com.qxb.student.common.module.api;

import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.School;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface SchoolApi {

    @POST("school/listIndex")
    Observable<ApiModel<List<School>>> getRecommendedColleges(@Field("stu_id") String studId, @Field("province") String provinceCode);

}
