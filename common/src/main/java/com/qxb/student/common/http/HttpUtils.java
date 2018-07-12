package com.qxb.student.common.http;

import android.content.Context;

import com.qxb.student.common.utils.Singleton;

public class HttpUtils {

    private static final Singleton<HttpUtils> SINGLETON = new Singleton<HttpUtils>() {
        @Override
        protected HttpUtils create() {
            return new HttpUtils();
        }
    };

    public static HttpUtils getInstance() {
        return SINGLETON.get();
    }

    // okhttp 初始化   retrofit 初始化并设置相关适配器
    // 提供获取retrofit对象

    private static HttpConfigure httpConfigure;

    public void setHttpConfigure(HttpConfigure httpConfigure) {
        this.httpConfigure = httpConfigure;
    }



}
