package com.qxb.student.common.delegate;

import android.view.ViewStub;

import com.qxb.student.common.view.recycler.adapter.QuickAdapter;
import com.qxb.student.common.view.recycler.listener.OnItemClickListener;

import java.util.List;

/**
 * 下拉刷新
 *
 * @author winky
 * @date 2018/5/12
 */
public interface IPullRefresh<T> {

    /**
     * 请求接口分页
     *
     * @param pageIndex 页码
     */
    void reqData(int pageIndex);

    /**
     * 初始化recyclerView数据适配器
     *
     * @return
     */
    QuickAdapter<T> initAdapter();

    /**
     * 请求刷新
     */
    void autoRefresh();

    /**
     * 更新UI数据
     *
     * @param data  数据
     * @param count 数据条数
     */
    void refreshData(List<T> data, int count);

    /**
     * 当没有数据时显示的空白视图
     *
     * @param viewStub 延迟加载视图
     * @return
     */
    ViewStub setEmptyView(ViewStub viewStub);
}
