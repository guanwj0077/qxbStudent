package com.qxb.student.ui.mine;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qxb.student.R;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.module.MineTv;
import com.qxb.student.common.module.bean.MineData;
import com.qxb.student.common.view.recycler.ExtendRecyclerView;
import com.qxb.student.common.view.recycler.adapter.QuickAdapter;
import com.qxb.student.common.view.recycler.adapter.QuickBindingAdapter;
import com.qxb.student.databinding.HeadviewMineBinding;
import com.qxb.student.databinding.LayoutMineItemViewBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class MineFragment extends AbsExpandFragment {
    private AppBarLayout appbar;
    private RelativeLayout re;
    private ExtendRecyclerView recyclerView;
    private TextView tv;
    private QuickAdapter<MineData> mAdapter = null;
    private QuickBindingAdapter<LayoutMineItemViewBinding, MineData> adapter = null;

    @Override
    public int bindLayout() {
        return R.layout.fragment_test;
    }

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        appbar = findViewById(R.id.appbar);
        re = findViewById(R.id.re);
        recyclerView = findViewById(R.id.recyclerView);
        tv = findViewById(R.id.tv);
        tv.setText(getResources().getString(R.string.mine));

        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                re.setVisibility(i > -300 ? View.GONE : View.VISIBLE);
            }
        });

        HeadviewMineBinding headviewMineBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.headview_mine, null, false);
        recyclerView.addHeaderView(headviewMineBinding.getRoot());
        recyclerView.setAdapter(adapter = new QuickBindingAdapter<LayoutMineItemViewBinding, MineData>(R.layout.layout_mine_item_view, getList()) {
            @Override
            public void convert(@NonNull LayoutMineItemViewBinding binding, int position) {
                binding.setMineData(getItem(position));
            }
        });
    }

    private List<MineData> getList() {
        List<MineData> mList = new ArrayList<>();
        for (MineTv mineTv : MineTv.values()) {
            if (mineTv.isShow()) {
                MineData modle = new MineData();
                modle.setDraw_id(mineTv.getDraw_id());
                modle.setName(mineTv.getName());
                modle.setView(mineTv.isView());
                modle.setShow(mineTv.isShow());
                mList.add(modle);
            }
        }
        return mList;
    }
}
