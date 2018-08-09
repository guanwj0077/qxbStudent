package com.qxb.student.ui.home;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.qxb.student.R;
import com.qxb.student.adapter.HomeAdapter;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.control.HomeControl;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * 首页
 * @author winky
 */
public class HomeFragment extends AbsExpandFragment {

    private HomeControl homeControl;

    @Override
    public int bindLayout() {
        return R.layout.fragment_home;
    }

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //toolbar
        toolbar = view.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());
        refreshLayout = view.findViewById(R.id.refreshLayout);
        recyclerView = view.findViewById(R.id.recyclerView);
        //toolbar 设置下拉刷新
        refreshLayout.setDisableContentWhenLoading(false);
        refreshLayout.setEnableOverScrollDrag(true);
        refreshLayout.setEnableLoadMore(false);
        refreshLayout.setEnableFooterFollowWhenLoadFinished(false);

        homeControl = ViewModelProviders.of(HomeFragment.this).get(HomeControl.class);

        recyclerView.setAdapter(new HomeAdapter(this));
        this.refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh();
                homeControl.getLiveAdvert();
                homeControl.getSchoolLiveData();
                homeControl.getHomeBanner();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        toolbar = null;
        recyclerView = null;
        refreshLayout = null;
    }

}
