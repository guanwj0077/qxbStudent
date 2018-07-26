package com.qxb.student.ui.home.school;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.qxb.student.common.basics.AbsExpandFragment;

/**
 * @author winky
 * @date 2018/7/26
 */
public class SchoolMajorDetailFragment extends AbsExpandFragment {

    private static final String ID = "_id";
    private static final String TYPE = "_type";

    @Override
    public int bindLayout() {
        return 0;
    }

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    public static Bundle create(int id, String type) {
        Bundle bundle = new Bundle();
        bundle.putString(ID, String.valueOf(id));
        bundle.putString(TYPE, type);
        return bundle;
    }
}
