package com.qxb.student.common.view.recycler.adapter;

import android.support.annotation.LayoutRes;

import com.qxb.student.common.view.recycler.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * recycler数据适配器
 *
 * @author winky
 * @date 2017/12/5
 */
public abstract class QuickAdapter<T> extends BaseAdapter {

    private int layoutId;
    private final List<T> datas;

    protected QuickAdapter(@LayoutRes int layoutId) {
        this(layoutId, null);
    }

    protected QuickAdapter(List<T> data) {
        this.datas = data == null ? new ArrayList<T>() : data;
    }

    protected QuickAdapter(@LayoutRes int layoutId, List<T> data) {
        this.datas = data == null ? new ArrayList<T>() : data;
        if (layoutId != 0) {
            this.layoutId = layoutId;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return layoutId;
    }

    @Override
    protected void convert(ViewHolder holder, int position) {
        convert(holder, position, datas.get(position));
    }

    /**
     * item转换
     * @param holder 控件
     * @param position 下标
     * @param item 数据对象
     */
    protected abstract void convert(ViewHolder holder, int position, T item);

    /**
     * 根据下标删除item
     */
    public void remove(int position) {
        if (isEmpty()) {
            return;
        }
        datas.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * 根据对象删除item
     */
    public void remove(T data) {
        int index = datas.indexOf(data);
        datas.remove(data);
        if (index > 0) {
            notifyItemRemoved(index);
        } else {
            notifyDataSetChanged();
        }
    }

    public void add(T data) {
        datas.add(data);
        notifyItemInserted(datas.size() - 1);
    }

    public void add(int position, T data) {
        if (isEmpty()) {
            return;
        }
        datas.add(position, data);
        notifyItemInserted(position);
    }

    public void addAll(List<T> newData) {
        this.datas.addAll(newData);
        notifyItemRangeInserted(datas.size() - newData.size(), newData.size());
    }

    public void addAll(int position, List<T> data) {
        if (isEmpty()) {
            return;
        }
        datas.addAll(position, data);
        notifyItemRangeInserted(position, data.size());
    }

    public List<T> getData() {
        return datas;
    }

    public T getItem(int position) {
        return datas.get(position);
    }

    public void clear() {
        datas.clear();
        notifyDataSetChanged();
    }

    private boolean isEmpty() {
        return datas == null || datas.isEmpty();
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
