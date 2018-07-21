package com.qxb.student.ui.home.school;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;

import com.qxb.student.R;
import com.qxb.student.common.Constant;
import com.qxb.student.common.adapter.FragmentAdapter;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.module.bean.School;
import com.qxb.student.common.utils.Logger;
import com.qxb.student.common.utils.NavigationUtils;
import com.qxb.student.common.view.Toolbar;
import com.qxb.student.control.HomeControl;
import com.qxb.student.control.SchoolControl;
import com.qxb.student.databinding.FragmentSchoolBinding;

import java.util.Arrays;
import java.util.Objects;

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

    private FragmentSchoolBinding binding;
    private Toolbar toolbar;

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.arrow_left_black);
//        toolbar.setBackgroundResource(android.R.color.transparent);
        SchoolControl schoolControl = ViewModelProviders.of(getFragment()).get(SchoolControl.class);
        String schoolId = getStringExtra(Constant.NAV_SCHOOL_ID);
        if (validate(schoolId)) {
            return;
        }
        binding = DataBindingUtil.bind(view);
        binding.appBarLayout.setExpanded(true);
        binding.viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(), Arrays.asList(
                new SchoolIntroFragment().setTitle(getString(R.string.school_intro)),
                new SchoolRecruitMajorFragment().setTitle(getString(R.string.school_major))
        )));
        binding.viewPager.setCurrentItem(0);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        schoolControl.getSchoolById(schoolId).observe(this, new Observer<School>() {
            @Override
            public void onChanged(@Nullable School school) {
                binding.setSchool(school);
                toolbar.setTitle(school.getSchool_name());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (binding != null) {
            binding.unbind();
        }
    }
}
