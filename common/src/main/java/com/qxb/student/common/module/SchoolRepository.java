package com.qxb.student.common.module;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.qxb.student.common.Config;
import com.qxb.student.common.http.task.ApiModelHandle;
import com.qxb.student.common.http.task.ClientTask;
import com.qxb.student.common.http.task.DataHandle;
import com.qxb.student.common.http.task.HttpTask;
import com.qxb.student.common.listener.TRunnable;
import com.qxb.student.common.module.api.RongyUserApi;
import com.qxb.student.common.module.api.SchoolApi;
import com.qxb.student.common.module.api.SchoolNewsApi;
import com.qxb.student.common.module.api.UserStudentApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.MajorBat;
import com.qxb.student.common.module.bean.MajorSubject;
import com.qxb.student.common.module.bean.RecomSchool;
import com.qxb.student.common.module.bean.RongyUser;
import com.qxb.student.common.module.bean.SchoolDetail;
import com.qxb.student.common.module.bean.SchoolNews;
import com.qxb.student.common.module.bean.SchoolVideo;
import com.qxb.student.common.module.bean.ScoreBat;
import com.qxb.student.common.module.bean.ScoreSubject;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.utils.ExecutorUtils;
import com.qxb.student.common.utils.UserCache;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * 学校数据仓库
 *
 * @author winky
 * @date
 */
public class SchoolRepository extends BaseRepository {

    public void getSchoolLiveData(MutableLiveData<List<RecomSchool>> schoolListLiveData) {
        new HttpTask<List<RecomSchool>>()
                .netLive(schoolListLiveData)
                .localLive(new ClientTask<List<RecomSchool>>() {
                    @Override
                    public List<RecomSchool> reqInSQLite(int pageIndex) {
                        return roomUtils.schoolDao().getRecommendedColleges();
                    }
                })
                .call(httpUtils.create(SchoolApi.class)
                        .getRecommendedCollegeList(UserCache.getInstance().getProvince()))
                .handle(new DataHandle<List<RecomSchool>>() {
                    @Override
                    public void handle(@NonNull List<RecomSchool> data) {
                        roomUtils.schoolDao().insertColleges(data);
                    }
                })
                .start();
    }

    public void getSchoolById(final String schoolId, MutableLiveData<SchoolDetail> schoolLiveData) {
        new HttpTask<SchoolDetail>()
                .netLive(schoolLiveData)
                .localLive(new ClientTask<SchoolDetail>() {
                    @Override
                    public SchoolDetail reqInSQLite(int pageIndex) {
                        return roomUtils.schoolDetailDao().querySchoolById(schoolId);
                    }
                })
                .call(httpUtils.create(SchoolApi.class).getSchoolById(schoolId, UserCache.getInstance().getUserId()))
                .handle(new DataHandle<SchoolDetail>() {
                    @Override
                    public void handle(@NonNull SchoolDetail data) {
                        roomUtils.schoolDetailDao().insertColleges(data);
                    }
                }).start();
    }

    public void getSchoolVideoList(String schoolId, String rows, String page, MutableLiveData<List<SchoolVideo>> schoolVideoLiveData) {
        new HttpTask<List<SchoolVideo>>()
                .netLive(schoolVideoLiveData)
                .call(httpUtils.create(SchoolApi.class).schoolVideoList(schoolId, rows, page))
                .start();
    }

    public void getSchoolNews(String schoolId, String type, String title, String page, MutableLiveData<List<SchoolNews>> schoolNewsLiveData) {
        new HttpTask<List<SchoolNews>>()
                .netLive(schoolNewsLiveData)
                .call(httpUtils.create(SchoolNewsApi.class).getSchoolNewslist(schoolId, type, title, page))
                .start();
    }

    public void getSchoolRecruitMajor(String schoolId, final MutableLiveData<List<MajorBat>> majorLiveData) {
        ExecutorUtils.getInstance().addTask(new TRunnable<String>(schoolId) {
            @Override
            public void run(String schoolId) {
                try {
                    Call<ApiModel<List<MajorSubject>>> call = httpUtils.create(SchoolApi.class)
                            .getSchoolRecruitMajor(schoolId, UserCache.getInstance().getProvince());
                    ApiModel<List<MajorSubject>> apiModel = call.execute().body();
                    if ((apiModel != null ? apiModel.getCode() : 0) == Config.HTTP_SUCCESS) {
                        User user = UserCache.getInstance().getUser();
                        if (user == null || !user.isLiberalArt()) {
                            if (apiModel.getData().size() >= 2) {
                                majorLiveData.postValue(apiModel.getData().get(1).getData());
                            }
                        } else {
                            if (apiModel.getData().size() >= 1) {
                                majorLiveData.postValue(apiModel.getData().get(0).getData());
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void getSchoolScore(String schoolId, final MutableLiveData<List<ScoreBat>> scoreLiveData) {
        ExecutorUtils.getInstance().addTask(new TRunnable<String>(schoolId) {
            @Override
            public void run(String schoolId) {
                try {
                    Call<ApiModel<List<ScoreSubject>>> call = httpUtils.create(SchoolApi.class)
                            .getSchoolScore(schoolId, UserCache.getInstance().getProvince());
                    ApiModel<List<ScoreSubject>> apiModel = call.execute().body();
                    if ((apiModel != null ? apiModel.getCode() : 0) == Config.HTTP_SUCCESS && apiModel.getData().size() == 2) {
                        User user = UserCache.getInstance().getUser();
                        if (user == null || !user.isLiberalArt()) {
                            if (apiModel.getData().size() >= 2) {
                                scoreLiveData.postValue(apiModel.getData().get(1).getData());
                            }
                        } else {
                            if (apiModel.getData().size() >= 1) {
                                scoreLiveData.postValue(apiModel.getData().get(0).getData());
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void saveStudentRegistration(String schoolId, final MutableLiveData<Boolean> registrationLiveData) {
        new HttpTask<String>()
                .call(httpUtils.create(UserStudentApi.class).saveStudentRegistration(UserCache.getInstance().getUserId(), schoolId))
                .apiModel(new ApiModelHandle<String>() {
                    @Override
                    public void handle(@NonNull ApiModel<String> apiModel, int pageIndex) {
                        registrationLiveData.postValue(apiModel.getCode() == Config.HTTP_SUCCESS);
                    }
                }).start();

    }

    public void teacherListBySchoolId(String schoolId, final MutableLiveData<ApiModel<List<RongyUser>>> rongUserLiveData) {
        new HttpTask<List<RongyUser>>()
                .call(httpUtils.create(RongyUserApi.class).teacherListBySchoolId(schoolId))
                .apiModel(new ApiModelHandle<List<RongyUser>>() {
                    @Override
                    public void handle(@NonNull ApiModel<List<RongyUser>> apiModel, int pageIndex) {
                        rongUserLiveData.postValue(apiModel);
                    }
                })
                .start();
    }
}
