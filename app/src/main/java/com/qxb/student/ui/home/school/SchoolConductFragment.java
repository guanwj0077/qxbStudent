package com.qxb.student.ui.home.school;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qxb.student.R;
import com.qxb.student.common.Config;
import com.qxb.student.common.Constant;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.module.bean.SchoolNews;
import com.qxb.student.common.module.bean.attr.WebAttr;
import com.qxb.student.common.utils.NavigationUtils;
import com.qxb.student.common.view.recycler.ViewHolder;
import com.qxb.student.common.view.recycler.adapter.QuickAdapter;
import com.qxb.student.common.view.recycler.decoration.SimpleDecoration;
import com.qxb.student.common.view.recycler.listener.OnItemClickListener;
import com.qxb.student.control.SchoolControl;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.List;
import java.util.Objects;

/**
 * 招生简章
 *
 * @author winky
 * @date 2018/7/23
 */
public class SchoolConductFragment extends AbsExpandFragment {

    private static final String SCHOOL_ID = "schoolId";

    private SmartRefreshLayout refreshLayout;
    private String schoolId;
    private SchoolControl schoolControl;
    private int pageIndex = 1;
    private QuickAdapter<SchoolNews> adapter;

    public static SchoolConductFragment getInstance(String schoolId) {
        SchoolConductFragment fragment = new SchoolConductFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SCHOOL_ID, schoolId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_school_conduct;
    }

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        schoolId = getArguments() != null ? getArguments().getString(SCHOOL_ID) : null;
        refreshLayout = findViewById(R.id.refreshLayout);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        schoolControl = ViewModelProviders.of(getActivity()).get(SchoolControl.class);
        schoolControl.getSchoolNews(schoolId, pageIndex).observe(this, new Observer<List<SchoolNews>>() {
            @Override
            public void onChanged(@Nullable List<SchoolNews> schoolNews) {
                if (schoolNews != null) {
                    adapter.addAll(schoolNews);
                    if (schoolNews.size() < Config.PAGE_SIZE) {
                        refreshLayout.setEnableLoadMore(false);
                    } else {
                        refreshLayout.finishLoadMore();
                    }
                } else {
                    refreshLayout.setEnableLoadMore(false);
                }
            }
        });
        this.refreshLayout.setDisableContentWhenLoading(false);
        this.refreshLayout.setEnableOverScrollDrag(false);
        this.refreshLayout.setEnableRefresh(false);
        this.refreshLayout.setEnableFooterFollowWhenLoadFinished(false);
        this.refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshlayout) {
                pageIndex++;
                schoolControl.getSchoolNews(schoolId, pageIndex);
            }
        });
        adapter = new QuickAdapter<SchoolNews>(R.layout.item_text_arrow_right) {
            @Override
            protected void convert(ViewHolder holder, int position, SchoolNews item) {
                holder.setText(R.id.text1, item.getTitle());
            }
        };
        adapter.setItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View view, int position) {
                WebAttr webAttr = new WebAttr.Builder()
                        .title(getString(R.string.school_conduct))
                        .url(Constant.SCHOOL_NEW_DETAIL + adapter.getItem(position).getId())
                        .auth(Config.AUTH_COMMON_SECRET)
                        .build();
                NavigationUtils.getInstance().toWeb(Objects.requireNonNull(getContext()), webAttr);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SimpleDecoration(getContext(), R.drawable.list_divider_35));
    }
}
