package com.qxb.student.common.view.recycler.adapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qxb.student.common.R;
import com.qxb.student.common.view.abslist.AbsAdapter;
import com.qxb.student.common.view.abslist.AbsListAdapter;
import com.qxb.student.common.view.recycler.ViewHolder;
import com.qxb.student.common.view.recycler.bean.ExpandableEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 可展开适配
 *
 * @author winky
 * @date 2018/7/24
 */
public abstract class ExpandableAdapter<G, C> extends NestingAdapter {

    private static final int PARENT = 0;
    private static final int CHILD = 1;

    private List<ExpandableEntity<G, C>> data;
    private int childRes;

    public ExpandableAdapter(@LayoutRes int parentRes, @LayoutRes int childRes) {
        this(parentRes, childRes, null);
    }

    public ExpandableAdapter(@LayoutRes int parentRes, @LayoutRes int childRes, @Nullable List<ExpandableEntity<G, C>> data) {
        this.childRes = childRes;
        addItemType(PARENT, parentRes);
        addItemType(CHILD, R.layout.view_list);
        this.data = data == null ? new ArrayList<ExpandableEntity<G, C>>() : data;
    }

    @Override
    protected void convert(ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case PARENT:
                parentConvert(holder, position, data.get(position).getGroupData());
                break;
            case CHILD:
                holder.setAdapter(R.id.listView, new AbsAdapter<C>(holder.itemView.getContext(), childRes, data.get(position).getChildDatas()) {
                    @Override
                    protected void bindView(View view, int position, C item) {
                        childConvert(view, position, item);
                    }
                });
                break;
            default:
                break;
        }
    }

    public void setDatas(List<ExpandableEntity<G, C>> data) {
        this.data.addAll(data);
        this.notifyDataSetChanged();
    }


    /**
     * 父级item转换
     *
     * @param holder   holder
     * @param position position
     * @param item     item
     */
    public abstract void parentConvert(ViewHolder holder, int position, G item);

    /**
     * 子级item转换
     *
     * @param view     view
     * @param position position
     * @param item     item
     */
    public abstract void childConvert(View view, int position, C item);
}
