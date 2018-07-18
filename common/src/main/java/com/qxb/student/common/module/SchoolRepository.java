package com.qxb.student.common.module;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.qxb.student.common.http.HttpResponse;
import com.qxb.student.common.http.HttpUtils;
import com.qxb.student.common.listener.TRunnable;
import com.qxb.student.common.module.api.SchoolApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.School;
import com.qxb.student.common.module.dao.RoomUtils;
import com.qxb.student.common.utils.ExecutorUtils;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

/**
 * 学校数据仓库
 *
 * @author winky
 * @date
 */
public class SchoolRepository {

    private final RoomUtils roomUtils = RoomUtils.getInstance();
    private final ExecutorUtils executorUtils = ExecutorUtils.getInstance();

    public LiveData<List<School>> getSchoolLiveData(String province) {
        final MutableLiveData<List<School>> finalLiveData = new MutableLiveData<>();
        Observable<ApiModel<List<School>>> observable = HttpUtils.create(SchoolApi.class).getRecommendedCollegeList(province);
        HttpUtils.getInstance().request(observable, new HttpResponse<ApiModel<List<School>>>() {
            @Override
            public void success(ApiModel<List<School>> result) {
                if (result.getCode() == 1) {
                    finalLiveData.setValue(result.getData());
                    executorUtils.addTask(new TRunnable<List<School>>(result.getData()) {
                        @Override
                        public void run(List<School> schools) {
                            roomUtils.schoolDao().insertColleges(schools);
                        }
                    });
                }
            }

            @Override
            public void failed(Throwable throwable) {

            }
        });
        return finalLiveData;
    }
}
