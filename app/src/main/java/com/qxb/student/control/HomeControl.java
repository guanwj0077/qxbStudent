package com.qxb.student.control;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.qxb.student.common.module.AdvertRepository;
import com.qxb.student.common.module.SchoolRepository;
import com.qxb.student.common.module.bean.FunctionItem;
import com.qxb.student.common.module.bean.RecomSchool;
import com.qxb.student.common.module.bean.SysAd;

import java.util.List;

/**
 * 首页数据
 *
 * @author winky
 */
public class HomeControl extends AndroidViewModel {

    private SchoolRepository schoolRepository = new SchoolRepository();
    private AdvertRepository advertRepository = new AdvertRepository();

    public HomeControl(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<RecomSchool>> getSchoolLiveData() {
        return schoolRepository.getSchoolLiveData();
    }

    public LiveData<String> getLiveAdvert() {
        return advertRepository.getLiveHomeAd();
    }

    public LiveData<List<SysAd>> getHomeBanner() {
        return advertRepository.getHomeBanner();
    }

    public LiveData<List<FunctionItem>> getIndexFunctions() {
        return advertRepository.getIndexFunctions();
    }

    public LiveData<List<SysAd>> getTopLines(){
        return advertRepository.getSysAdList("studying_headlines");
    }

    @Override
    protected void onCleared() {
        schoolRepository.onCleared();
        schoolRepository = null;
        advertRepository.onCleared();
        advertRepository = null;
    }
}
