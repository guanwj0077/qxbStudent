package com.qxb.student.ui.UserCorrelation;


import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.qxb.student.R;
import com.qxb.student.common.Constant;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.listener.MultiClickUtil;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.LRegister;
import com.qxb.student.common.module.bean.attr.NavAttr;
import com.qxb.student.common.utils.CommonUtils;
import com.qxb.student.common.utils.NavigationUtils;
import com.qxb.student.common.utils.SharedUtils;
import com.qxb.student.common.view.dialog.ToastUtils;
import com.qxb.student.control.ResetPasswordControl;


/**
 * A simple {@link Fragment} subclass.
 *
 * @author Administrator
 */
public class ResetPasswordCodeFragment extends AbsExpandFragment {
    private TextView tv_hint, tv_code, submit, login, tvTip;
    private LinearLayout ly_tip;
    private EditText et_phone, et_code;
    private String phone, purpose ,code;
    private ResetPasswordControl mPasswordControl;

    @Override
    public int bindLayout() {
        return R.layout.fragment_register;
    }

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mPasswordControl = ViewModelProviders.of(getActivity()).get(ResetPasswordControl.class);
        purpose = getStringExtra(Constant.PURPOSE);
        tv_hint = findViewById(R.id.tv_hint);
        tvTip = findViewById(R.id.tv_tip);
        ly_tip = findViewById(R.id.ly_tip);
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
        String phone = (String) SharedUtils.get().get(Constant.SHARE_FILE_CURRENCY, "");
        if (!TextUtils.isEmpty(phone)) {
            phone = phone.substring(0, 3) + " " + phone.substring(3, 7) + " " + phone.substring(7, phone.length());
            et_phone.setText(phone);
        }


    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.tv_black:
                        getActivity().finish();
                        break;
                    case R.id.submit:
                        //注册/修改密码
                        code = tv_code.getText().toString().replaceAll(" ", "");

                        checkCode(phone,code);

                        break;
                    case R.id.login:
                        //已有账号登录
                        getActivity().finish();
                        break;
                    case R.id.tv_code:
                        //发送验证码
                        if (MultiClickUtil.isFastClick()){
                            phone = et_phone.getText().toString().replaceAll(" ", "");
                            sendCode(phone);
                        }
                        break;
                    default:
                        break;
                }
            }

    };

    private void checkCode(final String phone, final String code) {
        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(phone)) {
            ToastUtils.toast(getActivity(),getString(R.string.phone_must_not_be_empty));
            return;
        } else if (TextUtils.isEmpty(code)) {
            ToastUtils.toast(getActivity(),getString(R.string.code_must_be_right));
            return;
        }
        hideInputMethod(getActivity());
        showWaitingDialog();
        mPasswordControl.checkCode(phone,code).observe(ResetPasswordCodeFragment.this, new Observer<ApiModel<JSONObject>>() {
            @Override
            public void onChanged(@Nullable ApiModel<JSONObject> jsonObjectApiModel) {
                dissWaitingDialog();
                if (jsonObjectApiModel.getCode()==Constant.ONE){
                    Bundle bundle=new Bundle();
                    LRegister lRegister=new LRegister();
                    lRegister.setTitle(purpose);
                    lRegister.setPhone(phone);
                    lRegister.setSmsCode(code);
                    bundle.putParcelable(Constant.PURPOSE,lRegister);
                    NavigationUtils.getInstance().toNavigation(getActivity(),new NavAttr.Builder().graphRes(R.navigation.nav_password).params(bundle).build());

                }else{
                    ToastUtils.toast(getActivity(),jsonObjectApiModel.getMsg());
                }
            }
        });

    }

    private void sendCode(String phone) {
        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(phone)) {
            ToastUtils.toast(getActivity(), getString(R.string.sjhmbnwk));
            return;
        } else if (!CommonUtils.rightPhone(phone)) {
            ToastUtils.toast(getActivity(), getString(R.string.qsrzqdsjhm));
            return;
        }
        tv_code.setEnabled(false);
        handler.postDelayed(runnable, 1000);
        mPasswordControl.sendCode(phone, Constant.USER_REGISTER.equals(purpose) ? "1" : "2").observe(ResetPasswordCodeFragment.this, new Observer<ApiModel<JSONObject>>() {
            @Override
            public void onChanged(@Nullable ApiModel<JSONObject> apiModel) {
                if (apiModel.getCode() == Constant.ONE) {
                    tvTip.setText(R.string.code_send_success);
                    ly_tip.setVisibility(View.VISIBLE);
                    ly_tip.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.head_in));

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ly_tip.setVisibility(View.GONE);
                            ly_tip.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.head_out));
                        }
                    }, 4000);
                } else {
                    ToastUtils.toast(getActivity(), apiModel.getMsg());
                   tv_code.setText(getResources().getString(R.string.fsyzm));
                    handler.removeCallbacks(runnable);
                    tv_code.setEnabled(true);
                }
            }
        });

    }

    final class ETPhoneTextWatcher implements TextWatcher {
        private String mChangedText;

        ETPhoneTextWatcher() {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (editable.length()==13){
                tv_code.setEnabled(true);
            }
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

    private final static int countTime = 120;
    private int curTime = countTime;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (curTime == 0) {
                tv_code.setEnabled(true);
                tv_code.setText(getResources().getString(R.string.fsyzm));
                curTime = countTime;
                handler.removeCallbacks(this);
            } else {
                curTime--;
                tv_code.setText(getResources().getString(R.string.code_send_down, String.valueOf(curTime)));
                handler.postDelayed(this, 1000);
            }
        }
    };

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 1:
                    String codeMsg = msg.getData().getString("messagecode");
                    et_code.setText(codeMsg);
                    break;

                default:
                    break;
            }

        }

        ;
    };


    @SuppressLint("RestrictedApi")
    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);

    }
}
