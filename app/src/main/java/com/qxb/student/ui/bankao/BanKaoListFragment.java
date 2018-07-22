package com.qxb.student.ui.bankao;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewStub;

import com.qxb.student.R;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.basics.AbsRefreshFragment;
import com.qxb.student.common.module.bean.Bankao;
import com.qxb.student.common.view.recycler.ViewHolder;
import com.qxb.student.common.view.recycler.adapter.QuickAdapter;
import com.qxb.student.control.BanKaoControl;

/**
 * 伴考列表-
 * @author winky
 */
public class BanKaoListFragment extends AbsExpandFragment {

    private BanKaoControl banKaoControl;

    @Override
    public int bindLayout() {
        return R.layout.view_recycler;
    }

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        banKaoControl = ViewModelProviders.of(this).get(BanKaoControl.class);
    }

    public QuickAdapter<Bankao> initAdapter() {
        return new QuickAdapter<Bankao>(R.layout.item_bankao_news) {
            @Override
            protected void convert(ViewHolder holder, int position, Bankao item) {

            }
        };
    }
}
