package com.qxb.student.helper;

import android.app.Application;
import android.content.Context;

import com.qxb.student.common.utils.CrashCollectUtils;
import com.qxb.student.common.utils.FileUtils;
import com.qxb.student.common.utils.Singleton;

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

    private volatile static Context context;

    /**
     * 初始化三方库及辅助工具类
     *
     * @param application
     */
    public void init(Application application) {
        context = application.getApplicationContext();
        FileUtils.getInstance().setContext(context);
        CrashCollectUtils.getInstance();

//        MobSDK.init(context);
    }

    public Context getContext() {
        if (context == null) {
            //注销app
        }
        return context;
    }

    /**
     * 释放三方库及辅助工具类
     */
    public void release() {
        context = null;
    }
}
