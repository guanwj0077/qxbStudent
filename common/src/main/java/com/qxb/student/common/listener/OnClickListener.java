package com.qxb.student.common.listener;

import android.view.View;


/**
 * author: zjk9527
 * created on: 2018/6/15 15:48
 * description:
 */

public abstract class OnClickListener<T> implements View.OnClickListener {

    private T t;

    public OnClickListener(T t) {
        this.t = t;
    }

    @Override
    public void onClick(View v) {
        v.setClickable(false);
        onClick(v, t);
        v.postDelayed(new TRunnable<View>(v) {
            @Override
            public void run(View view) {
                view.setClickable(true);
            }
        }, 800);
    }

    public abstract void onClick(View v, T t);
}
