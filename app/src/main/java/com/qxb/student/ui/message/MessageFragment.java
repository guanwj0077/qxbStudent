package com.qxb.student.ui.message;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.qxb.student.R;
import com.qxb.student.common.basics.ExpandFragment;
import com.qxb.student.common.recycler.ExtendRecyclerView;
import com.qxb.student.common.utils.SysUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;


public class MessageFragment extends ExpandFragment {
    @Override
    public int bindLayout() {
        return R.layout.fragment_message;
    }

    private Toolbar toolbar;
    private SmartRefreshLayout smartRefreshLayout;
    private ExtendRecyclerView recyclerView;

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        toolbar = view.findViewById(R.id.toolbar);
        toolbar.setPadding(0, SysUtils.getInstance().getStatusHeight(), 0, 0);
        setSupportActionBar(toolbar);
        smartRefreshLayout = view.findViewById(R.id.refreshLayout);
        recyclerView = view.findViewById(R.id.recyclerView);

    }
}
