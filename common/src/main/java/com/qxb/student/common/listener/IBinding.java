package com.qxb.student.common.listener;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * @author winky
 * @date 2018/5/12
 */
public interface IBinding {

    int bindLayout();

    void init(@NonNull View view, @Nullable Bundle savedInstanceState);
}
