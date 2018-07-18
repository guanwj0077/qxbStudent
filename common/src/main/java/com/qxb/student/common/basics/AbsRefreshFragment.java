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
 * @author winky
 */
public abstract class AbsRefreshFragment<T> extends AbsToolbarFragment implements IPullRefresh<T> {

    @Override
    public int bindContentView() {
        return R.layout.fragment_refresh;
    }

    private final PullRefreshDelegate delegate = new PullRefreshDelegate(this);

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.init(view, savedInstanceState);
        delegate.init((SmartRefreshLayout) view.findViewById(R.id.refreshLayout), (RecyclerView) view.findViewById(R.id.recyclerView));
    }

    @Override
    public void refreshData(List<T> data, int count) {
        delegate.refreshData(data, count);
    }
}
