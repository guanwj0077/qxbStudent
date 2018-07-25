package com.qxb.student.common.adapter;

import android.content.Context;

import com.qxb.student.common.R;
import com.qxb.student.common.databinding.ViewImageBinding;
import com.qxb.student.common.view.abslist.adapter.AbsListAdapter;

/**
 * banner适配器
 *
 * @author winky
 * @date 2018/4/10
 */
public abstract class BannerAdapter<T> extends AbsListAdapter<ViewImageBinding, T> {

    /**
     * 是否轮播
     */
    private boolean isLoop;

    public BannerAdapter(Context context, boolean isLoop) {
        super(context, R.layout.view_image);
        this.isLoop = isLoop;
    }

    @Override
    public int getCount() {
        return isLoop ? Integer.MAX_VALUE : super.getCount();
    }

    @Override
    public int getPosition(int position) {
        int count = super.getCount();
        if (count == 0) {
            return position;
        } else {
            return isLoop ? position % count : position;
        }
    }
}
