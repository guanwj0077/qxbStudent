package com.qxb.student.common.module;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.qxb.student.common.http.PostApiConsumer;
import com.qxb.student.common.http.PostConsumer;
import com.qxb.student.common.http.SubscribeObj;
import com.qxb.student.common.module.api.SchoolApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.School;

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

    public LiveData<School> getSchoolById(String schoolId) {

        return schoolLiveData;
    }

    @Override
    public void onCleared() {
        schoolListLiveData = null;
        schoolLiveData = null;
    }
}
