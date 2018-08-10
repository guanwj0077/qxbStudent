package com.qxb.student.common.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatImageButton;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.qxb.student.common.R;
import com.qxb.student.common.utils.NavigationUtils;
import com.qxb.student.common.utils.SysUtils;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 处理toolbar固定大小后文字居中微调
 * 注意getTitleMarginTop增加间距为了搭配CollapsingToolbarLayout折叠后样式
 *
 * @author winky
 * @date 2018/7/21
 */
public class Toolbar extends android.support.v7.widget.Toolbar {
    private TextView mTitleTextView;
    private ImageButton mNavButtonView;
    private boolean isPaddingTop;

    public Toolbar(Context context) {
        super(context);
        resolveAttribute(context, null, R.attr.toolbarStyle);
    }

    public Toolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        resolveAttribute(context, attrs, R.attr.toolbarStyle);
    }

    public Toolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        resolveAttribute(context, attrs, defStyleAttr);
    }

    private void resolveAttribute(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        final TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Toolbar, defStyleAttr, 0);
        final int titleTextAppearance = a.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        if (titleTextAppearance != 0) {
            setTitleTextAppearance(context, titleTextAppearance);
        }
        a.recycle();
        final TypedArray b = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ToolbarPadding, defStyleAttr, 0);
        isPaddingTop = b.getBoolean(R.styleable.ToolbarPadding_paddingTop, false);
        b.recycle();

        setContentInsetStartWithNavigation(0);
        setContentInsetEndWithActions(0);

        post(new Runnable() {
            @Override
            public void run() {
                if (getLayoutParams() instanceof LayoutParams) {
                    ((LayoutParams) getLayoutParams()).gravity = Gravity.CENTER_HORIZONTAL;
                }
            }
        });
    }

    public void setAppBarLayout(AppBarLayout appBarLayout) {
        this.setAppBarLayout(appBarLayout, false);
    }

    public void setAppBarLayout(AppBarLayout appBarLayout, final boolean noNavIcon) {
        setBackgroundResource(android.R.color.transparent);
        if (appBarLayout != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                @Override
                public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                    if (mTitleTextView != null) {
                        mTitleTextView.setVisibility(i > 400 - appBarLayout.getHeight() ? View.GONE : View.VISIBLE);
                    }
                    if (!noNavIcon) {
                        setNavigationIcon(i > 400 - appBarLayout.getHeight() ? R.drawable.arrow_left_white : R.drawable.arrow_left_black);
                    }
                }
            });
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (isPaddingTop) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec + SysUtils.getInstance().getStatusHeight());
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    public int getPaddingTop() {
        if (isPaddingTop) {
            return super.getPaddingTop() + SysUtils.getInstance().getStatusHeight();
        } else {
            return super.getPaddingTop();
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    public CharSequence getTitle() {
        if (mTitleTextView != null) {
            return mTitleTextView.getText().toString();
        } else {
            return null;
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        if (!TextUtils.isEmpty(title)) {
            if (mTitleTextView == null) {
                final Context context = getContext();
                mTitleTextView = new TextView(context);
                mTitleTextView.setMaxLines(2);
                mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
            }
            if (mTitleTextView.getParent() != this) {
                addCenterView(mTitleTextView);
            }
        } else if (mTitleTextView != null && mTitleTextView.getParent() == this) {
            removeView(mTitleTextView);
        }
        if (mTitleTextView != null) {
            mTitleTextView.setText(title);
        }
    }

    private void addCenterView(View v) {
        final ViewGroup.LayoutParams vlp = v.getLayoutParams();
        final LayoutParams lp;
        if (vlp == null) {
            lp = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(vlp)) {
            lp = generateLayoutParams(vlp);
        } else {
            lp = (LayoutParams) vlp;
        }
        addView(v, lp);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        LayoutParams lp = new LayoutParams(getContext(), attrs);

        lp.gravity = Gravity.CENTER_HORIZONTAL;
        return lp;
    }

    @Override
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        LayoutParams lp;
        if (p instanceof LayoutParams) {
            lp = new LayoutParams((LayoutParams) p);
        } else if (p instanceof ActionBar.LayoutParams) {
            lp = new LayoutParams((ActionBar.LayoutParams) p);
        } else if (p instanceof MarginLayoutParams) {
            lp = new LayoutParams((MarginLayoutParams) p);
        } else {
            lp = new LayoutParams(p);
        }
        lp.gravity = Gravity.CENTER_HORIZONTAL;
        return lp;
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER_HORIZONTAL;
        return lp;
    }

    @Override
    public void setTitleTextAppearance(Context context, @StyleRes int resId) {
        if (mTitleTextView != null) {
            mTitleTextView.setTextAppearance(context, resId);
        }
    }

    @Override
    public void setTitleTextColor(@ColorInt int color) {
        if (mTitleTextView != null) {
            mTitleTextView.setTextColor(color);
        }
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new AppCompatImageButton(this.getContext(), (AttributeSet) null, android.support.v7.appcompat.R.attr.toolbarNavigationButtonStyle);
            android.support.v7.widget.Toolbar.LayoutParams lp = this.generateDefaultLayoutParams();
            lp.gravity = Gravity.CENTER_VERTICAL | Gravity.START;
            addView(mNavButtonView, lp);
        }
    }

    @Override
    public void setNavigationOnClickListener(OnClickListener listener) {
        this.ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(listener);
    }

    @Override
    public void setNavigationIcon(@DrawableRes int resId) {
        this.setNavigationIcon(AppCompatResources.getDrawable(this.getContext(), resId));
    }

    @Override
    public void setNavigationIcon(@Nullable Drawable icon) {
        if (icon != null) {
            this.ensureNavButtonView();
        } else if (this.mNavButtonView != null && this.isChildOrHidden(this.mNavButtonView)) {
            this.removeView(this.mNavButtonView);
        }
        if (this.mNavButtonView != null) {
            this.mNavButtonView.setImageDrawable(icon);
        }
    }

    private boolean isChildOrHidden(View child) {
        return child.getParent() == this;
    }

}
