package com.qxb.student.common.utils.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qxb.student.common.R;

/**
 * author: zjk9527
 * created on: 2018/7/12 17:46
 * description:
 */
public class LoadingFragment extends DialogFragment {
    private String mText;
    private TextView tipTextView;

    public LoadingFragment() {

    }


    @SuppressLint("ValidFragment")
    public LoadingFragment(String text) {
        this.mText = text;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View v = inflater.inflate(R.layout.dialog_view, null);
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);
        Dialog loadingDialog = new Dialog(getActivity(), R.style.CustomDialog);
        loadingDialog.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失
        loadingDialog.setCancelable(true);// 设置点击返回键取消

        loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        return loadingDialog;

    }
}
