package com.qxb.student.ui.bankao;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.qxb.student.R;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.view.Toolbar;
import com.qxb.student.databinding.FragmentBanKaoNewsBinding;

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
    private Toolbar toolbar;

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundResource(android.R.color.transparent);
        binding = DataBindingUtil.bind(view);

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
