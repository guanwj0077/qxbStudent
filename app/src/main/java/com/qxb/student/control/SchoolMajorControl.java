package com.qxb.student.control;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.qxb.student.common.module.SchoolMajorRepository;
import com.qxb.student.common.module.bean.CollegeMajorRecruit;

/**
 * @author winky
 * @date 2018/8/9
 */
public class SchoolMajorControl extends AndroidViewModel {

    public SchoolMajorControl(@NonNull Application application) {
        super(application);
    }

    private SchoolMajorRepository schoolMajorRepository = new SchoolMajorRepository();
    private MutableLiveData<CollegeMajorRecruit> majorRecruitLiveData = new MutableLiveData<>();

    @Override
    protected void onCleared() {
        super.onCleared();
        schoolMajorRepository = null;
    }

    public MutableLiveData<CollegeMajorRecruit> getMajorRecruit() {
        return majorRecruitLiveData;
    }

    public void getSchoolProfessNew(String majorId) {
        schoolMajorRepository.getSchoolProfessNew(majorRecruitLiveData, majorId);
    }


}
