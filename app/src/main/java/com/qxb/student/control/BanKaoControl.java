package com.qxb.student.control;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

/**
 * 伴考
 *
 * @author winky
 * @date 2018/7/20
 */
public class BanKaoControl extends AndroidViewModel {


    public BanKaoControl(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
