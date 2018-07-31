package com.qxb.student.common.module.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.qxb.student.common.module.bean.RecomSchool;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * 学校数据操作
 *
 * @author winky
 * @date 2018/07/18
 */
@Dao
public interface RecomSchoolDao {

    /**
     * 首页推荐学校
     *
     * @return 学校集合
     */
    @Query("SELECT * FROM RecomSchool")
    List<RecomSchool> getRecommendedColleges();

    /**
     * 学校列表数据
     *
     * @param list 学校集合
     */
    @Insert(onConflict = REPLACE)
    void insertColleges(List<RecomSchool> list);

}
