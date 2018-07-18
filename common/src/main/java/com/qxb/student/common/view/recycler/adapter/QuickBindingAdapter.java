package com.qxb.student.common.view.recycler.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qxb.student.common.view.recycler.DefViewHolder;
import com.qxb.student.common.view.recycler.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * QuickBindingAdapter
 *
 * @author winky
 * @date 2018/7/18
 */
public abstract class QuickBindingAdapter<V extends ViewDataBinding, T> extends RecyclerView.Adapter<DefViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private OnItemClickListener itemClickListener;
    private final int layoutId;
    private final List<T> data;

    protected QuickBindingAdapter(@LayoutRes int layoutId) {
        this(layoutId, null);
    }

    protected QuickBindingAdapter(@LayoutRes int layoutId, List<T> data) {
        this.data = data == null ? new ArrayList<T>() : data;
        this.layoutId = layoutId;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    protected int getLayoutId(int viewType) {
        return layoutId;
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public DefViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        if (context == null) {
            this.context = viewGroup.getContext();
        }
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(context);
        }
        V binding = DataBindingUtil.inflate(layoutInflater, layoutId, null, false);
        binding.getRoot().setOnClickListener(clickListener);
        return new DefViewHolder(binding);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            View view = (View) v.getParent();
            if (view == null || itemClickListener == null) {
                return;
            }
            v.setClickable(false);
            if (view instanceof RecyclerView) {
                RecyclerView recyclerView = (RecyclerView) view;
                int position = recyclerView.getChildAdapterPosition(v);
                itemClickListener.onItemClick(recyclerView, v, position);
            }
            v.setClickable(true);
        }
    };

    @Override
    public void onBindViewHolder(@NonNull DefViewHolder viewHolder, int i) {
        convert((V) viewHolder.getBinding(), i);
    }

    /**
     * 数据绑定
     *
     * @param binding  ViewDataBinding
     * @param position 下标
     */
    public abstract void convert(@NonNull V binding, int position);

    /**
     * 根据下标删除item
     */
    public void remove(int position) {
        if (isEmpty()) {
            return;
        }
        this.data.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * 根据对象删除item
     */
    public void remove(T data) {
        int index = this.data.indexOf(data);
        this.data.remove(data);
        if (index > 0) {
            notifyItemRemoved(index);
        } else {
            notifyDataSetChanged();
        }
    }

    public void add(T data) {
        this.data.add(data);
        notifyItemInserted(this.data.size() - 1);
    }

    public void add(int position, T data) {
        if (isEmpty()) {
            return;
        }
        this.data.add(position, data);
        notifyItemInserted(position);
    }

    public void addAll(List<T> newData) {
        this.data.addAll(newData);
        notifyItemRangeInserted(data.size() - newData.size(), newData.size());
    }

    public void addAll(int position, List<T> data) {
        if (isEmpty()) {
            return;
        }
        this.data.addAll(position, data);
        notifyItemRangeInserted(position, data.size());
    }

    public List<T> getData() {
        return this.data;
    }

    public T getItem(int position) {
        return data.get(position);
    }

    public void clear() {
        data.clear();
        notifyDataSetChanged();
    }

    private boolean isEmpty() {
        return data == null || data.isEmpty();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
