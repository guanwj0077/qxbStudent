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
 * 下拉刷新基类
 *
 * @author winky
 */
public abstract class AbsRefreshFragment<T> extends AbsToolbarFragment implements IPullRefresh<T> {

    @Override
    public final int bindContentView() {
        return R.layout.fragment_refresh;
    }

    private final PullRefreshDelegate<T> delegate = new PullRefreshDelegate<>(this);

    @Override
    public final void initContent(View contentView, @Nullable Bundle savedInstanceState) {
        delegate.init((SmartRefreshLayout) contentView.findViewById(R.id.refreshLayout), (RecyclerView) contentView.findViewById(R.id.recyclerView));
        init(savedInstanceState);
    }

    public abstract void init(@Nullable Bundle savedInstanceState);

    @Override
    public void refreshData(List<T> data, int count) {
        delegate.refreshData(data, count);
    }

    @Override
    public void autoRefresh() {
        delegate.autoRefresh();
    }
}
