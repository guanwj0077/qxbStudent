package com.qxb.student.common.module.dao;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.qxb.student.common.module.bean.School;

import java.util.List;

/**
 * 学校数据操作
 *
 * @author winky
 * @date 2018/07/18
 */
@Dao
public interface SchoolDao {

    /**
     * 首页推荐学校
     * @return 学校集合
     */
    @Query("SELECT * FROM School")
    List<School> getRecommendedColleges();

    /**
     * 学校列表数据
     *
     * @param list 学校集合
     */
    @Insert
    void insertColleges(List<School> list);
}
