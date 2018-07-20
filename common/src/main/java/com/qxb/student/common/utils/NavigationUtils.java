package com.qxb.student.common.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.support.annotation.AnimatorRes;
import android.support.annotation.IdRes;
import android.support.annotation.NavigationRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.qxb.student.common.Config;
import com.qxb.student.common.Constant;
import com.qxb.student.common.R;
import com.qxb.student.common.basics.NavigationActivity;
import com.qxb.student.common.basics.WebActivity;
import com.qxb.student.common.module.bean.attr.WebAttr;

import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;

/**
 * 导航工具类
 *
 * @author winky
 */
public class NavigationUtils {

    private static final Singleton<NavigationUtils> SINGLETON = new Singleton<NavigationUtils>() {
        @Override
        protected NavigationUtils create() {
            return new NavigationUtils();
        }
    };

    public static NavigationUtils getInstance() {
        return SINGLETON.get();
    }

    private NavOptions navOptions;

    private NavigationUtils() {
        navOptions = new NavOptions.Builder()
                .setEnterAnim(R.anim.slide_right_in)
                .setExitAnim(R.anim.slide_left_out)
                .setPopEnterAnim(R.anim.slide_left_in)
                .setPopExitAnim(R.anim.slide_right_out)
                .build();
    }

    /**
     * 设置导航转换动画
     *
     * @param enterAnim    enterAnim
     * @param exitAnim     exitAnim
     * @param popEnterAnim popEnterAnim
     * @param popExitAnim  popExitAnim
     */
    public void setNavOptions(@AnimRes @AnimatorRes int enterAnim,
                              @AnimRes @AnimatorRes int exitAnim,
                              @AnimRes @AnimatorRes int popEnterAnim,
                              @AnimRes @AnimatorRes int popExitAnim) {
        this.navOptions = new NavOptions.Builder()
                .setEnterAnim(enterAnim)
                .setExitAnim(exitAnim)
                .setPopEnterAnim(popEnterAnim)
                .setPopExitAnim(popExitAnim)
                .build();
    }

    /**
     * 打开一个新的导航
     *
     * @param context       上下文
     * @param navigationRes 导航资源
     */
    public void toNavigation(@NonNull Context context, @NavigationRes int navigationRes) {
        toNavigation(context, navigationRes, null);
    }

    /**
     * 打开一个新的导航
     *
     * @param context       上下文
     * @param navigationRes 导航资源
     * @param bundle        参数
     */
    public void toNavigation(@NonNull Context context, @NavigationRes int navigationRes, @Nullable Bundle bundle) {
        Intent intent = new Intent(context, NavigationActivity.class);
        intent.putExtra(Constant.NAVIGATION_ID, navigationRes);
        intent.putExtra(Constant.NAVIGATION_BUNDLE, bundle);
        context.startActivity(intent);
    }

    /**
     * 跳转通用网页类
     *
     * @param context 上下文
     * @param webAttr 打开网页参数
     */
    public void toWeb(@NonNull Context context, @NonNull WebAttr webAttr) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(WebAttr.TAG, webAttr);
        context.startActivity(intent);
    }

    /**
     * 导航内页码跳转
     *
     * @param fragment     fragment
     * @param navigationId 导航页码id
     */
    public void jump(@NonNull Fragment fragment, @IdRes int navigationId) {
        this.jump(fragment, navigationId, null);
    }

    /**
     * 导航内页码跳转，带参
     *
     * @param fragment     fragment
     * @param navigationId 导航页码id
     * @param bundle       参数
     */
    public void jump(@NonNull Fragment fragment, @IdRes int navigationId, @Nullable Bundle bundle) {
        NavHostFragment.findNavController(fragment).navigate(navigationId, bundle, navOptions);
    }

    /**
     * 导航内回退
     *
     * @param fragment fragment
     * @return boolean
     */
    public boolean goBack(Fragment fragment) {
        return NavHostFragment.findNavController(fragment).navigateUp();
    }
}
