package com.qxb.student.ui.bankao;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.qxb.student.R;
import com.qxb.student.common.basics.ExpandFragment;
import com.qxb.student.databinding.FragmentBankaoNewsBinding;

public class BanKaoNewsFragment extends ExpandFragment {
    @Override
    public int bindLayout() {
        return R.layout.fragment_bankao_news;
    }

    private FragmentBankaoNewsBinding binding;

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
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
