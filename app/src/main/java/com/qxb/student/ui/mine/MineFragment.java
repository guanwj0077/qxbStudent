package com.qxb.student.ui.mine;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.qxb.student.R;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.listener.MultiClickUtil;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.module.bean.attr.NavAttr;
import com.qxb.student.common.utils.NavigationUtils;
import com.qxb.student.common.utils.UserCache;
import com.qxb.student.common.view.Toolbar;
import com.qxb.student.common.view.recycler.ExtendRecyclerView;
import com.qxb.student.common.view.recycler.ViewHolder;
import com.qxb.student.common.view.recycler.adapter.QuickAdapter;
import com.qxb.student.common.view.recycler.listener.OnItemClickListener;
import com.qxb.student.control.LoginControl;
import com.qxb.student.databinding.HeaderMineBinding;
import com.qxb.student.type.MineItem;

import java.util.Arrays;

/**
 * @author zjk9527
 */
public class MineFragment extends AbsExpandFragment {

    private QuickAdapter<MineItem> adapter;
    private HeaderMineBinding headerMineBinding;
    private Toolbar toolbar;
    private LoginControl mLoginControl;
    private User mUser;
    @Override
    public int bindLayout() {
        return R.layout.fragment_test;
    }

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundResource(android.R.color.transparent);
        toolbar.setTitle(getString(R.string.main_mine));
        ExtendRecyclerView recyclerView = findViewById(R.id.recyclerView);
        headerMineBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.header_mine, null, false);
        findViewById(R.id.img).setOnClickListener(clickListener);
        findViewById(R.id.username).setOnClickListener(clickListener);
        findViewById(R.id.rl_myjf).setOnClickListener(clickListener);
        headerMineBinding.myFraction.setOnClickListener(clickListener);
        headerMineBinding.mineQiuxuedanan.setOnClickListener(clickListener);
        recyclerView.addHeaderView(headerMineBinding.getRoot());
        adapter = new QuickAdapter<MineItem>(R.layout.item_mine, Arrays.asList(MineItem.values())) {
            @Override
            protected void convert(ViewHolder holder, int position, MineItem item) {
                holder.setVisible(R.id.layout1, item.isShow());
                holder.setImageResource(R.id.image1, item.getDrawId());
                holder.setText(R.id.text1, item.getName());
                holder.setVisible(R.id.view1, item.isView());
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.setItemClickListener(itemClickListener);
        mLoginControl= ViewModelProviders.of(getActivity()).get(LoginControl.class);
        if ( mLoginControl.getUserLiveData()!=null){
        mLoginControl.getUserLiveData().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                showUserData();
            }
        });}
    }



    private void showUserData() {
    }

    private OnItemClickListener itemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(RecyclerView parent, View view, int position) {
            if (!MultiClickUtil.isFastClick()) {
                return;
            }
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
    };

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!MultiClickUtil.isFastClick()) {
                return;
            }
            switch (view.getId()) {
                case R.id.my_fraction:
                    //我的成绩
                    NavigationUtils.getInstance().toNavigation(getContext(), new NavAttr.Builder().graphRes(R.navigation.nav_login).build());
                    break;
                case R.id.mine_qiuxuedanan:
                    //我的求学档案
                    break;
                case R.id.img:
                    //头像
                    NavigationUtils.getInstance().toNavigation(getContext(), new NavAttr.Builder().graphRes(R.navigation.nav_login).build());
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
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        headerMineBinding.unbind();
        toolbar = null;
        adapter = null;
    }

}
