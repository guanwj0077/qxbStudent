package com.qxb.student.control;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSONObject;
import com.qxb.student.common.module.UserRepository;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.utils.Encrypt;

/**
 * @author: zjk9527
 * created on: 2018/7/24 14:00
 * description:
 */
public class ResetPasswordControl extends AndroidViewModel {
    private LiveData<ApiModel> mData;

    private UserRepository userRepository = new UserRepository();
    public ResetPasswordControl(@NonNull Application application) {
        super(application);
    }


    public LiveData<ApiModel<JSONObject>> sendCode(String phone, String type){
        return userRepository.sendCode(phone,type);
    }

    public LiveData<ApiModel<JSONObject>> checkCode(String phone, String code){
        return userRepository.checkCode(phone,code);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        userRepository.onCleared();
        userRepository = null;
    }
}
