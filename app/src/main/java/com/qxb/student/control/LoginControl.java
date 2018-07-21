package com.qxb.student.control;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.qxb.student.common.module.UserRepository;
import com.qxb.student.common.module.bean.User;

/**
 * 登录
 *
 * @author winky
 * @date 2018/7/21
 */
public class LoginControl extends AndroidViewModel {

    private UserRepository userRepository = new UserRepository();

    public LoginControl(@NonNull Application application) {
        super(application);
    }

    public LiveData<User> login(String account, String password) {
        return userRepository.login(account, password);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        userRepository.onCleared();
        userRepository = null;
    }
}
