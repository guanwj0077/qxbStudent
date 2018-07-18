package com.qxb.student.common.view.abslist;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * copy 自融云 baseAdapter
 * Created by winky on 2018/4/9.
 */

public abstract class AbsListAdapter<Binding extends ViewDataBinding, T> extends android.widget.BaseAdapter {

    private Context context;
    private List<T> mList;
    private int layoutId;
    private Binding binding;

    public AbsListAdapter(Context context, @LayoutRes int layoutId) {
        this.context = context;
        this.mList = new ArrayList();
        this.layoutId = layoutId;
        this.binding = DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, null, false);
    }

    public void addCollection(Collection<T> collection) {
        this.mList.addAll(collection);
    }

    public void add(T t) {
        this.mList.add(t);
    }

    public void add(T t, int position) {
        this.mList.add(position, t);
    }

    public void remove(int position) {
        this.mList.remove(position);
    }

    public int getPosition(int position) {
        return position;
    }

    public void removeAll() {
        this.mList.clear();
    }

    public void clear() {
        this.mList.clear();
    }

    @Override
    public int getCount() {
        return this.mList == null ? 0 : this.mList.size();
    }

    @Override
    public T getItem(int position) {
        return this.mList == null ? null : (position >= this.mList.size() ? null : this.mList.get(position));
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = getBinding(getItemViewType(position)).getRoot();
        }
        position = getPosition(position);
        this.bind(getBinding(getItemViewType(position)), position, this.getItem(position));
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public Binding getBinding(int viewType) {
        return binding;
    }

    protected abstract void bind(Binding binding, int position, T item);
}
