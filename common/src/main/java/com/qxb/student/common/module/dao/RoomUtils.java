package com.qxb.student.common.module.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.qxb.student.common.module.bean.School;
import com.qxb.student.common.module.bean.Test;
import com.qxb.student.common.module.bean.tab.HttpCache;
import com.qxb.student.common.utils.ContextUtils;
import com.qxb.student.common.utils.Singleton;

/**
 * Room数据库工具类
 *
 * @author winky
 */
@Database(entities = {HttpCache.class, School.class}, version = 1, exportSchema = false)
public abstract class RoomUtils extends RoomDatabase {

    private static final String DATABASE_NAME = "qxb.db";

    private static final Singleton<RoomUtils> SINGLETON = new Singleton<RoomUtils>() {
        @Override
        protected RoomUtils create() {
            return Room.databaseBuilder(ContextUtils.getInstance().getContext(), RoomUtils.class, DATABASE_NAME).build();
        }
    };

    public static RoomUtils getInstance() {
        return SINGLETON.get();
    }

    /**
     * 请求缓存记录
     *
     * @return HttpCacheDao
     */
    public abstract HttpCacheDao httpCacheDao();

    /**
     * 获取学校操作
     *
     * @return SchoolDao
     */
    public abstract SchoolDao schoolDao();


    private HttpCacheDao httpCacheDao = httpCacheDao();

    /**
     * 检查数据缓存到期
     *
     * @param clazz 表实体
     * @return 是否需要请求新的数据
     */
    public boolean checkCacheTime(@NonNull Class<?> clazz) {
        HttpCache httpCache = httpCacheDao.queryByEntity(clazz.getName());
        if (httpCache == null || System.currentTimeMillis() >= httpCache.getTime()) {
            SupportSQLiteStatement statement = compileStatement("delete from " + clazz.getSimpleName());
            statement.execute();
            return true;
        } else {
            return false;
        }
    }

    /**
     * 添加到缓存
     *
     * @param clazz 表实体
     */
    public void addCache(@NonNull Class<?> clazz, long cacheTime) {
        httpCacheDao.insert(new HttpCache(clazz.getName(), System.currentTimeMillis() + cacheTime));
//        executorUtils.addTask(new HttpCacheTask(clazz, cacheTime));
    }
}
