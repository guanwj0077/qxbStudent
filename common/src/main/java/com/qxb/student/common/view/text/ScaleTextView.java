package com.qxb.student.common.view.text;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * 宽高相等的view
 * @author winky
 * @date 2018/7/25
 */
public class ScaleTextView extends android.support.v7.widget.AppCompatTextView {
    public ScaleTextView(Context context) {
        super(context);
    }

    public ScaleTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScaleTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (widthMeasureSpec > heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        } else {
            super.onMeasure(heightMeasureSpec, heightMeasureSpec);
        }
    }
}
