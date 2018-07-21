package com.qxb.student.control;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.qxb.student.common.module.SchoolRepository;
import com.qxb.student.common.module.bean.School;

/**
 * 学校
 *
 * @author winky
 * @date 2018/7/20
 */
public class SchoolControl extends AndroidViewModel {

    public SchoolControl(@NonNull Application application) {
        super(application);
    }

    private SchoolRepository schoolRepository = new SchoolRepository();

    public LiveData<School> getSchoolById(String schoolId) {
        return schoolRepository.getSchoolById(schoolId);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        schoolRepository = null;
    }
}
