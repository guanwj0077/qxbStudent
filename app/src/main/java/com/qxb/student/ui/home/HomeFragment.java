package com.qxb.student.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.qxb.student.R;
import com.qxb.student.common.basics.ExpandFragment;
import com.qxb.student.common.utils.SysUtils;

public class HomeFragment extends ExpandFragment {

    @Override
    public int bindLayout() {
        return R.layout.fragment_home;
    }

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        toolbar = view.findViewById(R.id.toolbar);
        toolbar.setPadding(0, SysUtils.getInstance().getStatusHeight(), 0, 0);
        recyclerView = view.findViewById(R.id.recyclerView);
        setSupportActionBar(toolbar);


    }
}
