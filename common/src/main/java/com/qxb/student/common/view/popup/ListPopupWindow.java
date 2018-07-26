package com.qxb.student.common.view.popup;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.qxb.student.common.R;
import com.qxb.student.common.view.abslist.adapter.AbsAdapter;

/**
 * @author winky
 * @date 2018/7/26
 */
public class ListPopupWindow<T> extends PopupWindow {

    public ListPopupWindow(Context context) {
        super(context);
        init(context);
    }

    private ListView listView;

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_list, null);
        listView = view.findViewById(R.id.listView);
        listView.setBackgroundResource(R.drawable.stroke_gray);
        listView.setDivider(ContextCompat.getDrawable(context,R.color.colorTheme));
        listView.setDividerHeight(2);
        setFocusable(true);
        ColorDrawable dw = new ColorDrawable(0x00);
        setBackgroundDrawable(dw);
        setTouchable(true);
        setOutsideTouchable(true);
        setContentView(view);
    }

    public void setAdapter(AbsAdapter<T> adapter) {
        this.listView.setAdapter(adapter);
    }

    @Override
    public void showAsDropDown(View anchor) {
        setWidth(anchor.getWidth());
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        super.showAsDropDown(anchor);
    }
}
