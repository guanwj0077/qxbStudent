package com.qxb.student.common.recycler.listener;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public interface OnItemClickListener {

    void onItemClick(RecyclerView parent, View view, int position);
}