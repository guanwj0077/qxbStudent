package com.qxb.student.ui.home.school;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qxb.student.R;
import com.qxb.student.adapter.SchoolAdmissionsAdapter;
import com.qxb.student.common.basics.AbsExpandFragment;

/**
 * 学校专业
 *
 * @author winky
 * @date 2018/7/20
 */
public class SchoolRecruitMajorFragment extends AbsExpandFragment {

    private static final String SCHOOL_ID = "schoolId";
    private static final String BAT = "bat";

    @Override
    public int bindLayout() {
        return R.layout.view_recycler;
    }

    private String schoolId;
    private int bat;

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (getArguments() != null) {
            schoolId = getArguments().getString(SCHOOL_ID);
            bat = getArguments().getInt(BAT, 0);
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new SchoolAdmissionsAdapter(this, schoolId, bat));
    }

    public static SchoolRecruitMajorFragment getInstance(String schoolId, int bat) {
        Bundle bundle = new Bundle();
        bundle.putString(SCHOOL_ID, schoolId);
        bundle.putInt(BAT, bat);
        SchoolRecruitMajorFragment fragment = new SchoolRecruitMajorFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
