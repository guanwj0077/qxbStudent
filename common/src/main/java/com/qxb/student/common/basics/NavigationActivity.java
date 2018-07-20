package com.qxb.student.common.basics;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.qxb.student.common.Config;
import com.qxb.student.common.Constant;
import com.qxb.student.common.R;

import androidx.navigation.fragment.NavHostFragment;

/**
 * 导航起点
 * @author winky
 */
public class NavigationActivity extends BaseAppActivity {

    private NavHostFragment hostFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_frame);
        int navigationId = getIntent().getIntExtra(Constant.NAVIGATION_ID, 0);
        if (navigationId == 0) {
            throw new IllegalArgumentException("navigation_id == 0");
        }
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_content, hostFragment = NavHostFragment.create(navigationId))
                .commit();
    }


    @Override
    public void onBackPressed() {
        if (!NavHostFragment.findNavController(hostFragment).navigateUp()) {
            finish();
        }
    }
}
