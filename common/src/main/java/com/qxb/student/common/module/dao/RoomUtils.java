package com.qxb.student.common.module.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.qxb.student.common.module.bean.Test;
import com.qxb.student.common.utils.Singleton;

public class RoomUtils {

    private static final Singleton<RoomUtils> SINGLETON = new Singleton<RoomUtils>() {
        @Override
        protected RoomUtils create() {
            return new RoomUtils();
        }
    };

    public static RoomUtils getInstance() {
        return SINGLETON.get();
    }

    private final String DATABASE_NAME = "qxb";
    private DefaultDatabase database;

    public void init(Context context) {
        database = Room.databaseBuilder(context, DefaultDatabase.class, DATABASE_NAME).build();
    }

    @Database(entities = {Test.class}, version = 1)
    private abstract class DefaultDatabase extends RoomDatabase {
    }

}
