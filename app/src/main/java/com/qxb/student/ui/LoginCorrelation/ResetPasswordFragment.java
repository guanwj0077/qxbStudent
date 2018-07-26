package com.qxb.student.ui.LoginCorrelation;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qxb.student.R;
import com.qxb.student.common.Constant;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.listener.MultiClickUtil;
import com.qxb.student.common.module.bean.LRegister;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResetPasswordFragment extends AbsExpandFragment {
    private TextView tv_tip;
    private LinearLayout ly_tip;


    @Override
    public int bindLayout() {
        return R.layout.fragment_reset_password;
    }

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        LRegister lRegister = getArguments().getParcelable(Constant.PURPOSE);
        ly_tip=findViewById(R.id.ly_tip);
        findViewById(R.id.tv_black).setOnClickListener(mOnClickListener);

    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (MultiClickUtil.isFastClick()) {
                switch (view.getId()) {
                    case R.id.tv_black:
                        getActivity().finish();
                        break;
                    default:
                        break;
                }
            }
        }
    };
}
