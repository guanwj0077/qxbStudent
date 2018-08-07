package com.qxb.student.common.module.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.qxb.student.common.module.bean.Bankao;
import com.qxb.student.common.module.bean.FunctionItem;
import com.qxb.student.common.module.bean.RecomSchool;
import com.qxb.student.common.module.bean.SchoolDetail;
import com.qxb.student.common.module.bean.SysAd;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.module.bean.tab.Configure;
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
                User.class,
                RecomSchool.class,
                SchoolDetail.class,
                SysAd.class,
                FunctionItem.class,
                Bankao.class,
                Configure.class})
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
     * 配置表
     */
    public abstract ConfigureDao configureDao();

    /**
     * 推荐院校
     */
    public abstract RecomSchoolDao schoolDao();

    /**
     * 院校详情
     */
    public abstract SchoolDetailDao schoolDetailDao();

    /**
     * 获取广告操作
     */
    public abstract SysAdDao sysAdDao();

    /**
     * 获取用户操作
     */
    public abstract UserDao userDao();

    /**
     * 获取首页功能列表
     */
    public abstract FunctionItemDao functionItemDao();

    /**
     * 伴考
     */
    public abstract BankaoDao bankaoDao();
}
