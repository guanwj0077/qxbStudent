package com.qxb.student.common.module.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.qxb.student.common.module.bean.Test;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface TestDao {

    @Query("SELECT * FROM TB_TEST")
    LiveData<List<Test>> getAll();

    @Query("SELECT * FROM TB_TEST")
    List<Test> getAl();

    @Insert(onConflict = REPLACE)
    void save(Test info);

    @Query("SELECT * FROM TB_TEST WHERE id = :id")
    LiveData<Test> load(String id);

    @Insert
    void insertAll(List<Test> list);

    @Delete
    void delete(Test list);
}
