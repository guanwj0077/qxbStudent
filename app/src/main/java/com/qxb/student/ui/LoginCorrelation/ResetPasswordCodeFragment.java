package com.qxb.student.ui.LoginCorrelation;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.qxb.student.R;
import com.qxb.student.common.Constant;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.listener.MultiClickUtil;
import com.qxb.student.common.utils.CommonUtils;
import com.qxb.student.common.utils.SharedUtils;
import com.qxb.student.common.utils.dialog.ToastUtils;
import com.qxb.student.common.view.Toolbar;

/**
 * A simple {@link Fragment} subclass.
 *
 * @author Administrator
 */
public class ResetPasswordCodeFragment extends AbsExpandFragment {
    private TextView tv_hint, tv_code, submit, login;
    private EditText et_phone, et_code;
    private String phone;

    @Override
    public int bindLayout() {
        return R.layout.fragment_register;
    }

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        String purpose = getStringExtra(Constant.PURPOSE);
        tv_hint = findViewById(R.id.tv_hint);
        tv_code = findViewById(R.id.tv_code);
        submit = findViewById(R.id.submit);
        login = findViewById(R.id.login);
        et_phone = findViewById(R.id.et_phone);
        et_code = findViewById(R.id.et_code);
        tv_hint.setText(getResources().getString(Constant.USER_REGISTER.equals(purpose) ? R.string.user_register : R.string.user_password));
        login.setText(Html.fromHtml(getResources().getString(R.string.yyzhanghaoqdl)));
        login.setVisibility(Constant.USER_REGISTER.equals(purpose) ? View.VISIBLE : View.GONE);
        findViewById(R.id.tv_black).setOnClickListener(mOnClickListener);
        submit.setOnClickListener(mOnClickListener);
        login.setOnClickListener(mOnClickListener);
        tv_code.setOnClickListener(mOnClickListener);
        et_phone.addTextChangedListener(new ETPhoneTextWatcher());
        String phone= (String) SharedUtils.get().get(Constant.SHARE_FILE_CURRENCY,"");
        if (!TextUtils.isEmpty(phone)){
            phone = phone.substring(0, 3) + " " + phone.substring(3, 7) + " " + phone.substring(7, phone.length());
            et_phone.setText(phone);
        }



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
                        //注册/修改密码
                        break;
                    case R.id.login:
                        //已有账号登录
                        break;
                    case R.id.tv_code:
                        //发送验证码
                        phone = et_phone.getText().toString().replaceAll(" ", "");
                        sendCode(phone);
                        break;
                    default:
                        break;
                }
            }
        }
    };

    private void sendCode(String phone) {
        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(phone)) {
            ToastUtils.toast(getActivity(),getString(R.string.sjhmbnwk));
            return;
        } else if (!CommonUtils.rightPhone(phone)) {
            ToastUtils.toast(getActivity(),getString(R.string.qsrzqdsjhm));
            return;
        }

    }

    final class ETPhoneTextWatcher implements TextWatcher {
        private String mChangedText;

        ETPhoneTextWatcher() {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() == 0) {
                return;
            }
            String str = editable.toString().replaceAll(" ", "");
            if (str.length() <= 3
                    || editable.toString().equals(this.mChangedText)) {
                return;
            }
            if (str.length() < 8) {
                return;
            }
            mChangedText = (str.substring(0, 3) + " "
                    + str.substring(3, 7) + " " + str.substring(7, str.length()));
            et_phone.setText(mChangedText);
            et_phone.setSelection(mChangedText.length());
        }

        @Override
        public void beforeTextChanged(CharSequence paramCharSequence,
                                      int paramInt1, int paramInt2, int paramInt3) {
        }

        @Override
        public void onTextChanged(CharSequence paramCharSequence,
                                  int paramInt1, int paramInt2, int paramInt3) {
        }
    }
}
