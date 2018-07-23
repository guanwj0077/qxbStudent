package com.qxb.student.common.module;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.qxb.student.common.Config;
import com.qxb.student.common.http.PostApiConsumer;
import com.qxb.student.common.http.PostConsumer;
import com.qxb.student.common.http.SubscribeObj;
import com.qxb.student.common.module.api.SchoolApi;
import com.qxb.student.common.module.api.SchoolNewsApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.School;
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

    private MutableLiveData<List<School>> schoolListLiveData = new MutableLiveData<>();
    private MutableLiveData<School> schoolLiveData = new MutableLiveData<>();
    private MutableLiveData<List<SchoolVideo>> schoolVideoLiveData = new MutableLiveData<>();
    private MutableLiveData<List<SchoolNews>> schoolNewsLiveData = new MutableLiveData<>();

    public LiveData<List<School>> getSchoolLiveData() {
        String province = "420000";
        Observable<ApiModel<List<School>>> observable = httpUtils.convert(httpUtils.create(SchoolApi.class).getRecommendedCollegeList(province),
                new Consumer<ApiModel<List<School>>>() {
                    @Override
                    public void accept(ApiModel<List<School>> listApiModel) {
                        httpUtils.addCache(School.class, listApiModel.getCacheTime());
                        roomUtils.schoolDao().insertColleges(listApiModel.getData());
                    }
                });
        httpUtils.request(schoolListLiveData, new SubscribeObj<List<School>>() {
            @Override
            protected List<School> queryLocal() {
                return roomUtils.schoolDao().getRecommendedColleges();
            }
        }, observable);
        return schoolListLiveData;
    }

    public LiveData<School> getSchoolById(final String schoolId) {
        String studId = "26";
        Observable<ApiModel<School>> observable = httpUtils.convert(httpUtils.create(SchoolApi.class).getSchoolById(schoolId, studId),
                new Consumer<ApiModel<School>>() {
                    @Override
                    public void accept(ApiModel<School> apiModel) {
                        httpUtils.addCache(School.class, apiModel.getCacheTime());
                        roomUtils.schoolDao().insertColleges(apiModel.getData());
                    }
                });
        httpUtils.request(schoolLiveData, new SubscribeObj<School>() {
            @Override
            protected School queryLocal() {
                return roomUtils.schoolDao().querySchoolById(schoolId);
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
