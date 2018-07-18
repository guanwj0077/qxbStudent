package com.qxb.student.common.utils;

import com.qxb.student.common.module.bean.User;

import java.lang.ref.WeakReference;

/**
 * 登录用户对象缓存
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

    private static volatile WeakReference<User> weakReference = null;

    public User getUser() {
        if (weakReference == null) {

        } else {
            User user = weakReference.get();
            if (user == null) {

            }
        }
        return weakReference.get();
    }

    public void recovery() {
        weakReference.clear();
        weakReference = null;
    }


}
