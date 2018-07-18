package com.qxb.student.common.view.recycler;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

/**
 * @author winky
 * @date 2018/7/18
 */
public class DefViewHolder<V extends ViewDataBinding> extends RecyclerView.ViewHolder{

    V binding;

    public DefViewHolder(@NonNull V binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public V getBinding() {
        return binding;
    }
}
