package com.qxb.student.common.module.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.qxb.student.common.module.bean.School;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

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
     *
     * @return 学校集合
     */
    @Query("SELECT * FROM School")
    List<School> getRecommendedColleges();

    /**
     * 学校列表数据
     *
     * @param list 学校集合
     */
    @Insert(onConflict = REPLACE)
    void insertColleges(List<School> list);
    /**
     * 插入学校数据
     *
     * @param school 学校信息
     */
    @Insert(onConflict = REPLACE)
    void insertColleges(School school);

    /**
     * 大学详情页
     *
     * @param school_id
     * @return
     */
    @Query("SELECT * FROM School WHERE id=:school_id")
    School getSchoolById(String school_id);
}
