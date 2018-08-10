package com.qxb.student.common.utils;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.module.dao.RoomUtils;

/**
 * 登录用户对象缓存
 *
 * @author winky
 */
public class UserCache {

    private static final Singleton<UserCache> SINGLETON = new Singleton<UserCache>() {
        @Override
        protected UserCache create() {
            return new UserCache();
        }
    };

    public static UserCache getInstance() {
        return SINGLETON.get();
    }

    private UserCache() {
        getUserLiveData();
    }

    private volatile MutableLiveData<User> userLiveData = new MutableLiveData<>();

    public void update(User user) {
        userLiveData.postValue(user);
    }

    public LiveData<User> getUserLiveData() {
        if (userLiveData.getValue() != null) {
            return userLiveData;
        }
        synchronized (Config.LOCK) {
            if (userLiveData.getValue() == null) {
                ExecutorUtils.getInstance().addTask(new Runnable() {
                    @Override
                    public void run() {
                        User user = RoomUtils.getInstance().userDao().query();
                        if (user != null) {
                            userLiveData.postValue(user);
                        }
                    }
                });
            }
        }
        return userLiveData;
    }

    public User getUser() {
        User user = userLiveData.getValue();
        if (user != null) {
            return user;
        }
        synchronized (Config.LOCK) {
            user = userLiveData.getValue();
            if (user == null) {
                getUserLiveData();
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return userLiveData.getValue();
    }

    public String getUserId() {
        return String.valueOf(getUser() == null ? "" : getUser().getId());
    }

    public String getAccountId() {
        if (getUser() != null) {
            return String.valueOf(getUser().getAccount_id());
        }
        return "";
    }

    public String getUserName() {
        return getUser() == null ? "" : getUser().getName();
    }

    public String getProvince() {
        return getUser() == null ? "420000" : getUser().getProvince();
    }

    public void recovery() {
        userLiveData = null;
    }
    // public int getUserInfoCondition()


}
