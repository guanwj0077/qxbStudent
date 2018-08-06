package com.qxb.student.common.delegate;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;

import com.qxb.student.common.Config;
import com.qxb.student.common.R;
import com.qxb.student.common.utils.SysUtils;
import com.qxb.student.common.view.recycler.adapter.QuickAdapter;
import com.qxb.student.common.view.recycler.decoration.SimpleDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

/**
 * 下拉刷新实现
 *
 * @author winky
 * @date 2018/5/12
 */
public class PullRefreshDelegate<T> {

    /**
     * 下拉刷新控件
     */
    private SmartRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private ViewStub viewStub;

    private int pageIndex = 1;
    private QuickAdapter<T> adapter;

    private IPullRefresh<T> pullRefresh;

    public PullRefreshDelegate(@NonNull IPullRefresh<T> pullRefresh) {
        this.pullRefresh = pullRefresh;
    }

    public void init(final SmartRefreshLayout refreshLayout, RecyclerView recyclerView) {
        this.refreshLayout = refreshLayout;
        this.recyclerView = recyclerView;
        this.recyclerView.setAdapter(this.adapter = pullRefresh.initAdapter());
        this.recyclerView.addItemDecoration(new SimpleDecoration(recyclerView.getContext(), R.drawable.list_divider_1));
        this.refreshLayout.setDisableContentWhenLoading(false);
        this.refreshLayout.setEnableLoadMoreWhenContentNotFull(false);
        this.refreshLayout.setEnableScrollContentWhenLoaded(false);
        this.refreshLayout.setEnableOverScrollDrag(true);
        this.refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageIndex = 1;
                pullRefresh.reqData(pageIndex);
            }
        });
        this.refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshlayout) {
                if (SysUtils.getInstance().isConnected()) {
                    pageIndex++;
                    pullRefresh.reqData(pageIndex);
                } else {
                    refreshlayout.finishLoadMore(1000, false, false);
                }
            }
        });
    }

    public void autoRefresh() {
        refreshLayout.autoRefresh();
    }

    public void setViewStub(ViewStub viewStub) {
        this.viewStub = viewStub;
    }

    public void refreshData(List<T> data, int count) {
        if (refreshLayout == null || recyclerView == null) {
            return;
        }
        refreshLayout.finishRefresh();
        if (pageIndex == 1) {
            adapter.clear();
        }
        if (data != null) {
            adapter.addAll(data);
        }
        //是否有网
        if (SysUtils.getInstance().isConnected()) {
            //注意是缓存数据则count为0  保证所有缓存数据都
            if (adapter.getItemCount() >= count && count > 0) {
                refreshLayout.finishLoadMoreWithNoMoreData();
            } else {
                refreshLayout.finishLoadMore();
            }
        } else {
            if (data == null || data.size() < Config.PAGE_SIZE) {
                refreshLayout.finishLoadMore(false);
            }
        }

        /*如果没有数据则展示空白视图*/
        if (adapter.getItemCount() == 0) {
            if (viewStub != null) {
                viewStub.inflate().setVisibility(View.VISIBLE);
            }
            /*设置不可刷新和加载更多,且列表隐藏*/
            refreshLayout.setEnableRefresh(false);
            refreshLayout.setEnableLoadMore(false);
            recyclerView.setVisibility(View.GONE);
        } else {
            if (recyclerView.getVisibility() == View.GONE) {
                refreshLayout.setEnableRefresh(true);
                refreshLayout.setEnableLoadMore(true);
                recyclerView.setVisibility(View.VISIBLE);
            }
        }
    }
}
