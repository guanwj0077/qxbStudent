package com.qxb.student.common.adapter;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.qxb.student.common.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;

import java.util.List;
import java.util.Random;

/**
 * @author winky
 * @date 2018/7/25
 */
public class SchoolTagAdapter extends TagAdapter<String> {

    private int[] tagRes = {
            R.drawable.shape_tag_1,
            R.drawable.shape_tag_2,
            R.drawable.shape_tag_3,
            R.drawable.shape_tag_4,
            R.drawable.shape_tag_5,
            R.drawable.shape_tag_6};

    public SchoolTagAdapter(List<String> data) {
        super(data);
    }

    @Override
    public View getView(FlowLayout parent, int position, String s) {
        int count = getCount() - 1;
        int index = Math.abs(count - position);
        if (index > count) {
            index = new Random().nextInt(count);
        }
        TextView textView = new TextView(parent.getContext());
        textView.setBackgroundResource(tagRes[index]);
        textView.setText(s);
        textView.setTextColor(Color.WHITE);
        textView.setPadding(8, 3, 8, 3);
        textView.setTextSize(12);
        return textView;
    }
}
