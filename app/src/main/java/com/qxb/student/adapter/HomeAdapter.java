package com.qxb.student.adapter;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.qxb.student.R;
import com.qxb.student.common.databinding.ViewImageBinding;
import com.qxb.student.common.module.bean.School;
import com.qxb.student.common.view.abslist.AbsListAdapter;
import com.qxb.student.common.view.recycler.ViewHolder;
import com.qxb.student.common.view.recycler.adapter.NestingAdapter;
import com.qxb.student.control.HomeControl;
import com.qxb.student.databinding.ItemSchoolBinding;

import java.util.List;

public class HomeAdapter extends NestingAdapter {

    private static final int BANNER = 0;
    private static final int FUNCTION = 1;
    private static final int HEAD_LINE = 2;
    private static final int LIVE = 3;
    private static final int SCHOOL = 4;

    private HomeControl homeControl;
    private Fragment fragment;

    public HomeAdapter(Fragment fragment) {
        this.fragment = fragment;
        homeControl = ViewModelProviders.of(fragment).get(HomeControl.class);
        addItemType(BANNER, R.layout.view_banner);
        addItemType(FUNCTION, R.layout.item_home_function);
        addItemType(HEAD_LINE, R.layout.item_home_headline);
        addItemType(LIVE, R.layout.view_image);
        addItemType(SCHOOL, R.layout.item_home_school_list);

    }

    @Override
    protected void convert(ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case BANNER:
//                final ViewFlow viewFlow = holder.getView(R.id.viewFlow);
//                final CircleFlowIndicator flowIndicator = holder.getView(R.id.flowIndicator);
//                viewFlow.setNestedpParent((ViewGroup) viewFlow.getParent());
//                viewFlow.setFlowIndicator(flowIndicator);
//                viewFlow.setTimeSpan(4500);
//                homeControl.getSchoolLiveData().observe(fragment, new Observer<List<School>>() {
//                    @Override
//                    public void onChanged(@Nullable List<School> schools) {
//                        viewFlow.setAdapter(new BannerAdapter<Banner>(fragment.getContext(), true) {
//                            @Override
//                            protected void bind(ViewImageBinding binding, int position, Banner item) {
//                                binding.setImageUrl(item.getImgUrlRealPath());
//                            }
//                        });
////                        viewFlow.setmSideBuffer(bannerList.size()); // 实际图片张数，
////                        flowIndicator.setCount(size);
////                        viewFlow.setSelection(size * 1000); // 设置初始位置
////                        viewFlow.startAutoFlowTimer(); // 启动自动播放
//                    }
//                });
                break;
            case FUNCTION:

                break;
            case HEAD_LINE:

                break;
            case LIVE:
                final ViewImageBinding binding = DataBindingUtil.bind(holder.itemView);
                homeControl.getLiveAdvert().observe(fragment, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        binding.setImageUrl(s);
                    }
                });
                break;
            case SCHOOL:
                holder.setImageResource(R.id.tag_image, R.mipmap.yuan_xiao_hot);
                holder.setText(R.id.tag_text, R.string.hint_tag_recommended_colleges);
                final AbsListAdapter adapter = new AbsListAdapter<ItemSchoolBinding, School>(fragment.getContext(), R.layout.item_school) {
                    @Override
                    protected void bind(ItemSchoolBinding binding, int position, School item) {
                        binding.setSchool(item);
                    }
                };
                holder.setAdapter(R.id.gridView, adapter);
                homeControl.getSchoolLiveData().observe(fragment, new Observer<List<School>>() {
                    @Override
                    public void onChanged(@Nullable List<School> schools) {
                        adapter.clear();
                        adapter.addCollection(schools);
                    }
                });
                break;
        }
    }
}
