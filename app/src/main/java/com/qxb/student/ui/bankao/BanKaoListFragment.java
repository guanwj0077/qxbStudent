package com.qxb.student.ui.bankao;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewStub;

import com.qxb.student.R;
import com.qxb.student.common.basics.AbsNoTitleRefreshFragment;
import com.qxb.student.common.module.bean.Bankao;
import com.qxb.student.common.view.recycler.ViewHolder;
import com.qxb.student.common.view.recycler.adapter.QuickAdapter;
import com.qxb.student.control.BanKaoControl;

import java.util.List;

/**
 * 伴考列表-
 *
 * @author winky
 */
public class BanKaoListFragment extends AbsNoTitleRefreshFragment<Bankao> {

    private static final String TYPE = "_type";

    private BanKaoControl banKaoControl;

    public static BanKaoListFragment create(String type) {
        Bundle bundle = new Bundle();
        bundle.putString(TYPE, type);
        BanKaoListFragment fragment = new BanKaoListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    private String type;

    @Override
    public void initContent(@Nullable Bundle savedInstanceState) {
        type = getArguments() != null ? getArguments().getString(TYPE) : null;
        banKaoControl = ViewModelProviders.of(this).get(BanKaoControl.class);
    }

    @Override
    public void reqData(int pageIndex) {
        banKaoControl.getBankaoListByType(type, String.valueOf(pageIndex)).observe(this, new Observer<List<Bankao>>() {
            @Override
            public void onChanged(@Nullable List<Bankao> bankaos) {
                refreshData(bankaos, bankaos.size());
            }
        });
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
