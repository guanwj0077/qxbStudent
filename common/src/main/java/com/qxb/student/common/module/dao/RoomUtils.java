package com.qxb.student.common.module.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.qxb.student.common.module.bean.School;
import com.qxb.student.common.module.bean.SysAd;
import com.qxb.student.common.module.bean.tab.HttpCache;
import com.qxb.student.common.utils.ContextUtils;
import com.qxb.student.common.utils.Singleton;

/**
 * Room数据库工具类
 *
 * @author winky
 */
@Database(entities = {HttpCache.class, School.class, SysAd.class}, version = 1, exportSchema = false)
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

    /**
     * 获取广告操作
     *
     * @return SchoolDao
     */
    public abstract SysAdDao sysAdDao();
}
