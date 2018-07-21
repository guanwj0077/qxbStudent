package com.qxb.student.ui.home.school;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.qxb.student.R;
import com.qxb.student.common.basics.AbsExpandFragment;

/**
 * 学校简介
 *
 * @author winky
 * @date 2018/7/20
 */
public class SchoolIntroFragment extends AbsExpandFragment {
    @Override
    public int bindLayout() {
        return R.layout.fragment_school_intro;
    }

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }
}
