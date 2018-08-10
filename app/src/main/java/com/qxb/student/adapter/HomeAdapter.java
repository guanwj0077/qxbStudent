package com.qxb.student.adapter;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.qxb.student.R;
import com.qxb.student.common.Config;
import com.qxb.student.common.Constant;
import com.qxb.student.common.adapter.BannerAdapter;
import com.qxb.student.common.databinding.ViewImageBinding;
import com.qxb.student.common.listener.MultiClickUtil;
import com.qxb.student.common.module.bean.FunctionItem;
import com.qxb.student.common.module.bean.RecomSchool;
import com.qxb.student.common.module.bean.SysAd;
import com.qxb.student.common.module.bean.attr.NavAttr;
import com.qxb.student.common.utils.NavigationUtils;
import com.qxb.student.common.view.abslist.adapter.AbsListAdapter;
import com.qxb.student.common.view.abslist.GridView;
import com.qxb.student.common.view.bannerview.CircleFlowIndicator;
import com.qxb.student.common.view.bannerview.ViewFlow;
import com.qxb.student.common.view.recycler.ViewHolder;
import com.qxb.student.common.view.recycler.adapter.NestingAdapter;
import com.qxb.student.control.HomeControl;
import com.qxb.student.databinding.ItemHomeLiveBinding;
import com.qxb.student.databinding.ItemSchoolBinding;

import java.util.List;

/**
 * 适配器
 *
 * @author winky
 */
public class HomeAdapter extends NestingAdapter {

    private static final int BANNER = 0;
    private static final int FUNCTION = 1;
    private static final int HEAD_LINE = 2;
    private static final int LIVE = 3;
    private static final int SCHOOL = 4;
    private HomeControl homeControl;
    private Fragment fragment;

    private FunctionViewPagerAdapter functionViewPagerAdapter;
    private ViewFlipper viewFlipper;
    private ViewFlow viewFlow;
    private CircleFlowIndicator flowIndicator;

    public HomeAdapter(Fragment fragment) {
        this.fragment = fragment;
        homeControl = ViewModelProviders.of(fragment).get(HomeControl.class);
        addItemType(BANNER, R.layout.view_banner);
        addItemType(FUNCTION, R.layout.item_home_function);
        addItemType(HEAD_LINE, R.layout.item_home_topline);
        addItemType(LIVE, R.layout.item_home_live);
        addItemType(SCHOOL, R.layout.item_home_school_list);

        homeControl.getIndexFunctions().observe(fragment, new Observer<List<FunctionItem>>() {
            @Override
            public void onChanged(@Nullable List<FunctionItem> functionItems) {
                if (functionViewPagerAdapter != null && functionItems != null) {
                    functionViewPagerAdapter.setData(functionItems);
                }
            }
        });
        homeControl.getTopLines().observe(fragment, new Observer<List<SysAd>>() {
            @Override
            public void onChanged(@Nullable List<SysAd> sysAds) {
                if (sysAds != null) {
                    int page = (int) Math.ceil(sysAds.size() / 2.0);
                    for (int i = 0; i < page; i++) {
                        topLineView(byPosition(sysAds, i * 2), byPosition(sysAds, i * 2 + 1));
                    }
                }
            }
        });
        homeControl.getHomeBanner().observe(fragment, new Observer<List<SysAd>>() {
            @Override
            public void onChanged(@Nullable List<SysAd> sysAds) {
                viewFlow.setNestedpParent((ViewGroup) viewFlow.getParent());
                viewFlow.setFlowIndicator(flowIndicator);
                viewFlow.setTimeSpan(4500);
                getBannerAdapter().clear();
                getBannerAdapter().addCollection(sysAds);
                viewFlow.setAdapter(getBannerAdapter());
                int size = sysAds.size();
                viewFlow.setSideBuffer(size);
                flowIndicator.setCount(size);
                viewFlow.setSelection(size * 1000);
                viewFlow.startAutoFlowTimer();
            }
        });
    }

    private SysAd byPosition(List<SysAd> sysAdList, int i) {
        if (i < sysAdList.size()) {
            return sysAdList.get(i);
        }
        return null;
    }

    private void topLineView(SysAd homeAd1, SysAd homeAd2) {
        if (viewFlipper != null) {
            View view = View.inflate(fragment.getContext(), R.layout.item_home_topline_child, null);
            TextView textView1 = view.findViewById(R.id.text1);
            TextView textView2 = view.findViewById(R.id.text2);
            if (homeAd1 != null)
                textView1.setText(homeAd1.getTitle());
            if (homeAd2 != null)
                textView2.setText(homeAd2.getTitle());
            viewFlipper.addView(view);
        }
    }

    @Override
    protected void convert(ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case BANNER:
                viewFlow = holder.getView(R.id.viewFlow);
                flowIndicator = holder.getView(R.id.flowIndicator);
                break;
            case FUNCTION:
                functionViewPagerAdapter = new FunctionViewPagerAdapter(fragment.getContext(), holder.getConvertView());
                break;
            case HEAD_LINE:
                viewFlipper = holder.getView(R.id.marqueeFlipper);
                break;
            case LIVE:
                final ItemHomeLiveBinding binding = DataBindingUtil.bind(holder.itemView);
                homeControl.getLiveAdvert().observe(fragment, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        if (binding != null) {
                            binding.setImageUrl(s);
                        }
                    }
                });
                break;
            case SCHOOL:
                holder.setImageResource(R.id.tag_image, R.mipmap.yuan_xiao_hot);
                holder.setText(R.id.tag_text, R.string.hint_tag_recommended_colleges);
                final GridView gridView = holder.getView(R.id.gridView);
                homeControl.getSchoolLiveData().observe(fragment, new Observer<List<RecomSchool>>() {
                    @Override
                    public void onChanged(@Nullable List<RecomSchool> recomSchools) {
                        AbsListAdapter adapter = (AbsListAdapter) gridView.getAdapter();
                        if (adapter == null) {
                            gridView.setAdapter(adapter = getSchoolAdapter());
                        }
                        adapter.clear();
                        adapter.addCollection(recomSchools);
                    }
                });
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        if (MultiClickUtil.isFastClick()) {
                            Bundle bundle = new Bundle();
                            bundle.putString(Constant.NAV_SCHOOL_ID, String.valueOf(getSchoolAdapter().getItem(i).getId()));
                            NavigationUtils.getInstance().toNavigation(fragment.getContext(), new NavAttr.Builder()
                                    .graphRes(R.navigation.nav_school)
                                    .navId(R.id.nav_school_index)
                                    .params(bundle)
                                    .build());
                        }
                    }
                });
                break;
            default:
                break;
        }
    }

    private BannerAdapter<SysAd> bannerAdapter;

    private BannerAdapter<SysAd> getBannerAdapter() {
        if (bannerAdapter == null) {
            bannerAdapter = new BannerAdapter<SysAd>(fragment.getContext(), true) {
                @Override
                protected void bind(ViewImageBinding binding, int position, SysAd item) {
                    binding.setImageUrl(item.getImageRealPath());
                }
            };
        }
        return bannerAdapter;
    }

    private volatile AbsListAdapter<ItemSchoolBinding, RecomSchool> schoolAdapter;

    private AbsListAdapter<ItemSchoolBinding, RecomSchool> getSchoolAdapter() {
        if (schoolAdapter != null) {
            return schoolAdapter;
        }
        synchronized (Config.LOCK) {
            if (schoolAdapter == null) {
                schoolAdapter = new AbsListAdapter<ItemSchoolBinding, RecomSchool>(fragment.getContext(), R.layout.item_school) {
                    @Override
                    protected void bind(ItemSchoolBinding binding, int position, RecomSchool item) {
                        binding.setSchool(item);
                    }
                };
            }
            return schoolAdapter;
        }
    }
}
