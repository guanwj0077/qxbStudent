package com.qxb.student.common.basics;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qxb.student.common.R;
import com.qxb.student.common.delegate.IPullRefresh;
import com.qxb.student.common.delegate.PullRefreshDelegate;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

/**
 * 没有标题的下拉刷新页面
 *
 * @author winky
 * @date 2018/7/27
 */
public abstract class AbsNoTitleRefreshFragment<T> extends AbsExpandFragment implements IPullRefresh<T> {
    @Override
    public final int bindLayout() {
        return R.layout.fragment_refresh;
    }

    @Override
    public final void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        delegate.init((SmartRefreshLayout) view.findViewById(R.id.refreshLayout), (RecyclerView) view.findViewById(R.id.recyclerView));
        initContent(savedInstanceState);
    }

    private final PullRefreshDelegate<T> delegate = new PullRefreshDelegate<>(this);

    /**
     * 初始化
     *
     * @param savedInstanceState bundle
     */
    public abstract void initContent(@Nullable Bundle savedInstanceState);

    @Override
    public void refreshData(@NonNull List<T> data, int count) {
        delegate.refreshData(data, count);
    }

    @Override
    public void autoRefresh() {
        postRunnable(new Runnable() {
            @Override
            public void run() {
                delegate.autoRefresh();
            }
        });
    }


}
