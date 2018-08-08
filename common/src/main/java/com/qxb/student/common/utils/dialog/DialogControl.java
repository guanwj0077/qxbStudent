package com.qxb.student.common.utils.dialog;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

/**
 * @author winky
 * @date 2018/8/8
 */
public class DialogControl extends AndroidViewModel {

    
    public DialogControl(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
