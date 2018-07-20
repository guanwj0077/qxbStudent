package com.qxb.student.ui.mine;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qxb.student.R;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.listener.MultiClickUtil;
import com.qxb.student.common.listener.OnPositionClickListener;
import com.qxb.student.common.module.MineTv;
import com.qxb.student.common.module.bean.MineData;
import com.qxb.student.common.module.bean.attr.NavAttr;
import com.qxb.student.common.utils.NavigationUtils;
import com.qxb.student.common.view.recycler.ExtendRecyclerView;
import com.qxb.student.common.view.recycler.adapter.QuickAdapter;
import com.qxb.student.common.view.recycler.adapter.QuickBindingAdapter;
import com.qxb.student.databinding.HeadviewMineBinding;
import com.qxb.student.databinding.LayoutMineItemViewBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjk9527
 */
public class MineFragment extends AbsExpandFragment implements View.OnClickListener {
    private AppBarLayout appbar;
    private RelativeLayout re;
    private ExtendRecyclerView recyclerView;
    private TextView tv;
    private QuickAdapter<MineData> mAdapter = null;
    private QuickBindingAdapter<LayoutMineItemViewBinding, MineData> adapter = null;
    private HeadviewMineBinding headviewMineBinding;

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
        findViewById(R.id.img).setOnClickListener(this);
        findViewById(R.id.username).setOnClickListener(this);
        findViewById(R.id.rl_myjf).setOnClickListener(this);
        headviewMineBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.headview_mine, null, false);
        headviewMineBinding.myFraction.setOnClickListener(this);
        headviewMineBinding.mineQiuxuedanan.setOnClickListener(this);

        recyclerView.addHeaderView(headviewMineBinding.getRoot());
        recyclerView.setAdapter(adapter = new QuickBindingAdapter<LayoutMineItemViewBinding, MineData>(R.layout.layout_mine_item_view, getList()) {
            @Override
            public void convert(@NonNull LayoutMineItemViewBinding binding, int position) {
                binding.setMineData(getItem(position));
                binding.llView.setOnClickListener(new OnPositionClickListener(position) {
                    @Override
                    public void onPositionClick(View view, int position) {
                        switch (adapter.getItem(position).getName()) {
                            case R.string.yqm:
                                //邀请码
                                break;
                            case R.string.yhm:
                                //优惠码
                                break;
                            case R.string.wdsc:
                                //我的收藏
                                break;
                            case R.string.bmddx:
                                //报名的大学
                                break;
                            case R.string.wddd:
                                //我的订单
                                break;
                            case R.string.wdzyb:
                                //我的志愿表
                                break;
                            case R.string.wdzxk:
                                //我的助学卡
                                break;
                            case R.string.rjgx:
                                //软件更新
                                break;
                            case R.string.ywtzkf:
                                //有问题找客服
                                break;
                            case R.string.sybz:
                                //使用帮助
                                break;
                            case R.string.bzyfk:
                                //帮助与反馈
                                break;
                            case R.string.gywm:
                                //关于我们
                                break;
                            case R.string.yqhylkmd:
                                Toast.makeText(getActivity(), "邀请好友，立刻免单", Toast.LENGTH_LONG).show();
                                //邀请好友，立刻免单
                                break;
                            default:
                                break;
                        }


                    }
                });
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        headviewMineBinding.unbind();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_fraction:
                //我的成绩
                if (MultiClickUtil.isFastClick()) {
                    NavigationUtils.getInstance().toNavigation(getContext(), new NavAttr.Builder().graphRes(R.navigation.nav_login).build());
                }
                break;
            case R.id.mine_qiuxuedanan:
                //我的求学档案
                break;
            case R.id.img:
                //头像
                if (MultiClickUtil.isFastClick()) {
                    NavigationUtils.getInstance().toNavigation(getContext(), new NavAttr.Builder().graphRes(R.navigation.nav_login).build());
                }
                break;
            case R.id.username:
                //用户名
                break;
            case R.id.rl_myjf:
                //积分
                break;
            default:
                break;
        }



    }
}
