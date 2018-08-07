package com.qxb.student.common.utils.dialog;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qxb.student.common.Constant;
import com.qxb.student.common.R;
import com.qxb.student.common.utils.ContextUtils;

/**
 * author: zjk9527
 * created on: 2018/7/19 16:26
 * description:
 */
public class ToastUtils {
    private static Toast toast;

    public static void toast(int textRes) {
        toast(ContextUtils.getInstance().getContext(), textRes);
    }

    public static void toast(Context context, int textRes) {
        CharSequence text = context.getResources().getText(textRes);
        if (context != null) {
            makeText(context, text).show();
        }

    }

    public static void toast(Context context, CharSequence sequence) {
        if (context != null) {
            makeText(context, sequence).show();
        }

    }

    public static void toast(Context context, String s) {
        if (context != null) {
            makeText(context, s).show();
        }

    }

    public static void toastWithCat(Context context, int textRes, boolean isHappy) {
        CharSequence text = context.getResources().getText(textRes);
        if (context != null) {
            toastWithCat(context, text, isHappy);
        }

    }

    public static void toastWithCat(Context context, CharSequence text, boolean isHappy) {
        Toast result = new Toast(context);

        LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(R.layout.ui_toast, null);
        result.setView(v);
        ImageView iv = (ImageView) v.findViewById(android.R.id.icon);

        TextView tv = (TextView) v.findViewById(android.R.id.message);
        tv.setText(text);

        result.setGravity(Gravity.CENTER, 0, 0);
        result.setDuration(Toast.LENGTH_SHORT);
        result.show();
    }

    public static Toast makeText(Context context, CharSequence text) {

        if (toast == null) {
            toast = new Toast(context);
        }
        LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(R.layout.ui_toast, null);
        toast.setView(v);
        TextView tv = (TextView) v.findViewById(android.R.id.message);
        tv.setText(context.getResources().getString(R.string.app_name) + ":" + text);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);

        return toast;
    }
}
