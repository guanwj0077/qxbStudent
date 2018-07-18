package com.qxb.student.ui.mine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.qxb.student.R;
import com.qxb.student.common.basics.ExpandFragment;
import com.qxb.student.common.module.bean.attr.WebAttr;
import com.qxb.student.common.utils.MobUtils;
import com.qxb.student.common.utils.NavigationUtils;

public class MineFragment extends ExpandFragment {
    @Override
    public int bindLayout() {
        return R.layout.fragment_test;
    }

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ((TextView) view.findViewById(R.id.text1)).setText(getClass().getSimpleName());
        findViewById(R.id.text1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavigationUtils.getInstance().jump(getFragment(), R.id.fragment_login);
//                NavigationUtils.getInstance().toNavigation(getActivity(), R.navigation.nav_login);
                NavigationUtils.getInstance().toWeb(getActivity(),
                        new WebAttr.Builder()
                                .title("测试视频")
                                .url("http://www.qiuxuebao.com/web/sysnews/6011/detail")
                                .build());

//                MobUtils.getInstance().grantAuth();
            }
        });
    }
}
