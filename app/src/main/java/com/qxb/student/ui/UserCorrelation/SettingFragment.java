package com.qxb.student.ui.UserCorrelation;


import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.qxb.student.R;
import com.qxb.student.common.basics.AbsToolbarFragment;
import com.qxb.student.common.listener.MultiClickUtil;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.utils.UserCache;
import com.qxb.student.common.view.dialog.ToastUtils;
import com.qxb.student.databinding.FragmentSettingBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends AbsToolbarFragment {
    private FragmentSettingBinding binding;
    private TextView tvPhone;

    @Override
    public int bindContentView() {
        return R.layout.fragment_setting;
    }

    @Override
    public void initContent(View contentView, @Nullable Bundle savedInstanceState) {
        setTitle(getString(R.string.personal_details));
        binding = DataBindingUtil.bind(contentView);
        UserCache.getInstance().getUserLiveData().observe(SettingFragment.this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    user.setName(!TextUtils.isEmpty(user.getName()) ? user.getName() : getString(R.string.weitian));
                    user.setNick_name(!TextUtils.isEmpty(user.getNick_name()) ? user.getNick_name() : getString(R.string.weitian));
                    user.setSex(!TextUtils.isEmpty(user.getSex()) ? user.getSex() : getString(R.string.weitian));
                    user.setSubject(!TextUtils.isEmpty(user.getSubject()) ? user.getSubject() : getString(R.string.weitian));
                    String tempname = (TextUtils.isEmpty(user.getProvince_name()) ? "" : user.getProvince_name()) + " " +
                            (TextUtils.isEmpty(user.getCity_name()) ? "" : user.getCity_name()) + " " +
                            (TextUtils.isEmpty(user.getArea_name()) ? "" : user.getArea_name()) + "\n" +
                            (TextUtils.isEmpty(user.getHighschool_name()) ? "" : user.getHighschool_name());
                    binding.txtRightDq.setText(!TextUtils.isEmpty(user.getHighschool_name()) ? tempname : getString(R.string.weitian));
                    binding.setUser(user);
                    binding.txtRightGknf.setText(user.getYears() == 0 || user.getYears() == 999 ? getString(R.string.weitian) : user.getYears() + "年");


                }
            }
        });
        binding.lyExit.setOnClickListener(mOnClickListener);
        binding.avatorContainer.setOnClickListener(mOnClickListener);
        binding.llNickname.setOnClickListener(mOnClickListener);
        binding.lyKm.setOnClickListener(mOnClickListener);

    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!MultiClickUtil.isFastClick()) {
                return;
            }
            switch (view.getId()) {
                case R.id.ly_exit:
                    //退出登录
                    break;
                case R.id.avator_container:
                    //换头像
                    break;
                case R.id.ll_nickname:
                    //昵称
                    break;
                case R.id.ly_km:
                    //考试类型
                    break;
                case R.id.txt_right_dq:
                    //高中
                    break;

                default:
                    break;
            }
        }
    };

    private void initView() {

    }


}
