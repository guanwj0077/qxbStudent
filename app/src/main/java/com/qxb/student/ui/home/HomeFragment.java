package com.qxb.student.ui.home;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.qxb.student.R;
import com.qxb.student.common.basics.ExpandFragment;
import com.qxb.student.common.utils.SysUtils;
import com.qxb.student.common.view.bannerview.CircleFlowIndicator;
import com.qxb.student.common.view.bannerview.ViewFlow;
import com.qxb.student.common.view.pager.ViewPagerWrapContent;
import com.qxb.student.common.view.recycler.ExtendRecyclerView;
import com.qxb.student.control.HomeControl;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class HomeFragment extends ExpandFragment {

    @Override
    public int bindLayout() {
        return R.layout.fragment_refresh;
    }

    private HomeControl homeControl;
    private Holder holder;

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        homeControl = ViewModelProviders.of(getFragment()).get(HomeControl.class);
        holder = new Holder();
        //toolbar
        holder.toolbar = view.findViewById(R.id.toolbar);
        holder.toolbar.setPadding(0, SysUtils.getInstance().getStatusHeight(), 0, 0);
        setSupportActionBar(holder.toolbar);

        holder.refreshLayout = view.findViewById(R.id.refreshLayout);
        holder.recyclerView = view.findViewById(R.id.recyclerView);
        ////toolbar 设置下拉刷新
        holder.refreshLayout.setDisableContentWhenLoading(false);
        holder.refreshLayout.setEnableOverScrollDrag(true);
        holder.refreshLayout.setEnableLoadMore(false);
        holder.refreshLayout.setEnableFooterFollowWhenLoadFinished(false);
        //设置bannerView
        View bannerView = View.inflate(getActivity(), R.layout.view_banner, null);
        holder.viewFlow = bannerView.findViewById(R.id.viewFlow);
        holder.flowIndicator = bannerView.findViewById(R.id.flowIndicator);
        holder.recyclerView.addHeaderView(bannerView);
        //设置function区
        View functionView = View.inflate(getActivity(), R.layout.fragment_home_function, null);
        holder.viewPager = functionView.findViewById(R.id.viewPager);
        holder.functionIndicator = functionView.findViewById(R.id.functionIndicator);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (holder != null) {

        }
    }

    private class Holder {
        Toolbar toolbar;
        ExtendRecyclerView recyclerView;
        SmartRefreshLayout refreshLayout;
        //banner
        ViewFlow viewFlow;
        CircleFlowIndicator flowIndicator;
        //function
        ViewPagerWrapContent viewPager;
        LinearLayout functionIndicator;
    }
}
