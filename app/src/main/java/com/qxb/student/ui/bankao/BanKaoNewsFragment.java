package com.qxb.student.ui.bankao;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.qxb.student.R;
import com.qxb.student.common.adapter.FragmentAdapter;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.basics.BaseFragment;
import com.qxb.student.common.view.Toolbar;
import com.qxb.student.databinding.FragmentBanKaoNewsBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 伴考
 *
 * @author winky
 * @date 2018/07/21
 */
public class BanKaoNewsFragment extends AbsExpandFragment {
    @Override
    public int bindLayout() {
        return R.layout.fragment_ban_kao_news;
    }

    private FragmentBanKaoNewsBinding binding;

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundResource(android.R.color.transparent);
        binding = DataBindingUtil.bind(view);
        String[] types = getResources().getStringArray(R.array.type);
        String[] titles = getResources().getStringArray(R.array.bankao_title);
        List<BaseFragment> fragmentList = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            fragmentList.add(BanKaoListFragment.create(types[i]).setTitle(titles[i]));
        }
        binding.viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(), fragmentList));
        binding.tabLayout.setupWithViewPager(binding.viewPager, false);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (binding != null) {
            binding.unbind();
            binding = null;
        }
    }
}
