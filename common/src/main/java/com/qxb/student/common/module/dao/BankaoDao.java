package com.qxb.student.common.module.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.qxb.student.common.module.bean.Bankao;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * @author winky
 * @date 2018/7/27
 */
@Dao
public interface BankaoDao {

    /**
     * 根据广告类型查广告
     *
     * @param type 广告类型
     * @return 广告集合
     */
    @Query("SELECT * FROM Bankao WHERE type=:type")
    List<Bankao> getBankaoCache(String type);

    @Query("SELECT * FROM Bankao WHERE type=:type limit :start,:end")
    List<Bankao> getBankaoCache(String type, int start, int end);

    /**
     * 插入广告
     *
     * @param list 广告集合
     */
    @Insert(onConflict = REPLACE)
    void insert(List<Bankao> list);

    @Query("DELETE FROM Bankao")
    void deleteAll();
}
