package com.qxb.student.common.module.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.qxb.student.common.module.bean.RecomSchool;
import com.qxb.student.common.module.bean.SchoolDetail;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * @author winky
 * @date 2018/7/24
 */
@Dao
public interface SchoolDetailDao {

    /**
     * 插入学校数据
     *
     * @param schoolDetail 学校信息
     */
    @Insert(onConflict = REPLACE)
    void insertColleges(SchoolDetail schoolDetail);

    /**
     * 大学详情页
     *
     * @param school_id
     * @return
     */
    @Query("SELECT * FROM SchoolDetail WHERE id=:school_id")
    SchoolDetail querySchoolById(String school_id);
}
