package com.qxb.student.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qxb.student.common.R;

/**
 * 处理toolbar固定大小后文字居中微调
 * 注意getTitleMarginTop增加间距为了搭配CollapsingToolbarLayout折叠后样式
 *
 * @author winky
 * @date 2018/7/21
 */
public class Toolbar extends android.support.v7.widget.Toolbar {

    /**
     * 上间距
     */
    private final int VIEW_PADDING_TOP = 40;
    private TextView mTitleTextView;

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
        setPadding(0, VIEW_PADDING_TOP, 0, 0);
        a.recycle();
        post(new Runnable() {
            @Override
            public void run() {
                if (getLayoutParams() instanceof LayoutParams) {
                    ((LayoutParams) getLayoutParams()).gravity = Gravity.CENTER_HORIZONTAL;
                }
            }
        });

        AppBarLayout appBarLayout = getAppBarLayout();
        if (appBarLayout != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                @Override
                public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                    if (mTitleTextView != null) {
                        mTitleTextView.setVisibility(i > -300 ? View.GONE : View.VISIBLE);
                    }
                }
            });
        }
    }

    private AppBarLayout getAppBarLayout() {
        AppBarLayout appBarLayout = null;
        View view = (View) getParent();
        if (view == null) {
            return null;
        }
        while (true) {
            if (view instanceof AppBarLayout) {
                appBarLayout = (AppBarLayout) view;
                break;
            } else {
                view = (View) view.getParent();
                if (view == null) {
                    break;
                }
            }
        }
        return appBarLayout;
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
                mTitleTextView.setSingleLine();
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

    @Override
    public int getTitleMarginTop() {
        return super.getTitleMarginTop() + VIEW_PADDING_TOP;
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
}
