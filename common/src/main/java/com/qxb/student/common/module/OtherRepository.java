package com.qxb.student.common.module;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.qxb.student.common.Config;
import com.qxb.student.common.Constant;
import com.qxb.student.common.http.task.ApiModelHandle;
import com.qxb.student.common.http.task.ClientTask;
import com.qxb.student.common.http.task.DataHandle;
import com.qxb.student.common.http.task.HttpTask;
import com.qxb.student.common.module.api.ChatRoomApi;
import com.qxb.student.common.module.api.RongyUserApi;
import com.qxb.student.common.module.api.UserApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.UserSchoolTeacher;
import com.qxb.student.common.module.bean.tab.Configure;
import com.qxb.student.common.utils.UserCache;

import java.util.List;

/**
 * @author winky
 * @date 2018/8/10
 */
public class OtherRepository extends BaseRepository {


    public void rongConnect(MutableLiveData<String> liveData, String userId, final boolean overdue) {
        new HttpTask<String>()
                .call(httpUtils.create(UserApi.class).token(userId))
                .netLive(liveData)
                .localLive(new ClientTask<String>() {
                    @Override
                    public String reqInSQLite(int pageIndex) {
                        if (overdue) {
                            roomUtils.configureDao().delete(Constant.CONFIG_ROOM_TOKEN);
                            return null;
                        } else {
                            return roomUtils.configureDao().query(Constant.CONFIG_ROOM_TOKEN).getValue();
                        }
                    }
                })
                .handle(new DataHandle<String>() {
                    @Override
                    public void handle(@NonNull String data) {
                        roomUtils.configureDao().insert(new Configure(Constant.CONFIG_ROOM_TOKEN, data));
                    }
                })
                .start();
    }

    public void evaluateTeacher(final MutableLiveData<Boolean> liveData, String accountId) {
        new HttpTask<String>()
                .call(httpUtils.create(ChatRoomApi.class).evaluateTeacher(accountId, UserCache.getInstance().getUserId()))
                .apiModel(new ApiModelHandle<String>() {
                    @Override
                    public void handle(@NonNull ApiModel<String> apiModel, int pageIndex) {
                        liveData.postValue(apiModel.getCode() == Config.HTTP_SUCCESS);
                    }
                }).start();
    }

    public void exchangePhone(String accountId) {
        new HttpTask<String>()
                .call(httpUtils.create(ChatRoomApi.class).exchangePhone(accountId, UserCache.getInstance().getUserId()))
                .start();
    }

    public void getTeacherChatListByAcoountId(final MutableLiveData<UserSchoolTeacher> liveData, String accountId) {
        new HttpTask<List<UserSchoolTeacher>>()
                .call(httpUtils.create(RongyUserApi.class).getTeacherChatListByAcoountId(accountId))
                .apiModel(new ApiModelHandle<List<UserSchoolTeacher>>() {
                    @Override
                    public void handle(@NonNull ApiModel<List<UserSchoolTeacher>> apiModel, int pageIndex) {
                        if (apiModel.getCode() == Config.HTTP_SUCCESS && apiModel.getData().size() > 0) {
                            liveData.postValue(apiModel.getData().get(0));
                        }
                    }
                }).start();
    }
}
