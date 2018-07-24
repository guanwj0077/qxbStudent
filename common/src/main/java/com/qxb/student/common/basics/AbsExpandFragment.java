package com.qxb.student.common.basics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

/**
 * 预留扩展
 *
 * @author winky
 */
public abstract class AbsExpandFragment extends BaseFragment {

    /**
     * 隐藏软键盘
     */
    protected final void hideInputMethod(final Activity activity) {
        if (activity != null) {
            InputMethodManager mInputKeyBoard = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            mInputKeyBoard.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        }
    }

    private boolean isKeyboardShown(View rootView) {
        final int softKeyboardHeight = 100;
        Rect r = new Rect();
        rootView.getWindowVisibleDisplayFrame(r);
        DisplayMetrics dm = rootView.getResources().getDisplayMetrics();
        int heightDiff = rootView.getBottom() - r.bottom;
        return heightDiff > softKeyboardHeight * dm.density;
    }

    /**
     * 添加软键盘状态监听器
     */
    protected void setKeyboardStateListener() {
        final View rootView = getActivity().getWindow().getDecorView().findViewById(android.R.id.content);
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                rootView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (isKeyboardShown(rootView)) {
                            onKeyBoardShow();
                        } else {
                            onKeyBoardHide();
                        }
                    }
                }, 100);

            }
        });
    }

    /**
     * 软键盘打开时要做的操作
     */
    public void onKeyBoardShow() {
    }

    ;

    /**
     * 软键盘隐藏时要做的操作
     */
    public void onKeyBoardHide() {
    }

}
