package com.qxb.student.ui.UserCorrelation;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qxb.student.R;
import com.qxb.student.common.Constant;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.listener.MultiClickUtil;
import com.qxb.student.common.module.bean.LRegister;
import com.qxb.student.common.utils.dialog.ToastUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResetPasswordFragment extends AbsExpandFragment {
    private TextView tv_tip;
    private LinearLayout ly_tip;
    private EditText et_newpassword, et_newpassword_confirm;


    @Override
    public int bindLayout() {
        return R.layout.fragment_reset_password;
    }

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        LRegister lRegister = getArguments().getParcelable(Constant.PURPOSE);
        ly_tip = findViewById(R.id.ly_tip);
        et_newpassword = findViewById(R.id.et_newpassword);
        et_newpassword_confirm = findViewById(R.id.et_newpassword_confirm);
        findViewById(R.id.tv_black).setOnClickListener(mOnClickListener);
        findViewById(R.id.submit).setOnClickListener(mOnClickListener);

    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (MultiClickUtil.isFastClick()) {
                switch (view.getId()) {
                    case R.id.tv_black:
                        getActivity().finish();
                        break;
                    case R.id.submit:
                        String password = et_newpassword.getText().toString().trim();
                        String password_confirm=et_newpassword_confirm.getText().toString().trim();
                        sendRegister(password,password_confirm);
                        break;
                    default:
                        break;
                }
            }
        }
    };

    private void sendRegister(String password, String password_confirm) {
        if (TextUtils.isEmpty(password)||TextUtils.isEmpty(password_confirm)){
            ToastUtils.toast(getActivity(),getString(R.string.qqrmm));
            return;
        }
    }
}
