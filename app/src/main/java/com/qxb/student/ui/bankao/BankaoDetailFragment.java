package com.qxb.student.ui.bankao;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.qxb.student.R;
import com.qxb.student.common.Constant;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseNews;
import com.qxb.student.common.module.bean.BaseNewsComment;
import com.qxb.student.common.utils.GlideUtils;
import com.qxb.student.common.utils.TimeUtils;
import com.qxb.student.common.view.abslist.adapter.AbsAdapter;
import com.qxb.student.common.view.web.WebView;
import com.qxb.student.control.BanKaoControl;
import com.qxb.student.databinding.FragmentBankaoDetailBinding;

import java.util.List;

/**
 * 伴考详情
 *
 * @author winky
 * @date 2018/7/30
 */
public class BankaoDetailFragment extends AbsExpandFragment {

    private static final String ID = "_id";

    public static Bundle build(int id) {
        Bundle bundle = new Bundle();
        bundle.putString(ID, String.valueOf(id));
        return bundle;
    }

    private String bankaoId;
    private BanKaoControl banKaoControl;
    private FragmentBankaoDetailBinding binding;

    private AbsAdapter<BaseNewsComment> adapter;

    @Override
    public int bindLayout() {
        return R.layout.fragment_bankao_detail;
    }

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.bind(view);
        banKaoControl = ViewModelProviders.of(this).get(BanKaoControl.class);
        bankaoId = getStringExtra(ID);
        adapter = new AbsAdapter<BaseNewsComment>(getContext(), R.layout.item_bankao_comment) {
            @Override
            protected void bindView(View view, int position, BaseNewsComment item) {
                GlideUtils.getInstance().LoadContextCircleBitmap(getContext(), item.getPhoto_url(), (ImageView) view.findViewById(R.id.image1));
                setText(view, R.id.text1, item.getStu_name());
                setText(view, R.id.text2, TimeUtils.intervalStr(item.getCreate_time()));
                setText(view, R.id.text3, item.getContent());
                setText(view, R.id.text4, String.valueOf(item.getPraise()));
                ((ImageView) view.findViewById(R.id.image2)).setImageResource(item.getIspraise() == 1 ? R.mipmap.zan1x : R.mipmap.zan2x);
            }
        };
        ListView listView = view.findViewById(R.id.listView);
        listView.setAdapter(adapter);
        banKaoControl.getBankaoDetail(bankaoId).observe(this, new Observer<BaseNews>() {
            @Override
            public void onChanged(@Nullable BaseNews baseNews) {
                if (baseNews != null) {
                    binding.setBanKao(baseNews);
                    binding.collect.setImageResource(baseNews.getIs_collectioned() == 1 ? R.drawable.collect : R.drawable.un_collect);
                }
            }
        });
        banKaoControl.getBaseNewsCommentList(bankaoId).observe(this, new Observer<ApiModel<List<BaseNewsComment>>>() {
            @Override
            public void onChanged(@Nullable ApiModel<List<BaseNewsComment>> apiModel) {
                binding.commentCount.setText(String.format(getString(R.string.bankao_comment_count), apiModel == null ? 0 : apiModel.getTotal()));
                if (apiModel != null) {
                    adapter.addCollection(apiModel.getData());
                }
            }
        });
        binding.webView.loadUrl(Constant.BANKAO_NEW_DETAIL + bankaoId);
        binding.webView.setWebClientListener(new WebView.OnWebClientListener() {
            @Override
            public void onPageFinished(android.webkit.WebView view, String url) {
                
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
