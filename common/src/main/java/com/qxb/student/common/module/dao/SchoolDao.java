package com.qxb.student.common.module.dao;

import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.qxb.student.common.module.bean.School;

import java.util.List;

@Dao
public interface SchoolDao {

    @Query("SELECT * FROM TB_SCHOOL")
    MutableLiveData<List<School>> getRecommendedColleges();

    @Insert
    void insertColleges(List<School> list);
}
