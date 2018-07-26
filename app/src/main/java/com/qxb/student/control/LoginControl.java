package com.qxb.student.control;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.qxb.student.common.module.UserRepository;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.utils.Encrypt;

/**
 * 登录
 *
 * @author winky
 * @date 2018/7/21
 */
public class LoginControl extends AndroidViewModel {


    private LiveData<User> mUserLiveData;

    private UserRepository userRepository = new UserRepository();

    public LoginControl(@NonNull Application application) {
        super(application);
    }

    public LiveData<User> login(String account, String password) {
        return mUserLiveData = userRepository.login(account, Encrypt.md5(password));
    }

    public LiveData<ApiModel<String>> ThirdLogin(String type, String open_id) {
        return userRepository.ThirdLogin(type, open_id);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        userRepository.onCleared();
        userRepository = null;
    }
}
