package com.qxb.student.common.listener;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * @author winky
 * @date 2018/5/12
 */
public interface IBinding {

    /**
     * 返回UI布局资源id
     * @return layoutResId
     */
    int bindLayout();

    /**
     * 初始化
     * @param view 当前内容视图
     * @param savedInstanceState bundle
     */
    void init(@NonNull View view, @Nullable Bundle savedInstanceState);
}
