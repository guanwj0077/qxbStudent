package com.qxb.student.common.module.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.qxb.student.common.module.bean.tab.Configure;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * @author winky
 * @date 2018/8/7
 */
@Dao
public interface ConfigureDao {

    /**
     * 添加配置项
     */
    @Insert(onConflict = REPLACE)
    void insert(Configure configure);

    @Query("SELECT * FROM Configure WHERE `key`=:key")
    Configure query(String key);

    @Query("DELETE FROM Configure WHERE `key`=:key")
    void delete(String key);
}
