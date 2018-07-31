package com.qxb.student.common.module.dao;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.qxb.student.common.module.bean.SysAd;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * 广告
 *
 * @author winky
 * @date 2018/7/19
 */
@Dao
public interface SysAdDao {

    /**
     * 根据广告类型查广告
     *
     * @param type 广告类型
     * @return 广告集合
     */
    @Query("SELECT * FROM SysAd WHERE type=:type")
    List<SysAd> getAdByType(String type);

    /**
     * 插入广告
     *
     * @param list 广告集合
     */
    @Insert(onConflict = REPLACE)
    void insertSysAd(List<SysAd> list);
}
