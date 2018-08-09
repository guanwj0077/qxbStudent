package com.qxb.student.ui.bankao;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;

import com.qxb.student.R;
import com.qxb.student.common.basics.AbsRefreshFragment;
import com.qxb.student.common.listener.OnPositionClickListener;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.BaseNewsComment;
import com.qxb.student.common.utils.GlideUtils;
import com.qxb.student.common.utils.NavigationUtils;
import com.qxb.student.common.utils.TimeUtils;
import com.qxb.student.common.view.recycler.ViewHolder;
import com.qxb.student.common.view.recycler.adapter.QuickAdapter;
import com.qxb.student.control.BanKaoControl;

import java.util.List;

/**
 * 伴考评论列表
 *
 * @author winky
 * @date 2018/8/8
 */
public class BankaoCommentListFragment extends AbsRefreshFragment<BaseNewsComment> {

    private static final String TAG = "BankaoCommentListFragment_id";

    public static Bundle create(String newsID) {
        Bundle bundle = new Bundle();
        bundle.putString(TAG, newsID);
        return bundle;
    }

    private String newsId;
    private BanKaoControl banKaoControl;

    @Override
    public void init(@Nullable Bundle savedInstanceState) {
        newsId = getArguments() != null ? getArguments().getString(TAG) : null;
        banKaoControl = ViewModelProviders.of(this).get(BanKaoControl.class);
        if (TextUtils.isEmpty(newsId)) {
            NavigationUtils.getInstance().goBack(getFragment());
            return;
        }
        banKaoControl.getCommentListLiveData().observe(this, new Observer<ApiModel<List<BaseNewsComment>>>() {
            @Override
            public void onChanged(@Nullable ApiModel<List<BaseNewsComment>> apiModel) {
                if (apiModel != null) {
                    refreshData(apiModel.getData(), apiModel.getTotal());
                }
            }
        });
        autoRefresh();
    }

    @Override
    public void reqData(int pageIndex) {
        banKaoControl.getBaseNewsCommentList(newsId, pageIndex);
    }

    @Override
    public QuickAdapter<BaseNewsComment> initAdapter() {
        return new QuickAdapter<BaseNewsComment>(R.layout.item_bankao_comment) {
            @Override
            protected void convert(ViewHolder holder, int position, BaseNewsComment item) {
                GlideUtils.getInstance().LoadContextCircleBitmap(getContext(), item.getPhoto_url(), (ImageView) holder.getView(R.id.image1));
                holder.setText(R.id.text1, item.getStu_name());
                holder.setText(R.id.text2, TimeUtils.intervalStr(item.getCreate_time()));
                holder.setText(R.id.text3, item.getContent());
                holder.setText(R.id.text4, String.valueOf(item.getPraise()));
                holder.setImageResource(R.id.image2, item.getIspraise() == 1 ? R.mipmap.zan1x : R.mipmap.zan2x);
                holder.setOnClickListener(R.id.image2, new OnPositionClickListener(position) {
                    @Override
                    public void onPositionClick(View view, int position) {
                        final BaseNewsComment item = getItem(position);
                        if (item.getIspraise() == 0) {
                            banKaoControl.commentPraise(String.valueOf(item.getBase_news_id()), String.valueOf(item.getId()))
                                    .observe(getFragment(), new Observer<Boolean>() {
                                        @Override
                                        public void onChanged(@Nullable Boolean aBoolean) {
                                            if (aBoolean) {
                                                item.setIspraise(1);
                                                notifyDataSetChanged();
                                            }
                                        }
                                    });
                        } else {
                            banKaoControl.cancelCommentPraise(String.valueOf(item.getBase_news_id()), String.valueOf(item.getId()))
                                    .observe(getFragment(), new Observer<Boolean>() {
                                        @Override
                                        public void onChanged(@Nullable Boolean aBoolean) {
                                            if (aBoolean) {
                                                item.setIspraise(0);
                                                notifyDataSetChanged();
                                            }
                                        }
                                    });
                        }
                    }
                });
            }
        };
    }

    @Override
    public ViewStub setEmptyView(ViewStub viewStub) {
        return null;
    }
}
