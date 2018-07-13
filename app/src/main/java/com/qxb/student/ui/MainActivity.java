package com.qxb.student.ui;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.qxb.student.R;
import com.qxb.student.common.adapter.FragmentAdapter;
import com.qxb.student.common.basics.BaseAppActivity;
import com.qxb.student.ui.bankao.BanKaoNewsFragment;
import com.qxb.student.ui.home.HomeFragment;
import com.qxb.student.ui.message.MessageFragment;
import com.qxb.student.ui.mine.MineFragment;

import java.lang.reflect.Field;
import java.util.Arrays;

public class MainActivity extends BaseAppActivity {

    private ViewPager viewPager;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            try {
                Class decorViewClazz = Class.forName("com.android.internal.policy.DecorView");
                Field field = decorViewClazz.getDeclaredField("mSemiTransparentStatusBarColor");
                field.setAccessible(true);
                field.setInt(getWindow().getDecorView(), Color.TRANSPARENT); //改为透明
            } catch (Exception e) {
            }
        }

        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(checkedChangeListener);
        viewPager.addOnPageChangeListener(pageChangeListener);
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), Arrays.asList(
                new MessageFragment().setTitle(getString(R.string.main_home)),
                new MessageFragment().setTitle(getString(R.string.main_chat)),
                new BanKaoNewsFragment().setTitle(getString(R.string.main_info)),
                new MineFragment().setTitle(getString(R.string.main_mine)))));
        viewPager.setOffscreenPageLimit(3);
        viewPager.setCurrentItem(0);
    }

    private RadioGroup.OnCheckedChangeListener checkedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            int index = radioGroup.indexOfChild(findViewById(i));
            index = index > 2 ? index - 1 : index;
            if (viewPager.getCurrentItem() != index) {
                viewPager.setCurrentItem(index);
            }
        }
    };

    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            position = position >= 2 ? position + 1 : position;
            ((RadioButton) radioGroup.getChildAt(position)).setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                if (getApplicationContext() != null) {
                    Toast.makeText(getApplicationContext(), R.string.hint_exit, Toast.LENGTH_SHORT).show();
                    exitTime = System.currentTimeMillis();
                }
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
