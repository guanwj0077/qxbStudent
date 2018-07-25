package com.qxb.student.common.view.abslist.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * copy 自融云 baseAdapter
 *
 * @author winky
 * @date 2018/4/9
 */

public abstract class AbsListAdapter<Binding extends ViewDataBinding, T> extends AbsAdapter<T> {
    private Binding binding;

    public AbsListAdapter(Context context, @LayoutRes int layoutId) {
        super(context, layoutId);
    }

    @Override
    protected void bindView(View view, int position, T item) {
        position = getPosition(position);
        this.bind(binding, position, this.getItem(position));
    }

    @Override
    public View newView(Context context, int position, ViewGroup parent) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), getLayoutId(), parent, false);
        return binding.getRoot();
    }

    /**
     * 数据绑定
     *
     * @param binding  ViewDataBinding
     * @param position position
     * @param item     模型
     */
    protected abstract void bind(Binding binding, int position, T item);

    public void recovery() {
        if (binding != null) {
            binding.unbind();
            binding = null;
        }
    }
}
