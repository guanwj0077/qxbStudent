package com.qxb.student.ui.message;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.qxb.student.R;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.view.recycler.HeaderRecyclerView;
import com.qxb.student.common.view.recycler.ViewHolder;
import com.qxb.student.common.view.recycler.adapter.QuickAdapter;
import com.qxb.student.databinding.HeaderMessageBinding;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.Arrays;


/**
 * 消息
 *
 * @author winky
 * @date 2018/07/21
 */
public class MessageFragment extends AbsExpandFragment {

    @Override
    public int bindLayout() {
        return R.layout.fragment_message;
    }

    private Toolbar toolbar;
    private SmartRefreshLayout refreshLayout;
    private HeaderRecyclerView recyclerView;
    private QuickAdapter<String> adapter;

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle(getTitle());
        setSupportActionBar(toolbar);

        refreshLayout = view.findViewById(R.id.refreshLayout);
        recyclerView = view.findViewById(R.id.recyclerView);
        refreshLayout.setEnableOverScrollDrag(true);
        refreshLayout.setEnableLoadMore(false);
        HeaderMessageBinding typeBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.header_message, null, false);
        recyclerView.addHeaderView(typeBinding.getRoot());
        recyclerView.setAdapter(adapter = new QuickAdapter<String>(android.R.layout.activity_list_item) {
            @Override
            protected void convert(ViewHolder holder, int position, String item) {
                holder.setText(android.R.id.text1, item);

            }
        });
        adapter.addAll(Arrays.asList("11111", "2222", "3333", "44444", "55555", "66666", "77777", "8888"));
    }
}
