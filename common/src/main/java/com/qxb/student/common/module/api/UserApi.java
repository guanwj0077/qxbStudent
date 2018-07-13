package com.qxb.student.common.module.api;

import com.qxb.student.common.module.bean.Test;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UserApi {

    /**
     * 获取信息
     * @return
     */
    @GET("/startup/?key=7fed97d2186ea83c78d3e4fd0b58ab56&num=30")
    Observable<Test> getInfo();
}
