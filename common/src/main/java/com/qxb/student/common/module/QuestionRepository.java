package com.qxb.student.common.module;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.qxb.student.common.http.task.ApiModelHandle;
import com.qxb.student.common.http.task.HttpTask;
import com.qxb.student.common.module.api.SchoolApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.CollegeQuestion;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author winky
 * @date 2018/8/10
 */
public class QuestionRepository extends BaseRepository {

    public void schoolQuestionList(final MutableLiveData<ApiModel<List<CollegeQuestion>>> liveData, String schoolId, String type, String title, int page) {
        Map<String, String> params = new ConcurrentHashMap<>();
        params.put("school_id", schoolId);
        params.put("enroll_type", schoolId);
        params.put("title", title);
        params.put("page", String.valueOf(page));
        params.put("rows", "10");
        new HttpTask<List<CollegeQuestion>>()
                .call(httpUtils.create(SchoolApi.class).schoolQuestionList(params))
                .apiModel(new ApiModelHandle<List<CollegeQuestion>>() {
                    @Override
                    public void handle(@NonNull ApiModel<List<CollegeQuestion>> apiModel, int pageIndex) {
                        liveData.postValue(apiModel);
                    }
                }).start();
    }
}
