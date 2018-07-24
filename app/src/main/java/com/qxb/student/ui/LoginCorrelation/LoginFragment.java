package com.qxb.student.ui.LoginCorrelation;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.Editable;
import android.text.Html;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mob.tools.utils.UIHandler;
import com.qxb.student.R;
import com.qxb.student.common.Constant;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.listener.MultiClickUtil;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.module.bean.attr.NavAttr;
import com.qxb.student.common.utils.CommonUtils;
import com.qxb.student.common.utils.Encrypt;
import com.qxb.student.common.utils.JsonUtils;
import com.qxb.student.common.utils.NavigationUtils;
import com.qxb.student.common.utils.SharedUtils;
import com.qxb.student.common.utils.dialog.ToastUtils;
import com.qxb.student.common.view.ClearEditText;
import com.qxb.student.control.LoginControl;


import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;

/**
 * @author zjk9527
 */
public class LoginFragment extends AbsExpandFragment implements Handler.Callback, PlatformActionListener {
    private ClearEditText ed_phone;
    private EditText ed_psw;
    private CheckBox checkBox;
    private TextView tv_protocol;
    private RelativeLayout re;
    private String phone, password;
    private LoginControl loginControl;
    private static final int MSG_USERID_FOUND = 1;
    private static final int MSG_LOGIN = 2;
    private static final int MSG_AUTH_CANCEL = 3;
    private static final int MSG_AUTH_ERROR = 4;
    private static final int MSG_AUTH_COMPLETE = 5;
    private String openid, gender, head_url, nickname, type;

    @Override
    public int bindLayout() {
        return R.layout.fragment_login;
    }

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        loginControl = ViewModelProviders.of(getFragment()).get(LoginControl.class);
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
                        phone = ed_phone.getText().toString().replaceAll(" ", "");
                        password = ed_psw.getText().toString().trim();
                        hideInputMethod(getActivity());
                        showWaitingDialog();
                        GoLogin(phone, password);
                        break;
                    case R.id.look:
                        //去看看
                        break;
                    case R.id.tv_register:
                        Bundle bundle = new Bundle();
                        bundle.putString(Constant.PURPOSE, Constant.USER_REGISTER);
                        NavigationUtils.getInstance().toNavigation(getActivity(), new NavAttr.Builder().graphRes(R.navigation.register).params(bundle).build());
                        //注册
                        break;
                    case R.id.forget_pwd:
                        //忘记密码
                        Bundle bundle1 = new Bundle();
                        bundle1.putString(Constant.PURPOSE, Constant.USER_PASSWORD);
                        NavigationUtils.getInstance().toNavigation(getActivity(), new NavAttr.Builder().graphRes(R.navigation.register).params(bundle1).build());
                        break;
                    case R.id.iv_qq:
                        authorize(new QQ());
                        break;
                    case R.id.iv_weixin:
                        authorize(new Wechat());
                        break;
                    default:
                        break;
                }
            }
        }
    };

    private void GoLogin(final String phone, String password) {
        if (TextUtils.isEmpty(phone)) {
            ToastUtils.toast(getActivity(), getString(R.string.yhmbnwk));
            return;
        }
        if (TextUtils.isEmpty(password)) {
            ToastUtils.toast(getActivity(), getString(R.string.mmgsbzq));
            return;
        }
        loginControl.login(phone, password).observe(LoginFragment.this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                dissWaitingDialog();
                SharedUtils.get().put(Constant.SHARE_FILE_CURRENCY, phone);
                getActivity().finish();
                //NavigationUtils.getInstance().goBack(getFragment());
            }
        });
    }

    private void authorize(Platform plat) {
        showWaitingDialog();
        if (plat.isAuthValid()) {
            String userId = plat.getDb().getUserId();
            getThirdData(plat);
            if (TextUtils.isEmpty(userId)) {
                UIHandler.sendEmptyMessage(MSG_USERID_FOUND, this);
                login(userId, null);
                return;
            }
        }
        plat.setPlatformActionListener(this);
        //true不使用SSO授权，false使用SSO授权
        plat.SSOSetting(false);
        plat.showUser(null);

    }

    //发送登陆信息
    private void login(String userId, HashMap<String, Object> userInfo) {
        Message msg = new Message();
        msg.what = MSG_LOGIN;
        UIHandler.sendMessage(msg, this);

    }

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

    @Override
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case MSG_USERID_FOUND:
                /*用户信息已存在，正在跳转登录操作…*/
                break;
            case MSG_LOGIN:
                /*使用%s帐号登录中…*/
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getLoginpermission();
                    }
                }, 1000);
                break;
            case MSG_AUTH_CANCEL: {
                /*授权操作已取消*/
                dissWaitingDialog();
                Toast.makeText(getActivity(), R.string.auth_cancel, Toast.LENGTH_SHORT).show();
            }
            break;
            case MSG_AUTH_ERROR: {
                dissWaitingDialog();
                /*授权操作遇到错误，请阅读Logcat输出*/
                Toast.makeText(getActivity(), R.string.auth_error, Toast.LENGTH_SHORT).show();
            }
            break;
            case MSG_AUTH_COMPLETE:
                /*授权成功，正在跳转登录操作…*/
                Toast.makeText(getActivity(), R.string.auth_complete, Toast.LENGTH_SHORT).show();

                break;
            default:
                break;
        }
        return false;
    }

    private void getLoginpermission() {
        loginControl.ThirdLogin(type, openid).observe(LoginFragment.this, new Observer<ApiModel<String>>() {
            @Override
            public void onChanged(@Nullable ApiModel<String> stringApiModel) {

                if (stringApiModel.getCode() == Constant.ZERO) {
                    //  去绑定手机号码
                } else {
                    JSONObject jsonObject = JSON.parseObject(stringApiModel.toString());
                    String login_name = jsonObject.getString("login_name");
                    String login_pwd = jsonObject.getString("login_pwd");
                    if (!TextUtils.isEmpty(login_name) && !TextUtils.isEmpty(login_pwd)) {
                        GoLogin(login_name, login_pwd);
                    }

                }
            }
        });


    }

    private void getThirdData(Platform plat) {
        openid = plat.getDb().getUserId();
        head_url = plat.getDb().getUserIcon();
        gender = plat.getDb().getUserGender();
        type = "QQ".equals(plat.getName()) ? "1" : "2";
        if (TextUtils.isEmpty(plat.getDb().getUserGender())) {
            gender = "m".equals(plat.getDb().getUserGender()) ? Constant.MAN : Constant.WOMEN;
        } else {
            gender = "";
        }
    }

    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        if (i == Platform.ACTION_USER_INFOR) {
            /*能登录的话  获取用户信息*/
            UIHandler.sendEmptyMessage(MSG_USERID_FOUND, (Handler.Callback) getActivity());
            login(platform.getDb().getUserId(), hashMap);
            getThirdData(platform);
        }
        platform.removeAccount(true);

    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        dissWaitingDialog();
        if (i == Platform.ACTION_USER_INFOR) {
            UIHandler.sendEmptyMessage(MSG_AUTH_ERROR, this);
        }
        throwable.printStackTrace();
    }

    @Override
    public void onCancel(Platform platform, int i) {
        if (i == Platform.ACTION_USER_INFOR) {
            UIHandler.sendEmptyMessage(MSG_AUTH_CANCEL, this);
        }
    }


}
