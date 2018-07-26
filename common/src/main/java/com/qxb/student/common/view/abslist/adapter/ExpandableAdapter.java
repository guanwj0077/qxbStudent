package com.qxb.student.common.view.abslist.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qxb.student.common.R;
import com.qxb.student.common.view.abslist.bean.ExpandableEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author winky
 * @date 2018/7/24
 */
public abstract class ExpandableAdapter<P, C> extends BaseExpandableListAdapter {


    private final int parentRes;
    private final int childRes;
    private final List<ExpandableEntity<P, C>> data;
    private final LayoutInflater inflater;

    public ExpandableAdapter(Context context, @LayoutRes int parentRes, @LayoutRes int childRes) {
        this(context, parentRes, childRes, null);
    }

    public ExpandableAdapter(Context context, @LayoutRes int parentRes, @LayoutRes int childRes, List<ExpandableEntity<P, C>> data) {
        this.inflater = LayoutInflater.from(context);
        this.parentRes = parentRes;
        this.childRes = childRes;
        this.data = data == null ? new ArrayList<ExpandableEntity<P, C>>() : data;
    }

    public void setData(List<ExpandableEntity<P, C>> data) {
        this.data.clear();
        this.data.addAll(data);
    }

    public void clear() {
        this.data.clear();
    }

    @Override
    public int getGroupCount() {
        return data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data.get(groupPosition).getChild().size();
    }

    @Override
    public P getGroup(int i) {
        return data.get(i).getParent();
    }

    @Override
    public C getChild(int i, int i1) {
        return data.get(i).getChild().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int position, boolean isExpanded, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = inflater.inflate(parentRes, null);
        } else {
            view = convertView;
        }
        this.bindGroupView(view, position, isExpanded, this.getGroup(position));
        return view;
    }

    /**
     * 绑定父级item
     *
     * @param view
     * @param position
     * @param isExpanded
     * @param item
     */
    public abstract void bindGroupView(View view, int position, boolean isExpanded, P item);

    /**
     * 绑定子级item
     *
     * @param view
     * @param item
     */
    public abstract void bindChildView(View view, C item);

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = inflater.inflate(childRes, null);
        } else {
            view = convertView;
        }
        this.bindChildView(view, this.getChild(groupPosition, childPosition));
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    public void setVisibility(View view, @IdRes int id, boolean visibility) {
        view.findViewById(id).setVisibility(visibility ? View.VISIBLE : View.GONE);
    }

    public void setArrowExpanded(View view, @IdRes int id, boolean isExpanded) {
        ((ImageView) view.findViewById(id)).setImageResource(isExpanded ? R.drawable.arrow_bottom_gray : R.drawable.arrow_top_gary);
    }

    public void setText(View view, @IdRes int id, String charSequence) {
        ((TextView) view.findViewById(id)).setText(charSequence);
    }
}
