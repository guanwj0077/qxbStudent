package com.qxb.student.common.module;

import android.arch.lifecycle.MutableLiveData;

import com.qxb.student.common.http.task.HttpTask;
import com.qxb.student.common.module.api.SchoolApi;
import com.qxb.student.common.module.bean.CollegeMajorRecruit;
import com.qxb.student.common.utils.UserCache;

/**
 * @author winky
 * @date 2018/8/9
 */
public class SchoolMajorRepository extends BaseRepository {

    public void getSchoolProfessNew(MutableLiveData<CollegeMajorRecruit> majorRecruitLiveData, String majorId) {
        new HttpTask<CollegeMajorRecruit>()
                .call(httpUtils.create(SchoolApi.class).getSchoolProfessNew(majorId, UserCache.getInstance().getUserId(), UserCache.getInstance().getProvince()))
                .netLive(majorRecruitLiveData)
                .start();
    }
}
