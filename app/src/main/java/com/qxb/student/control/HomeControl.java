package com.qxb.student.control;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
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
    private MutableLiveData<List<RecomSchool>> schoolListLiveData = new MutableLiveData<>();
    private MutableLiveData<String> adHomeLive = new MutableLiveData<>();
    private MutableLiveData<List<SysAd>> bannerLiveData = new MutableLiveData<>();
    private MutableLiveData<List<FunctionItem>> functionLiveData = new MutableLiveData<>();

    public HomeControl(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void onCleared() {
        schoolListLiveData = null;
        adHomeLive = null;
        bannerLiveData = null;
        functionLiveData = null;
        schoolRepository = null;
        advertRepository = null;
    }

    public LiveData<List<RecomSchool>> getSchoolLiveData() {
        schoolRepository.getSchoolLiveData(schoolListLiveData);
        return schoolListLiveData;
    }

    public LiveData<String> getLiveAdvert() {
        advertRepository.getLiveHomeAd(adHomeLive);
        return adHomeLive;
    }

    public LiveData<List<SysAd>> getHomeBanner() {
        advertRepository.getHomeBanner(bannerLiveData);
        return bannerLiveData;
    }

    public LiveData<List<FunctionItem>> getIndexFunctions() {
        advertRepository.getIndexFunctions(functionLiveData);
        return functionLiveData;
    }

    public LiveData<List<SysAd>> getTopLines() {
        advertRepository.getSysAdList("studying_headlines", bannerLiveData);
        return bannerLiveData;
    }
}
