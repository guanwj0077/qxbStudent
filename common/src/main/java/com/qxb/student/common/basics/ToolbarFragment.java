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

public abstract class ToolbarFragment extends ExpandFragment {

    @Override
    public int bindLayout() {
        return R.layout.fragment_toolbar;
    }

    private Toolbar toolbar;
    private FrameLayout frameLayout;

    public abstract int bindContentView();

    public abstract void initContent(@Nullable Bundle savedInstanceState);

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        toolbar = view.findViewById(R.id.toolbar);
        toolbar.setPadding(0, SysUtils.getInstance().getStatusHeight(), 0, 0);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.arrow_left_black);
        frameLayout = view.findViewById(R.id.fl_content);
        frameLayout.addView(View.inflate(getContext(), bindContentView(), null));
        initContent(savedInstanceState);
    }

    public void postRunnable(Runnable runnable) {
        if (frameLayout != null)
            frameLayout.postDelayed(runnable, 200);
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return frameLayout.findViewById(id);
    }

    @Override
    public BaseFragment setTitle(String title) {
        if (toolbar != null)
            toolbar.setTitle(title);
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
