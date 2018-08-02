package com.qxb.student.common.http;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.support.annotation.NonNull;

import com.qxb.student.common.module.dao.RoomUtils;
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
    //    // 提供获取retrofit对象

    private static HttpConfigure httpConfigure;

    public void setHttpConfigure(HttpConfigure httpConfigure) {
        HttpUtils.httpConfigure = httpConfigure;
    }

    /**
     * 数据库实例
     */
    protected static final RoomUtils roomUtils = RoomUtils.getInstance();

    public <T> T create(Class<T> clazz) {
        return httpConfigure.getRetrofit().create(clazz);
    }

    /**
     * SupportSQLiteStatement statement = roomUtils.compileStatement("delete from " + clazz.getSimpleName());
     * statement.execute();
     */
}
