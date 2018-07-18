package com.qxb.student.common.utils;

import android.databinding.BindingAdapter;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

/**
 * Databinding框架绑定事件
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
}
