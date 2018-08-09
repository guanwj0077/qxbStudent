package com.qxb.student.common.view.abslist.adapter;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qxb.student.common.R;
import com.qxb.student.common.listener.OnPositionClickListener;
import com.qxb.student.common.view.recycler.ViewHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author winky
 * @date 2018/7/24
 */
public abstract class AbsAdapter<T> extends android.widget.BaseAdapter {

    private Context context;
    private List<T> mList;
    private int layoutId;

    public AbsAdapter(Context context, @LayoutRes int layoutId) {
        this(context, layoutId, null);
    }

    public AbsAdapter(Context context, @LayoutRes int layoutId, List<T> data) {
        this.context = context;
        this.mList = data == null ? new ArrayList<T>() : data;
        this.layoutId = layoutId;
    }

    public Context getContext() {
        return context;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public List<T> getData() {
        return mList;
    }

    public void addCollection(List<T> collection) {
        if (collection.size() > 0 && mList.contains(collection.get(0))) {
            return;
        }
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
        View view;
        if (convertView != null) {
            view = convertView;
        } else {
            view = this.newView(this.context, position, parent);
        }
        this.bindView(view, position, this.getItem(position));
        return view;
    }

    /**
     * 为item绑定数据
     *
     * @param view
     * @param position
     * @param item
     */
    protected abstract void bindView(View view, int position, T item);

    /**
     * 创建新的item
     *
     * @param context
     * @param position
     * @param parent
     * @return
     */
    public View newView(Context context, int position, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(layoutId, null);
    }

    public void setVisibility(View view, @IdRes int id, boolean visibility) {
        view.findViewById(id).setVisibility(visibility ? View.VISIBLE : View.GONE);
    }

    public void setText(View view, @IdRes int id, String charSequence) {
        ((TextView) view.findViewById(id)).setText(charSequence);
    }

    public void setImageResource(View view, @IdRes int id, @DrawableRes int resId) {
        ((ImageView) view.findViewById(id)).setImageResource(resId);
    }

    public void setOnClickListener(View view, OnPositionClickListener clickListener) {
        view.setOnClickListener(clickListener);
    }
}
