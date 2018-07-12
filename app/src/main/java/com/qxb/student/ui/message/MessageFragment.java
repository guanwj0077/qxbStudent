package com.qxb.student.ui.message;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.qxb.student.R;
import com.qxb.student.common.basics.ExpandFragment;


public class MessageFragment extends ExpandFragment {
    @Override
    public int bindLayout() {
        return R.layout.fragment_test;
    }

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ((TextView) view.findViewById(R.id.text1)).setText(getClass().getSimpleName());

    }
}
