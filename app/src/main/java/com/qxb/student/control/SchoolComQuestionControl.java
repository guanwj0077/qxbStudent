package com.qxb.student.control;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.qxb.student.common.module.QuestionRepository;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.CollegeQuestion;

import java.util.List;

/**
 * @author winky
 * @date 2018/8/10
 */
public class SchoolComQuestionControl extends AndroidViewModel {

    public SchoolComQuestionControl(@NonNull Application application) {
        super(application);
    }

    private MutableLiveData<ApiModel<List<CollegeQuestion>>> liveData = new MutableLiveData<>();
    private QuestionRepository questionRepository = new QuestionRepository();

    @Override
    protected void onCleared() {
        super.onCleared();
        liveData = null;
        questionRepository = null;
    }

    public MutableLiveData<ApiModel<List<CollegeQuestion>>> getLiveData() {
        return liveData;
    }

    public void schoolQuestionList(String schoolId, String type, int page) {
        questionRepository.schoolQuestionList(liveData, schoolId, type, "", page);
    }
}
