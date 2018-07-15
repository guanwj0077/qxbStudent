package com.qxb.student.common.utils;

import android.content.Context;

import java.lang.ref.WeakReference;

public class ContextUtils {

    private static final Singleton<ContextUtils> SINGLETON = new Singleton<ContextUtils>() {
        @Override
        protected ContextUtils create() {
            return new ContextUtils();
        }
    };

    public static ContextUtils getInstance() {
        return SINGLETON.get();
    }

    private volatile WeakReference<Context> weakReference;

    public Context getContext() {
        return weakReference.get();
    }

    public void setContext(Context context) {
        this.weakReference = new WeakReference<>(context);
    }

    public void cleared() {
        weakReference.clear();
        weakReference = null;
    }
}
