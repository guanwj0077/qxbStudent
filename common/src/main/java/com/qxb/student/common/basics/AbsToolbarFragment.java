package com.qxb.student.common.basics;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;
import android.widget.FrameLayout;

import com.qxb.student.common.R;
import com.qxb.student.common.view.Toolbar;

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
     * @param contentView
     * @param savedInstanceState bundle
     */
    public abstract void initContent(View contentView, @Nullable Bundle savedInstanceState);

    @Override
    public final void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        toolbar = view.findViewById(R.id.toolbar);
        frameLayout = view.findViewById(R.id.fl_content);
        View contentView = View.inflate(getActivity(), bindContentView(), null);
        frameLayout.addView(contentView);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.arrow_left_black);
        initContent(contentView, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public final <T extends View> T findViewById(int id) {
        return frameLayout.findViewById(id);
    }

    @Override
    public BaseFragment setTitle(String title) {
        if (toolbar != null) {
            toolbar.setTitle(title);
            return null;
        } else {
            return super.setTitle(title);
        }
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
