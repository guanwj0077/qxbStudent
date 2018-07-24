package com.qxb.student.ui.home.school;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.qxb.student.R;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.view.recycler.ViewHolder;
import com.qxb.student.common.view.recycler.adapter.ExpandableAdapter;
import com.qxb.student.common.view.recycler.bean.ExpandableEntity;
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
        return R.layout.view_recycler;
    }

    private ExpandableAdapter<String, String> adapter;

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        adapter = new ExpandableAdapter<String, String>(R.layout.item_text_arrow, R.layout.item_text_desc) {
            @Override
            public void parentConvert(ViewHolder holder, int position, String item) {
                holder.setText(R.id.text1, item);
            }

            @Override
            public void childConvert(View view, int position, String item) {
                TextView textView = view.findViewById(R.id.text1);
                textView.setText(item);
            }
        };
        recyclerView.setAdapter(adapter);
        SchoolControl schoolControl = ViewModelProviders.of(getActivity()).get(SchoolControl.class);

        adapter.setDatas(Arrays.asList(
                new ExpandableEntity<>(getString(R.string.school_summary), "sgfdg"),
                new ExpandableEntity<>(getString(R.string.school_fee_scholarship), "sagsrhfg111111111111111111"),
                new ExpandableEntity<>(getString(R.string.school_life), "dfjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjaaaaaaaaaaaaaaaaaaaaaaaaaa")
        ));

    }
}
