package com.qxb.student.ui.mine;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qxb.student.R;
import com.qxb.student.common.Constant;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.basics.VideoPlayActivity;
import com.qxb.student.common.listener.MultiClickUtil;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.module.bean.attr.NavAttr;
import com.qxb.student.common.module.bean.attr.VoideAttr;
import com.qxb.student.common.utils.GlideUtils;
import com.qxb.student.common.utils.NavigationUtils;
import com.qxb.student.common.utils.UserCache;
import com.qxb.student.common.view.Toolbar;
import com.qxb.student.common.view.recycler.HeaderRecyclerView;
import com.qxb.student.common.view.recycler.ViewHolder;
import com.qxb.student.common.view.recycler.adapter.QuickAdapter;
import com.qxb.student.common.view.recycler.listener.OnItemClickListener;
import com.qxb.student.control.LectureControl;
import com.qxb.student.databinding.HeaderMineBinding;
import com.qxb.student.type.MineItem;
import com.qxb.student.ui.home.toLecture.ListenToLectureActivity;

import java.util.Arrays;

/**
 * @author zjk9527
 */
public class MineFragment extends AbsExpandFragment {

    private QuickAdapter<MineItem> adapter;
    private HeaderMineBinding headerMineBinding;
    private LectureControl mLectureControl;
    private ImageView img;
    private TextView username;
    private boolean isLogin = false;


    @Override
    public int bindLayout() {
        return R.layout.fragment_test;
    }

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.main_mine));
        toolbar.setAppBarLayout((AppBarLayout) findViewById(R.id.appBarLayout), true);
        setSupportActionBar(toolbar);
        HeaderRecyclerView recyclerView = findViewById(R.id.recyclerView);
        headerMineBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.header_mine, null, false);
        img = findViewById(R.id.img);
        img.setOnClickListener(clickListener);
        username = findViewById(R.id.username);
        username.setOnClickListener(clickListener);
        findViewById(R.id.rl_myjf).setOnClickListener(clickListener);
        headerMineBinding.myFraction.setOnClickListener(clickListener);
        headerMineBinding.mineQiuxuedanan.setOnClickListener(clickListener);
        recyclerView.addHeaderView(headerMineBinding.getRoot());
        showView();
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
        mLectureControl = ViewModelProviders.of(getFragment()).get(LectureControl.class);
    }


    private void showView() {
        UserCache.getInstance().getUserLiveData().observe(MineFragment.this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    isLogin = true;
                    GlideUtils.getInstance().LoadContextCircleBitmap(getContext(), user.getPicRealPath(), img);
                    username.setText(TextUtils.isEmpty(user.getNick_name()) ? user.getTelphone() : user.getNick_name());
                }
                showUserData(user);
            }
        });
    }

    private void showUserData(User user) {

    }

    private OnItemClickListener itemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(RecyclerView parent, View view, int position) {
            if (!MultiClickUtil.isFastClick()) {
                return;
            }
            switch (adapter.getItem(position - 1).getName()) {
                case R.string.yqm:
                    //邀请码

                    break;
                case R.string.yhm:
                    startActivity(new Intent(getActivity(), ListenToLectureActivity.class));
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
                    getVoideUrl();
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

    private void getVoideUrl() {
        mLectureControl.UsingHelp().observe(MineFragment.this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                if (!TextUtils.isEmpty(s)) {
                    NavigationUtils.getInstance().toVideoPlay(getContext(),new VoideAttr.VoideBuilder(s,getString(R.string.usinghelp),null).isShare(true).build());
                }

            }
        });

    }

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
                    if (isLogin) {
                        NavigationUtils.getInstance().toNavigation(getContext(), new NavAttr.Builder().graphRes(R.navigation.nav_user_setting).build());
                    } else {
                        NavigationUtils.getInstance().toNavigation(getContext(), new NavAttr.Builder().graphRes(R.navigation.nav_login).build());
                    }
                    break;
                case R.id.username:
                    //用户名
                    if (isLogin) {

                    } else {

                    }

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
        adapter = null;
    }

}
