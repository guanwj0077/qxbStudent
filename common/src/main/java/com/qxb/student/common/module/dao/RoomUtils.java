package com.qxb.student.common.module.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.qxb.student.common.module.bean.School;
import com.qxb.student.common.module.bean.Test;
import com.qxb.student.common.utils.ContextUtils;
import com.qxb.student.common.utils.Singleton;

@Database(entities = {School.class}, version = 1, exportSchema = false)
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

    public abstract SchoolDao schoolDao();

}
