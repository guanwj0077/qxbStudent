package com.qxb.student.common.basics;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.qxb.student.common.R;
import com.qxb.student.common.utils.SysUtils;

/**
 * 包含toolbar的fragment
 *
 * @author winky
 */
public abstract class AbsToolbarFragment extends AbsExpandFragment {

    @Override
    public final int bindLayout() {
        return R.layout.fragment_toolbar;
    }

    private Toolbar toolbar;
    private FrameLayout frameLayout;

    /**
     * 返回内容布局id
     *
     * @return layoutResId
     */
    public abstract int bindContentView();

    /**
     * 初始化
     *
     * @param savedInstanceState bundle
     */
    public abstract void initContent(@Nullable Bundle savedInstanceState);

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        toolbar = view.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.arrow_left_black);
        frameLayout = view.findViewById(R.id.fl_content);
        frameLayout.addView(View.inflate(getContext(), bindContentView(), null));
        initContent(savedInstanceState);
    }

    /**
     * 异步执行runnable
     *
     * @param runnable runnable
     */
    public void postRunnable(Runnable runnable) {
        if (frameLayout != null) {
            frameLayout.postDelayed(runnable, 200);
        }
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return frameLayout.findViewById(id);
    }

    @Override
    public BaseFragment setTitle(String title) {
        if (toolbar != null) {
            toolbar.setTitle(title);
        }
        return super.setTitle(title);
    }

    public void setTitle(@StringRes int titleRes) {
        this.setTitle(getString(titleRes));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        toolbar = null;
        frameLayout = null;
    }
}
