package com.qxb.student.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.qxb.student.R;
import com.qxb.student.common.listener.MultiClickUtil;
import com.qxb.student.common.module.bean.FunctionItem;
import com.qxb.student.common.view.abslist.GridView;
import com.qxb.student.common.view.abslist.adapter.AbsListAdapter;
import com.qxb.student.databinding.ItemFunctionItemBinding;
import com.qxb.student.helper.FunctionHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winky on 2017/10/26.
 */
@SuppressLint("InflateParams")
public class FunctionViewPagerAdapter extends PagerAdapter {

    private static final int PAGE_SIZE = 10;//grid分页显示数量
    private List<GridView> gridViews = new ArrayList<>(2);
    private Context context;
    private List<FunctionItem> functionItems = null;
    private View[] indicators;

    private LayoutInflater inflater;
    private ViewPager viewPager;
    private LinearLayout indicatorLayout;

    FunctionViewPagerAdapter(Context context, View view) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.viewPager = view.findViewById(R.id.viewPager);
        this.indicatorLayout = view.findViewById(R.id.functionIndicator);
    }

    @Override
    public int getCount() {
        return gridViews.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View arg0, @NonNull Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    private AbsListAdapter<ItemFunctionItemBinding, FunctionItem> initAdapter() {
        return new AbsListAdapter<ItemFunctionItemBinding, FunctionItem>(context, R.layout.item_function_item) {
            @Override
            protected void bind(ItemFunctionItemBinding binding, int position, FunctionItem item) {
                binding.setFunction(item);
                binding.isVip.setVisibility("1".equals(item.getNeed_pay()) ? View.VISIBLE : View.GONE);
            }
        };
    }

    private List<FunctionItem> getData(int position) {
        if (functionItems.size() == 0) {
            return null;
        }
        int start = position * PAGE_SIZE;
        int end = functionItems.size() < ((position + 1) * PAGE_SIZE) ? functionItems.size() : (position + 1) * PAGE_SIZE;
        return functionItems.subList(start, end);
    }

    /**
     * 初始化viewpager
     */
    public void setData(List<FunctionItem> list) {
        this.functionItems = list == null ? new ArrayList<FunctionItem>() : new ArrayList<>(list);
        int total = (int) Math.ceil(functionItems.size() * 1.0 / PAGE_SIZE);
        gridViews.clear();
        for (int i = 0; i < total; i++) {
            GridView gridView = inflater.inflate(R.layout.view_grid, null).findViewById(R.id.gridView);
            gridView.setNumColumns(5);
            gridViews.add(gridView);
        }
        // 设置指示器
        indicators = new View[gridViews.size()];
        indicatorLayout.removeAllViews();
        for (int i = 0; i < indicators.length; i++) {
            View view = inflater.inflate(R.layout.indicator_home_function, null);
            indicators[i] = view.findViewById(R.id.image_indicator);
            indicatorLayout.addView(view);
        }
        // 默认指向第一项，下方viewPager.setCurrentItem将触发重新计算指示器指向
        setIndicator(0);
        viewPager.setOffscreenPageLimit(3);
        viewPager.addOnPageChangeListener(onPageChangeListener);
        viewPager.setAdapter(this);
        viewPager.setCurrentItem(0);
    }

    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    /**
     * 设置指示器
     *
     * @param selectedPosition 默认指示器位置
     */
    private void setIndicator(int selectedPosition) {
        for (View indicator : indicators) {
            indicator.setSelected(false);
        }
        if (indicators.length > selectedPosition)
            indicators[selectedPosition].setSelected(true);
    }

    @NonNull
    @Override
    public View instantiateItem(@NonNull ViewGroup container, int position) {
        final AbsListAdapter<ItemFunctionItemBinding, FunctionItem> adapter = initAdapter();
        GridView gridView = gridViews.get(position);
        gridView.setAdapter(adapter);
        adapter.clear();
        adapter.addCollection(getData(position));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (MultiClickUtil.isFastClick()) {
                    FunctionHelper.jump(context, adapter.getItem(position));
                }
            }
        });
        container.addView(gridView);
        return gridView;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
