package com.qxb.student.ui.bankao;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewStub;

import com.qxb.student.R;
import com.qxb.student.common.basics.RefreshFragment;
import com.qxb.student.common.bean.Bankao;
import com.qxb.student.common.recycler.ViewHolder;
import com.qxb.student.common.recycler.adapter.QuickAdapter;
import com.qxb.student.control.BankaoControl;

public class BanKaoListFragment extends RefreshFragment<Bankao> {

    private BankaoControl bankaoControl;

    @Override
    public void initContent(@Nullable Bundle savedInstanceState) {
        bankaoControl = ViewModelProviders.of(this).get(BankaoControl.class);

    }

    @Override
    public void reqData(int pageIndex) {

    }

    @Override
    public QuickAdapter<Bankao> initAdapter() {
        return new QuickAdapter<Bankao>(R.layout.item_bankao_news) {
            @Override
            protected void convert(ViewHolder holder, int position, Bankao item) {

            }
        };
    }

    @Override
    public ViewStub setEmptyView(ViewStub viewStub) {
        return null;
    }
}
