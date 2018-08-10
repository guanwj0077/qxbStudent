package com.qxb.student.common.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.support.annotation.AnimatorRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.qxb.student.common.Constant;
import com.qxb.student.common.R;
import com.qxb.student.common.basics.NavFragment;
import com.qxb.student.common.basics.NavHostActivity;
import com.qxb.student.common.basics.VideoPlayActivity;
import com.qxb.student.common.basics.WebActivity;
import com.qxb.student.common.module.bean.attr.ChatAttr;
import com.qxb.student.common.module.bean.attr.NavAttr;
import com.qxb.student.common.module.bean.attr.VoideAttr;
import com.qxb.student.common.module.bean.attr.WebAttr;
import com.qxb.student.common.rong.ChatActivity;

import androidx.navigation.NavOptions;

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
        setNavOptions(R.anim.slide_right_in, R.anim.slide_left_out, R.anim.slide_left_in, R.anim.slide_right_out);
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

    public NavOptions getNavOptions() {
        return navOptions;
    }

    /**
     * 打开一个新的导航,并且打开指定页面
     *
     * @param context 上下文
     * @param navAttr 导航目标参数
     */
    public void toNavigation(@NonNull Context context, @NonNull NavAttr navAttr) {
        Intent intent = new Intent(context, NavHostActivity.class);
        intent.putExtra(NavAttr.TAG, navAttr);
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
        NavFragment.findNavController(fragment).navigate(navigationId, bundle, navOptions);
    }

    /**
     * 导航内回退
     *
     * @param fragment fragment
     * @return boolean
     */
    public boolean goBack(Fragment fragment) {
        return NavFragment.findNavController(fragment).navigateUp();
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
     * 跳转通用视屏播放类
     *
     * @param context    上下文
     * @param mVoideAttr 视屏播放参数
     */
    public void toVideoPlay(@NonNull Context context, @NonNull VoideAttr mVoideAttr) {
        Intent intent = new Intent(context, VideoPlayActivity.class);
        intent.putExtra(Constant.PURPOSE, mVoideAttr);
        context.startActivity(intent);
    }

    public void toChat(@NonNull Context context, @NonNull ChatAttr chatAttr) {
        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtra(ChatAttr.TAG, chatAttr);
        context.startActivity(intent);
    }
}
