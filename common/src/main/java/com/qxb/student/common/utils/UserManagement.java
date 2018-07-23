package com.qxb.student.common.utils;

import android.content.Context;
import android.text.TextUtils;

import com.qxb.student.common.R;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.module.bean.attr.NavAttr;

/**
 * @author: zjk9527
 * created on: 2018/7/20 10:55
 * description: 根据用户信息状态 判断下一步的动作
 */
public class UserManagement {

    private static final Singleton<UserManagement> SINGLETON = new Singleton<UserManagement>() {
        @Override
        protected UserManagement create() {
            return new UserManagement();
        }
    };

    public static UserManagement getInstance() {
        return SINGLETON.get();
    }


    public void getUserInfoCondition(Context context) {
        if (context != null) {
            User mUser = UserCache.getInstance().getUser();
            if (mUser == null) {
                NavigationUtils.getInstance().toNavigation(context, new NavAttr.Builder().graphRes(R.navigation.nav_login).build());
            } else {
                if (TextUtils.isEmpty(mUser.getName()) || TextUtils.isEmpty(mUser.getHighschool_name())) {

                }else if (TextUtils.isEmpty(mUser.getSubject())){

                }else if (mUser.getYears() == 0){

                }
            }

        }

    }

}
