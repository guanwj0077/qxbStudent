package com.qxb.student.ui.home.school;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ExpandableListView;

import com.qxb.student.R;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.module.bean.SchoolDetail;
import com.qxb.student.common.view.abslist.adapter.ExpandableAdapter;
import com.qxb.student.common.view.abslist.bean.ExpandableEntity;
import com.qxb.student.control.SchoolControl;

import java.util.Arrays;

/**
 * 学校简介
 *
 * @author winky
 * @date 2018/7/20
 */
public class SchoolIntroFragment extends AbsExpandFragment {
    @Override
    public int bindLayout() {
        return R.layout.item_expandable;
    }

    private ExpandableAdapter<String, String> adapter;

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final ExpandableListView listView = view.findViewById(R.id.expandableListView);
        adapter = new ExpandableAdapter<String, String>(getContext(), R.layout.item_text_arrow, R.layout.item_text_desc) {
            @Override
            public void bindGroupView(View view, int position, boolean isExpanded, String item) {
                setText(view, R.id.text1, item);
                setArrowExpanded(view, R.id.image1, isExpanded);
            }

            @Override
            public void bindChildView(View view, String item) {
                setText(view, R.id.text1, item);
            }
        };
        listView.setAdapter(adapter);
        SchoolControl schoolControl = ViewModelProviders.of(getActivity()).get(SchoolControl.class);
        schoolControl.getSchoolLiveData().observe(this, new Observer<SchoolDetail>() {
            @Override
            public void onChanged(@Nullable SchoolDetail schoolDetail) {
                adapter.setData(Arrays.asList(
                        new ExpandableEntity<>(getString(R.string.school_summary), schoolDetail.getRemark()),
                        new ExpandableEntity<>(getString(R.string.school_fee_scholarship), schoolDetail.getFees_bonuses()),
                        new ExpandableEntity<>(getString(R.string.school_life), schoolDetail.getGraduates_employment())
                ));
                listView.expandGroup(0);
            }
        });
    }
}
