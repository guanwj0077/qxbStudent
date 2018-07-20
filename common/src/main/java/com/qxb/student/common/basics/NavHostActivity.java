package com.qxb.student.common.basics;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.qxb.student.common.R;

import java.util.Objects;

/**
 * 导航起点
 *
 * @author winky
 */
public class NavHostActivity extends BaseAppActivity {

    private NavFragment hostFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_frame);
        hostFragment = NavFragment.create(Objects.requireNonNull(getIntent().getExtras()));
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_content, hostFragment)
                .commit();
    }


    @Override
    public void onBackPressed() {
        if (!NavFragment.findNavController(hostFragment).navigateUp()) {
            finish();
        }
    }
}
