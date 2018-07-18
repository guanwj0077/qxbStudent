package com.qxb.student.ui.mine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.qxb.student.R;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.basics.ToolbarFragment;

public class LoginFragmentAbs extends AbsExpandFragment {
    @Override
    public int bindLayout() {
        return R.layout.fragment_login;
    }

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }
}
