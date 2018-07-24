package com.qxb.student.common.view.recycler.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * 可设置头部及脚部
 * @author winky
 */
public class HeaderRecyclerAdapter extends RecyclerView.Adapter {

    public static final int SHOW_HEADER = 1;
    public static final int SHOW_FOOTER = 2;
    private ArrayList<View> headViews;
    private ArrayList<View> footerView;
    private RecyclerView.Adapter adapter;

    public HeaderRecyclerAdapter(ArrayList<View> headViews, ArrayList<View> footerView, RecyclerView.Adapter adapter) {
        if (headViews == null) {
            this.headViews = new ArrayList<>();
        } else {
            this.headViews = headViews;
        }

        if (footerView == null) {
            this.footerView = new ArrayList<>();
        } else {
            this.footerView = footerView;
        }
        this.adapter = adapter;
    }

    @Override
    public int getItemViewType(int position) {
        //header
        int numHeaders = getHeadersCount();
        if (position < numHeaders) {
            return SHOW_HEADER;
        }
        // Adapter
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (adapter != null) {
            adapterCount = adapter.getItemCount();
            if (adjPosition < adapterCount) {
                return adapter.getItemViewType(adjPosition);
            }
        }
        // Footer (off-limits positions will throw an IndexOutOfBoundsException)
        return SHOW_FOOTER;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == SHOW_HEADER) {
            return new HeaderViewHolder(headViews.get(0));
        }
        if (viewType == SHOW_FOOTER) {
            return new HeaderViewHolder(footerView.get(0));
        }
        return adapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //也要划分三个区域
        int numHeaders = getHeadersCount();
        if (position < numHeaders) {//是头部
            return;
        }
        //adapter body
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (adapter != null) {
            adapterCount = adapter.getItemCount();
            if (adjPosition < adapterCount) {
                adapter.onBindViewHolder(holder, adjPosition);
                return;
            }
        }
        //footer
    }

    @Override
    public int getItemCount() {
        if (adapter != null) {
            return getFootersCount() + getHeadersCount() + adapter.getItemCount();
        } else {
            return getFootersCount() + getHeadersCount();
        }
    }

    public int getHeadersCount() {
        return headViews.size();
    }

    public int getFootersCount() {
        return footerView.size();
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
}
