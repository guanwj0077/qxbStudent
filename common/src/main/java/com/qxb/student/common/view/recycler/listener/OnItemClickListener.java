package com.qxb.student.common.view.recycler.listener;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * recyclerView item 点击监听
 * @author winky
 */
public interface OnItemClickListener {

    /**
     * 点击事件
     * @param parent 父级view
     * @param view 当前
     * @param position 下标
     */
    void onItemClick(RecyclerView parent, View view, int position);
}
