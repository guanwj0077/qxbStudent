package com.qxb.student.common.utils;

import android.databinding.BindingAdapter;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

public class BindingUtils {

    @BindingAdapter({"imageUrl"})
    public static void imageUrl(ImageView imageView, String imageUrl) {
        GlideUtils.getInstance().LoadContextCircleBitmap(imageView.getContext(), imageUrl, imageView);
    }

    @BindingAdapter({"localImage"})
    public static void localImage(ImageView imageView, @DrawableRes int resid) {
        GlideUtils.getInstance().LoadContextRes(imageView.getContext(), resid, imageView);
    }
}
