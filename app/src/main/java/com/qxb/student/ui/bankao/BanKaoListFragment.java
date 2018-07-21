package com.qxb.student.ui.bankao;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewStub;

import com.qxb.student.R;
import com.qxb.student.common.basics.AbsRefreshFragment;
import com.qxb.student.common.module.bean.Bankao;
import com.qxb.student.common.view.recycler.ViewHolder;
import com.qxb.student.common.view.recycler.adapter.QuickAdapter;
import com.qxb.student.control.BanKaoControl;

public class BanKaoListFragment extends AbsRefreshFragment<Bankao> {

    private BanKaoControl banKaoControl;

    @Override
    public void initContent(@Nullable Bundle savedInstanceState) {
        banKaoControl = ViewModelProviders.of(this).get(BanKaoControl.class);
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
