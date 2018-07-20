package com.qxb.student.common.utils;

import android.util.Log;

import com.qxb.student.common.Config;

/**
 * 日志
 * @author winky
 */
public final class Logger {

    private static final Singleton<Logger> SINGLETON = new Singleton<Logger>() {
        @Override
        protected Logger create() {
            return new Logger();
        }
    };

    public static final boolean isDebug = true || Config.IS_DEBUG;
    private static final String TAG = "Logger";

    public static Logger getInstance() {
        return SINGLETON.get();
    }

    public void v(String msg) {
        if (isDebug) {
            Log.v(TAG, msg);
        }
    }

    public void d(String msg) {
        if (isDebug) {
            System.out.println(msg);
        }
    }

    public void i(String msg) {
        if (isDebug) {
            Log.i(TAG, msg);
        }
    }

    public void e(String msg) {
        if (isDebug) {
            Log.e(TAG, msg);
        }

    }

    public void w(String msg) {
        if (isDebug) {
            Log.w(TAG, msg);
        }
    }
}
