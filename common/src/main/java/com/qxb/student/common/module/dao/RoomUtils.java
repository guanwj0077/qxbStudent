package com.qxb.student.common.module.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.qxb.student.common.module.bean.RecomSchool;
import com.qxb.student.common.module.bean.SchoolDetail;
import com.qxb.student.common.module.bean.SysAd;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.module.bean.tab.HttpCache;
import com.qxb.student.common.utils.ContextUtils;
import com.qxb.student.common.utils.Singleton;

/**
 * Room数据库工具类
 *
 * @author winky
 */
@Database(
        version = 1,
        exportSchema = false,
        entities = {
                HttpCache.class,
                User.class,
                RecomSchool.class,
                SchoolDetail.class,
                SysAd.class})
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
     * 推荐院校
     *
     * @return RecomSchoolDao
     */
    public abstract RecomSchoolDao schoolDao();

    /**
     * 院校详情
     */
    public abstract SchoolDetailDao schoolDetailDao();

    /**
     * 获取广告操作
     *
     * @return RecomSchoolDao
     */
    public abstract SysAdDao sysAdDao();

    /**
     * 获取用户操作
     * @return UserDao
     */
    public abstract UserDao userDao();
}
