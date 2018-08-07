package com.qxb.student.ui.bankao;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.qxb.student.R;
import com.qxb.student.common.Constant;
import com.qxb.student.common.basics.AbsToolbarFragment;
import com.qxb.student.common.listener.MultiClickUtil;
import com.qxb.student.common.listener.OnPositionClickListener;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseNews;
import com.qxb.student.common.module.bean.BaseNewsComment;
import com.qxb.student.common.module.bean.SchoolDetail;
import com.qxb.student.common.utils.GlideUtils;
import com.qxb.student.common.utils.TimeUtils;
import com.qxb.student.common.utils.dialog.ToastUtils;
import com.qxb.student.common.view.abslist.adapter.AbsAdapter;
import com.qxb.student.common.view.web.WebView;
import com.qxb.student.control.BanKaoControl;
import com.qxb.student.databinding.FragmentBankaoDetailBinding;
import com.qxb.student.helper.HintHelper;

import java.util.List;

/**
 * 伴考详情
 *
 * @author winky
 * @date 2018/7/30
 */
public class BankaoDetailFragment extends AbsToolbarFragment {

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
    public int bindContentView() {
        return R.layout.fragment_bankao_detail;
    }

    @Override
    public void initContent(View contentView, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.bind(contentView);
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
                setOnClickListener(view, new OnPositionClickListener(position) {
                    @Override
                    public void onPositionClick(View view, int position) {
                        dianzan(position);
                    }
                });
            }
        };
        ListView listView = contentView.findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setEmptyView(findViewById(R.id.empty_text1));
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
                binding.setCommentNum(apiModel != null ? apiModel.getTotal() : 0);
                adapter.addCollection(apiModel.getData());
                adapter.notifyDataSetChanged();
            }
        });
        binding.webView.loadUrl(Constant.BANKAO_NEW_DETAIL + bankaoId);
        binding.webView.setWebClientListener(new WebView.OnWebClientListener() {
            @Override
            public void onPageFinished(android.webkit.WebView view, String url) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                view.setLayoutParams(layoutParams);
            }
        });
        banKaoControl.connectSchool(bankaoId).observe(this, new Observer<SchoolDetail>() {
            @Override
            public void onChanged(@Nullable SchoolDetail schoolDetail) {
                if (schoolDetail != null) {
                    binding.includeSchool.setSchool(schoolDetail);
                }
            }
        });
        binding.edit1.setOnClickListener(clickListener);
        binding.collect.setOnClickListener(clickListener);
        binding.send.setOnClickListener(clickListener);
    }

    private void dianzan(int position) {
        final BaseNewsComment item = adapter.getItem(position);
        if (item.getIspraise() == 0) {
            banKaoControl.commentPraise(String.valueOf(item.getBase_news_id()), String.valueOf(item.getId()))
                    .observe(this, new Observer<Boolean>() {
                        @Override
                        public void onChanged(@Nullable Boolean aBoolean) {
                            if (aBoolean) {
                                item.setIspraise(1);
                                adapter.notifyDataSetChanged();
                            }
                        }
                    });
        } else {
            banKaoControl.cancelCommentPraise(String.valueOf(item.getBase_news_id()), String.valueOf(item.getId()))
                    .observe(this, new Observer<Boolean>() {
                        @Override
                        public void onChanged(@Nullable Boolean aBoolean) {
                            if (aBoolean) {
                                item.setIspraise(0);
                                adapter.notifyDataSetChanged();
                            }
                        }
                    });
        }
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(!MultiClickUtil.isFastClick()){
                return;
            }
            if (!HintHelper.hasLogin(getContext())) {
                return;
            }
            switch (view.getId()) {
                case R.id.edit1:
                    binding.edit1.requestFocus();
                    break;
                case R.id.collect:
                    if (HintHelper.hasNetwork()) {
                        banKaoControl.collection(getFragment(), bankaoId);
                    }
                    break;
                case R.id.send:
                    if (HintHelper.hasNetwork()) {
                        banKaoControl.submitNewsReview(bankaoId, binding.edit1.getText().toString()).observe(getFragment(), new Observer<Boolean>() {
                            @Override
                            public void onChanged(@Nullable Boolean aBoolean) {
                                if (aBoolean) {
                                    ToastUtils.toast(R.string.hint_comment_success);
                                    binding.edit1.setText("");
                                }
                            }
                        });
                    }
                    break;
            }
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (binding != null) {
            binding.unbind();
        }
    }
}
