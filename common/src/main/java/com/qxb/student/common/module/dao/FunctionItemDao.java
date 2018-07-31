package com.qxb.student.common.module.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.qxb.student.common.module.bean.FunctionItem;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * @author winky
 * @date 2018/7/26
 */
@Dao
public interface FunctionItemDao {

    /**
     * 首页功能
     */
    @Query("SELECT * FROM FunctionItem")
    List<FunctionItem> getIndexFunctions();

    /**
     * 学校列表数据
     *
     * @param list 学校集合
     */
    @Insert(onConflict = REPLACE)
    void insert(List<FunctionItem> list);

    @Query("DELETE FROM FunctionItem")
    void del();

}
