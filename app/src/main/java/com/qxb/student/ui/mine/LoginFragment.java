package com.qxb.student.ui.mine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.Html;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qxb.student.R;
import com.qxb.student.common.Config;
import com.qxb.student.common.Constant;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.listener.MultiClickUtil;
import com.qxb.student.common.utils.CommonUtils;
import com.qxb.student.common.utils.SharedUtils;
import com.qxb.student.common.utils.dialog.ToastUtils;
import com.qxb.student.common.view.ClearEditText;
import com.qxb.student.common.view.InputMethodRelativeLayout;

import java.util.prefs.Preferences;

/**
 * @author zjk9527
 */
public class LoginFragment extends AbsExpandFragment {
    private ClearEditText ed_phone;
    private EditText ed_psw;
    private CheckBox checkBox;
    private TextView tv_protocol;
    private RelativeLayout re;
    private String phone, password;

    @Override
    public int bindLayout() {
        return R.layout.fragment_login;
    }

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ed_phone = findViewById(R.id.ed_phone);
        ed_psw = findViewById(R.id.ed_psw);
        checkBox = findViewById(R.id.checkBox);
        tv_protocol = findViewById(R.id.tv_protocol);
        re = findViewById(R.id.re);
        tv_protocol.setText(Html.fromHtml(getResources().getString(R.string.login_ordinance)));
        setKeyboardStateListener();
        findViewById(R.id.submit).setOnClickListener(mOnClickListener);
        findViewById(R.id.look).setOnClickListener(mOnClickListener);
        findViewById(R.id.tv_register).setOnClickListener(mOnClickListener);
        findViewById(R.id.forget_pwd).setOnClickListener(mOnClickListener);
        findViewById(R.id.iv_qq).setOnClickListener(mOnClickListener);
        findViewById(R.id.iv_weixin).setOnClickListener(mOnClickListener);
        String phone = (String) SharedUtils.get().get(Constant.SHARE_PHONE, "");
        if (CommonUtils.rightPhone(phone)) {
            phone = phone.substring(0, 3) + " " + phone.substring(3, 7) + " " + phone.substring(7, phone.length());
            ed_phone.setText(phone);
            ed_psw.requestFocus();
        }
        ed_phone.addTextChangedListener(editTextonClick);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ed_psw.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    ed_psw.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });

    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (MultiClickUtil.isFastClick()) {
                switch (view.getId()) {
                    case R.id.submit:
                        //登录
                        phone = ed_phone.getText().toString().trim();
                        password = ed_psw.getText().toString().trim();
                        if(TextUtils.isEmpty(phone)){
                            ToastUtils.toast(getActivity(),getString(R.string.yhmbnwk));
                            return;
                        }else if (CommonUtils.rightPhone(phone)){
                            ToastUtils.toast(getActivity(),getString(R.string.qsrzqdyhm));
                            return;
                        }
                        if (TextUtils.isEmpty(password)){
                            ToastUtils.toast(getActivity(),getString(R.string.mmgsbzq));
                            return;
                        }
                        hideInputMethod(getActivity());

                        break;
                    case R.id.look:
                        //去看看
                        break;
                    case R.id.tv_register:
                        //注册
                        break;
                    case R.id.forget_pwd:
                        //忘记密码
                        break;
                    case R.id.iv_qq:

                        break;
                    case R.id.iv_weixin:
                        break;
                    default:
                        break;
                }
            }
        }
    };
    private TextWatcher editTextonClick = new TextWatcher() {
        private String mChangedText;

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.length() == 13) {
                ed_psw.requestFocus();
            }
            if (s == null || s.length() == 0) {
                return;
            }
            String str = s.toString().replaceAll(" ", "");
            if (str.length() <= 3
                    || s.toString().equals(this.mChangedText)) {
                return;
            }
            if (str.length() < 8) {
                return;
            }

            mChangedText = (str.substring(0, 3) + " "
                    + str.substring(3, 7) + " " + str.substring(7, str.length()));
            ed_phone.setText(mChangedText);
            ed_phone.setSelection(mChangedText.length());

        }
    };

    @Override
    public void onKeyBoardHide() {
        super.onKeyBoardHide();
        re.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 0.8f));
    }

    @Override
    public void onKeyBoardShow() {
        super.onKeyBoardShow();
        re.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 0.4f));
    }
}
