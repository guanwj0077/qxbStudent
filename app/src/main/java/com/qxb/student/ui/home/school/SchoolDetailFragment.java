package com.qxb.student.ui.home.school;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.qxb.student.R;
import com.qxb.student.common.Constant;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.control.SchoolControl;

/**
 * 普通学校首页
 *
 * @author winky
 * @date 2018/7/19
 */
public class SchoolDetailFragment extends AbsExpandFragment {
    @Override
    public int bindLayout() {
        return R.layout.fragment_school;
    }

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final String schoolId = getStringExtra(Constant.NAV_SCHOOL_ID);
        if (validate(schoolId)) {
            return;
        }
        SchoolControl schoolControl = ViewModelProviders.of(getActivity()).get(SchoolControl.class);
        schoolControl.init(this, view, schoolId, getIntExtra(Constant.NAV_SCHOOL_BAT));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
