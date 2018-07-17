package com.qxb.student.common.view.abslist;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * copy 自融云 baseAdapter
 * Created by winky on 2018/4/9.
 */

public abstract class AbsListAdapter<Binding extends ViewDataBinding, T> extends android.widget.BaseAdapter {

    private Context context;
    private List<T> mList;
    private int layoutId;

    public AbsListAdapter(Context context, @LayoutRes int layoutId) {
        this.context = context;
        this.mList = new ArrayList();
        this.layoutId = layoutId;
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

    public int getCount() {
        return this.mList == null ? 0 : this.mList.size();
    }

    public T getItem(int position) {
        return this.mList == null ? null : (position >= this.mList.size() ? null : this.mList.get(position));
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Binding binding;
        if (convertView != null) {
            binding = DataBindingUtil.getBinding(convertView);
        } else {
            binding = DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, parent, false);
        }
        position = getPosition(position);
        this.bind(binding, position, this.getItem(position));
        return binding.getRoot();
    }

    protected abstract void bind(Binding binding, int position, T item);
}
