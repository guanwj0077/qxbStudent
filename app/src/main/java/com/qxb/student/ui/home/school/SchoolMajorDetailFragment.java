package com.qxb.student.ui.home.school;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.qxb.student.R;
import com.qxb.student.adapter.SchoolMajorAdapter;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.module.bean.CollegeMajorRecruit;
import com.qxb.student.common.utils.GlideUtils;
import com.qxb.student.common.utils.NavigationUtils;
import com.qxb.student.common.view.Toolbar;
import com.qxb.student.common.view.recycler.decoration.SimpleDecoration;
import com.qxb.student.control.SchoolMajorControl;

/**
 * @author winky
 * @date 2018/7/26
 */
public class SchoolMajorDetailFragment extends AbsExpandFragment {

    private static final String ID = "SchoolMajorDetailFragment_id";
    private RecyclerView recyclerView;
    private ImageView imageView;
    private Toolbar toolbar;

    public static Bundle create(int id) {
        Bundle bundle = new Bundle();
        bundle.putString(ID, String.valueOf(id));
        return bundle;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_school_major_detail;
    }

    private SchoolMajorControl majorControl;

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        String majorId = getArguments() != null ? getArguments().getString(ID) : "";
        if (TextUtils.isEmpty(majorId)) {
            NavigationUtils.getInstance().goBack(this);
            return;
        }
        toolbar = view.findViewById(R.id.toolbar);
        toolbar.setAppBarLayout((AppBarLayout) findViewById(R.id.appBarLayout));
        setSupportActionBar(toolbar);
        imageView = view.findViewById(R.id.image1);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new SimpleDecoration(getContext(), R.drawable.list_divider_35));
        majorControl = ViewModelProviders.of(this).get(SchoolMajorControl.class);
        majorControl.getMajorRecruit().observe(this, new Observer<CollegeMajorRecruit>() {
            @Override
            public void onChanged(@Nullable CollegeMajorRecruit collegeMajorRecruit) {
                dissWaitingDialog();
                if (collegeMajorRecruit != null) {
                    toolbar.setTitle(collegeMajorRecruit.getSchool_name());
                    GlideUtils.getInstance().loadImage(imageView, collegeMajorRecruit.getFront_img());
                    recyclerView.setAdapter(new SchoolMajorAdapter(SchoolMajorDetailFragment.this, collegeMajorRecruit, majorControl));
                }
            }
        });
        majorControl.getSchoolProfessNew(majorId);
    }
}
