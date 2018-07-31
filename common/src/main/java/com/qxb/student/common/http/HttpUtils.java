package com.qxb.student.common.http;

import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.tab.HttpCache;
import com.qxb.student.common.module.dao.HttpCacheDao;
import com.qxb.student.common.module.dao.RoomUtils;
import com.qxb.student.common.utils.Singleton;

import java.io.IOException;

import retrofit2.Call;

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
    /**
     * 缓存操作
     */
    private static final HttpCacheDao httpCacheDao = roomUtils.httpCacheDao();


    public <T> T create(Class<T> clazz) {
        return httpConfigure.getRetrofit().create(clazz);
    }

    /**
     * 检查数据缓存到期
     *
     * @param clazz 表实体
     * @return 是否需要请求新的数据
     */
    protected boolean checkCacheTime(@NonNull Class<?> clazz) {
        HttpCache httpCache = httpCacheDao.queryByEntity(clazz.getName());
        if (httpCache == null) {
            return true;
        }
        if (System.currentTimeMillis() >= httpCache.getTime()) {
            httpCacheDao.delete(httpCache);
            SupportSQLiteStatement statement = roomUtils.compileStatement("delete from " + clazz.getSimpleName());
            statement.execute();
            return true;
        } else {
            return false;
        }
    }

    /**
     * 添加缓存记录
     *
     * @param clazz 表实体
     */
    public void addCache(@NonNull Class<?> clazz, long cacheTime) {
        httpCacheDao.insert(new HttpCache(clazz.getName(), System.currentTimeMillis() + cacheTime));
    }
}
