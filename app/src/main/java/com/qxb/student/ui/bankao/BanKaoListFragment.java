package com.qxb.student.ui.bankao;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;

import com.qxb.student.R;
import com.qxb.student.common.basics.AbsNoTitleRefreshFragment;
import com.qxb.student.common.listener.OnPositionClickListener;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.Bankao;
import com.qxb.student.common.module.bean.attr.NavAttr;
import com.qxb.student.common.utils.GlideUtils;
import com.qxb.student.common.utils.NavigationUtils;
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

        banKaoControl.getBankaoLiveData().observe(this, new Observer<ApiModel<List<Bankao>>>() {
            @Override
            public void onChanged(@Nullable ApiModel<List<Bankao>> apiModel) {
                if (apiModel != null) {
                    refreshData(apiModel.getData(), apiModel.getTotal());
                }
            }
        });
        autoRefresh();
    }

    @Override
    public void reqData(int pageIndex) {
        banKaoControl.getBankaoListByType(type, pageIndex);
    }

    @Override
    public QuickAdapter<Bankao> initAdapter() {
        return new QuickAdapter<Bankao>(R.layout.item_bankao_news) {
            @Override
            protected void convert(ViewHolder holder, int position, Bankao item) {
                GlideUtils.getInstance().LoadSupportv4FragmentRoundBitmap(getFragment(), item.getImg_url(), (ImageView) holder.getView(R.id.image1), 10);
                holder.setText(R.id.text1, item.getTitle());
                holder.setText(R.id.text2, item.getIntro());
                //这里将id设置给监听
                holder.setOnClickListener(new OnPositionClickListener(item.getId()) {
                    @Override
                    public void onPositionClick(View view, int position) {
                        NavigationUtils.getInstance()
                                .toNavigation(getContext(),
                                        new NavAttr.Builder()
                                                .graphRes(R.navigation.nav_bankao)
                                                .navId(R.id.nav_bankao_detail)
                                                .params(BankaoDetailFragment.build(position)).build());
                    }
                });
            }
        };
    }

    @Override
    public ViewStub setEmptyView(ViewStub viewStub) {
        return null;
    }
}
