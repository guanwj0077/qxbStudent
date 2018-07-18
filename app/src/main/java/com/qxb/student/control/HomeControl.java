package com.qxb.student.control;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.qxb.student.common.module.AdvertRepository;
import com.qxb.student.common.module.SchoolRepository;
import com.qxb.student.common.module.bean.School;
import com.qxb.student.common.module.bean.SysAd;

import java.util.List;

public class HomeControl extends AndroidViewModel {

    private SchoolRepository schoolRepository = new SchoolRepository();
    private AdvertRepository advertRepository = new AdvertRepository();


    public HomeControl(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<School>> getSchoolLiveData() {
        String proinvceCode = "420000";
        return schoolRepository.getSchoolLiveData(proinvceCode);
    }

    public LiveData<String> getLiveAdvert() {
        return advertRepository.getLiveHomeAd();
    }

    public LiveData<List<SysAd>> getHomeBanner() {
        return advertRepository.getHomeBanner("420000");
    }
}
