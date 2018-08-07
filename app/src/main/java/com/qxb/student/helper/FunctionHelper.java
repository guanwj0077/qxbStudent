package com.qxb.student.helper;

import android.content.Context;

import com.qxb.student.common.module.bean.FunctionItem;

/**
 * @author winky
 * @date 2018/7/26
 */
public class FunctionHelper {

    public static void jump(Context context, FunctionItem item) {
        if (context == null || item == null) {
            return;
        }
        switch (item.getItem_type()) {
            case "10":
                break;
            default:
                break;

        }

    }
}
