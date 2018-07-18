package com.qxb.student.common.basics;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/**
 * 上下文管理
 *
 * @author winky
 */
public class BaseAppActivity extends AppCompatActivity {

    private WeakReference<FragmentActivity> weakReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        weakReference = new WeakReference<FragmentActivity>(this);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            try {
                Class decorViewClazz = Class.forName("com.android.internal.policy.DecorView");
                Field field = decorViewClazz.getDeclaredField("mSemiTransparentStatusBarColor");
                field.setAccessible(true);
                field.setInt(getWindow().getDecorView(), Color.TRANSPARENT);
            } catch (Exception e) {
            }
        }
    }

    public FragmentActivity getActivity() {
        return weakReference.get();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        weakReference.clear();
        weakReference = null;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
