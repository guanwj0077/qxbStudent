package com.qxb.student.common.utils;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.mob.MobSDK;
import com.qxb.student.common.http.HttpConfigure;
import com.qxb.student.common.http.HttpUtils;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.module.dao.RoomUtils;
import com.zhy.autolayout.config.AutoLayoutConifg;

import io.rong.imkit.RongIM;

/**
 * 初始化工具类
 *
 * @author winky
 */
public class LibControl {

    private static final Singleton<LibControl> SINGLETON = new Singleton<LibControl>() {
        @Override
        protected LibControl create() {
            return new LibControl();
        }
    };

    public static LibControl getInstance() {
        return SINGLETON.get();
    }

    private volatile Context context;

    /**
     * 初始化三方库及辅助工具类
     *
     * @param application {@link android.app.Application}
     */
    public void init(Application application) {
        context = application.getApplicationContext();
        //上下文托管
        ContextUtils.getInstance().setContext(context);
        //错误日志收集
//        CrashCollectUtils.getInstance();
        //接口请求工具
        HttpUtils.getInstance().setHttpConfigure(new HttpConfigure.Builder().build());
        //布局适配框架：注意recycler的holder里设置item适配
        AutoLayoutConifg.getInstance().useDeviceSize();
        //分享，登录，用户行为分析
        MobSDK.init(context);
        //融云即时通讯
        RongIM.init(context);
        User user = UserCache.getInstance().getUser();

        if (user != null) {
            loadOther(user);
        }
    }

    public void loadOther(@NonNull User user){
        //连接融云
        OtherHelper.getInstance().initToken(String.valueOf(user.getId()));
    }

    public Context getContext() {
        if (context == null) {
            logout();
        }
        return context;
    }

    /**
     * 退出登录，注销
     */
    public void logout() {

    }

    /**
     * 释放三方库及辅助工具类
     */
    public void release() {
        RoomUtils.getInstance().close();
        SysUtils.getInstance().recovery();
        ContextUtils.getInstance().cleared();
        OtherHelper.getInstance().OnCleared();
        context = null;
    }


}
