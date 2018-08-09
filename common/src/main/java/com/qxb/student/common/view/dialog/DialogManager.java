package com.qxb.student.common.view.dialog;

import android.annotation.SuppressLint;
import android.support.v4.app.FragmentManager;

/**
 * created on: 2018/7/12 17:54
 * description:
 * @author Administrator
 */
public class DialogManager {
    private LoadingFragment loadingDialogFragment;
    private boolean isShowing = false;

    public DialogManager(){
        loadingDialogFragment = new LoadingFragment();

    }

    public void setText(String str){
        loadingDialogFragment = new LoadingFragment(str);
    }


    /**
     * 显示dialog
     * @param fm
     */
    @SuppressLint("NewApi")
    public void showLoadingDialogFragment(FragmentManager fm){
        if(!isShowing){
            loadingDialogFragment.show(fm, "dialog");
            isShowing = true;
        }
    }

    /**
     * 隐藏dialog
     */
    @SuppressLint("NewApi")
    public void hideLoadingDialogFragment(){
        if(isShowing){
            if(loadingDialogFragment.getActivity() != null){
                loadingDialogFragment.dismissAllowingStateLoss();
            }

            isShowing = false;
        }
    }

}
