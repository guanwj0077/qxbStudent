package com.qxb.student.common.utils;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Databinding框架绑定事件
 *
 * @author winky
 */
public class BindingUtils {

    @BindingAdapter({"imageUrl"})
    public static void imageUrl(ImageView imageView, String imageUrl) {
        GlideUtils.getInstance().loadImage(imageView, imageUrl);
    }

    @BindingAdapter({"roundImageUrl"})
    public static void roundImageUrl(ImageView imageView, String imageUrl) {
        GlideUtils.getInstance().LoadContextCircleBitmap(imageView.getContext(), imageUrl, imageView);
    }

    @BindingAdapter({"localImage"})
    public static void localImage(ImageView imageView, @DrawableRes int resId) {
        GlideUtils.getInstance().LoadContextRes(imageView.getContext(), resId, imageView);
    }

    @BindingAdapter({"imageUrl", "radius"})
    public static void imageUrl(ImageView imageView, String imageUrl, int radius) {
        GlideUtils.getInstance().LoadContextRoundBitmap(imageView.getContext(), imageUrl, imageView, radius);
    }

    @BindingAdapter({"commentTime"})
    public static void commentTime(TextView textView, long time) {
        textView.setText(TimeUtils.intervalStr(time));
    }

    @BindingAdapter({"str1", "str2"})
    public static void equalsVisible(ImageView view, String str1, String str2) {
        view.setVisibility(str1.equals(str2) ? View.VISIBLE : View.GONE);
    }

    public static void setTextDrawable(@NonNull TextView textView, @DrawableRes int resId) {
        Drawable drawable = ContextCompat.getDrawable(textView.getContext(), resId);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        textView.setCompoundDrawables(null, null, drawable, null);
    }


}
