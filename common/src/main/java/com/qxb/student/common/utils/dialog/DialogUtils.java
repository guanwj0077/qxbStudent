package com.qxb.student.common.utils.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.qxb.student.common.R;

/**
 * author: zjk9527
 * created on: 2018/7/19 17:26
 * description:
 */
public class DialogUtils {
    private Context context;
    private AlertDialog dialog;
    public TextView title;

    public DialogUtils(Context paramContext) {
        this.context = paramContext;
        this.dialog = new AlertDialog.Builder(paramContext).create();
    }

    public void dismiss() {
        try {
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTitleText(CharSequence paramCharSequence) {
        this.title.setText(paramCharSequence);
    }

    public void show() {
        try {
            this.dialog.show();
           // int width = App.getInstance().displayWith;
            WindowManager.LayoutParams localLayoutParams = dialog.getWindow()
                    .getAttributes();
           /* localLayoutParams.width = width;
            dialog.getWindow().setAttributes(localLayoutParams);*/
            dialog.setCanceledOnTouchOutside(false);
            this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            View localView = ((Activity) this.context).getLayoutInflater()
                    .inflate(R.layout.progress_dialog_view, null);
            dialog.setCancelable(true);// 设置点击返回键取消
            this.title = ((TextView) localView.findViewById(R.id.title));
            this.dialog.getWindow().setContentView(localView);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }
}
