package com.qxb.student.common.recycler;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.qxb.student.common.recycler.adapter.ExtendRecyclerAdapter;

import java.util.ArrayList;

public class ExtendRecyclerView extends RecyclerView {

    private ArrayList<View> headerViews=new ArrayList<>();
    private ArrayList<View> footerViews=new ArrayList<>();

    private Adapter adapter;

    public ExtendRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void addHeaderView(View v) {
        headerViews.add(v);
        // Wrap the adapter if it wasn't already wrapped.
        if (adapter != null) {
            if (!(adapter instanceof ExtendRecyclerAdapter)) {
                adapter = new ExtendRecyclerAdapter(headerViews, footerViews, adapter);
            }
        }
    }

    public void addFooterView(View v) {
        footerViews.add(v);
        // Wrap the adapter if it wasn't already wrapped.
        if (adapter != null) {
            if (!(adapter instanceof ExtendRecyclerAdapter)) {
                adapter = new ExtendRecyclerAdapter(headerViews, footerViews, adapter);
            }
        }
    }

    @Override
    public void setAdapter(Adapter adapter) {
        if (headerViews.size() > 0|| footerViews.size() > 0) {
            adapter = new ExtendRecyclerAdapter(headerViews, footerViews, adapter);
        } else {
            adapter = adapter;
        }
        super.setAdapter(adapter);
    }
}
