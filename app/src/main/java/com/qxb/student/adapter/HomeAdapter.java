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

import com.qxb.student.R;
import com.qxb.student.common.Constant;
import com.qxb.student.common.adapter.BannerAdapter;
import com.qxb.student.common.databinding.ViewImageBinding;
import com.qxb.student.common.listener.MultiClickUtil;
import com.qxb.student.common.module.bean.School;
import com.qxb.student.common.module.bean.SysAd;
import com.qxb.student.common.module.bean.attr.NavAttr;
import com.qxb.student.common.utils.NavigationUtils;
import com.qxb.student.common.view.abslist.AbsListAdapter;
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
    private static final Object OBJECT = new Object();
    private HomeControl homeControl;
    private Fragment fragment;

    public HomeAdapter(Fragment fragment) {
        this.fragment = fragment;
        homeControl = ViewModelProviders.of(fragment).get(HomeControl.class);
        addItemType(BANNER, R.layout.view_banner);
        addItemType(FUNCTION, R.layout.item_home_function);
        addItemType(HEAD_LINE, R.layout.item_home_headline);
        addItemType(LIVE, R.layout.item_home_live);
        addItemType(SCHOOL, R.layout.item_home_school_list);
    }

    @Override
    protected void convert(ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case BANNER:
                final ViewFlow viewFlow = holder.getView(R.id.viewFlow);
                final CircleFlowIndicator flowIndicator = holder.getView(R.id.flowIndicator);
                viewFlow.setNestedpParent((ViewGroup) viewFlow.getParent());
                viewFlow.setFlowIndicator(flowIndicator);
                viewFlow.setTimeSpan(4500);
                homeControl.getHomeBanner().observe(fragment, new Observer<List<SysAd>>() {
                    @Override
                    public void onChanged(@Nullable List<SysAd> sysAds) {
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
                break;
            case FUNCTION:

                break;
            case HEAD_LINE:

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
                homeControl.getSchoolLiveData().observe(fragment, new Observer<List<School>>() {
                    @Override
                    public void onChanged(@Nullable List<School> schools) {
                        AbsListAdapter adapter = (AbsListAdapter) gridView.getAdapter();
                        if (adapter == null) {
                            gridView.setAdapter(adapter = getSchoolAdapter());
                        }
                        adapter.clear();
                        adapter.addCollection(schools);
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

    private volatile AbsListAdapter<ItemSchoolBinding, School> schoolAdapter;

    private AbsListAdapter<ItemSchoolBinding, School> getSchoolAdapter() {
        if (schoolAdapter != null) {
            return schoolAdapter;
        }
        synchronized (OBJECT) {
            if (schoolAdapter == null) {
                schoolAdapter = new AbsListAdapter<ItemSchoolBinding, School>(fragment.getContext(), R.layout.item_school) {
                    @Override
                    protected void bind(ItemSchoolBinding binding, int position, School item) {
                        binding.setSchool(item);
                    }
                };
            }
            return schoolAdapter;
        }
    }
}
