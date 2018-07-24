package com.qxb.student.common.module;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.qxb.student.common.Config;
import com.qxb.student.common.http.SubscribeObj;
import com.qxb.student.common.module.api.SchoolApi;
import com.qxb.student.common.module.api.SchoolNewsApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.RecomSchool;
import com.qxb.student.common.module.bean.SchoolDetail;
import com.qxb.student.common.module.bean.SchoolNews;
import com.qxb.student.common.module.bean.SchoolVideo;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * 学校数据仓库
 *
 * @author winky
 * @date
 */
public class SchoolRepository extends BaseRepository {

    private MutableLiveData<List<RecomSchool>> schoolListLiveData = new MutableLiveData<>();
    private MutableLiveData<SchoolDetail> schoolLiveData = new MutableLiveData<>();
    private MutableLiveData<List<SchoolVideo>> schoolVideoLiveData = new MutableLiveData<>();
    private MutableLiveData<List<SchoolNews>> schoolNewsLiveData = new MutableLiveData<>();

    public LiveData<List<RecomSchool>> getSchoolLiveData() {
        String province = "420000";
        Observable<ApiModel<List<RecomSchool>>> observable = httpUtils.convert(httpUtils.create(SchoolApi.class).getRecommendedCollegeList(province),
                new Consumer<ApiModel<List<RecomSchool>>>() {
                    @Override
                    public void accept(ApiModel<List<RecomSchool>> listApiModel) {
                        httpUtils.addCache(RecomSchool.class, listApiModel.getCacheTime());
                        roomUtils.schoolDao().insertColleges(listApiModel.getData());
                    }
                });
        httpUtils.request(schoolListLiveData, new SubscribeObj<List<RecomSchool>>() {
            @Override
            protected List<RecomSchool> queryLocal() {
                return roomUtils.schoolDao().getRecommendedColleges();
            }
        }, observable);
        return schoolListLiveData;
    }

    public LiveData<SchoolDetail> getSchoolById(final String schoolId) {
        String studId = "26";
        Observable<ApiModel<SchoolDetail>> observable = httpUtils.convert(httpUtils.create(SchoolApi.class).getSchoolById(schoolId, studId),
                new Consumer<ApiModel<SchoolDetail>>() {
                    @Override
                    public void accept(ApiModel<SchoolDetail> apiModel) {
                        roomUtils.schoolDetailDao().insertColleges(apiModel.getData());
                    }
                });
        httpUtils.request(schoolLiveData, new SubscribeObj<SchoolDetail>() {
            @Override
            protected SchoolDetail queryLocal() {
                return roomUtils.schoolDetailDao().querySchoolById(schoolId);
            }
        }, observable);
        return schoolLiveData;
    }

    public LiveData<List<SchoolVideo>> getSchoolVideoList(String schoolId, String rows, String page) {
        httpUtils.convert(httpUtils.create(SchoolApi.class).schoolVideoList(schoolId, rows, page),
                new Consumer<ApiModel<List<SchoolVideo>>>() {
                    @Override
                    public void accept(ApiModel<List<SchoolVideo>> apiModel) {
                        if (apiModel.getCode() == Config.HTTP_SUCCESS) {
                            schoolVideoLiveData.postValue(apiModel.getData());
                        }
                    }
                }).subscribe();
        return schoolVideoLiveData;
    }

    public LiveData<List<SchoolNews>> getSchoolNews(String schoolId, String type, String title, String page) {
        httpUtils.convert(httpUtils.create(SchoolNewsApi.class).getSchoolNewslist(schoolId, type, title, page),
                new Consumer<ApiModel<List<SchoolNews>>>() {
                    @Override
                    public void accept(ApiModel<List<SchoolNews>> apiModel) {
                        if (apiModel.getCode() == Config.HTTP_SUCCESS) {
                            schoolNewsLiveData.postValue(apiModel.getData());
                        }
                    }
                }).subscribe();
        return schoolNewsLiveData;
    }

    @Override
    public void onCleared() {
        schoolListLiveData = null;
        schoolLiveData = null;
    }
}
