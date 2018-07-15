package com.qxb.student.common.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

public class BindingUtils {

    @BindingAdapter({"imageUrl"})
    public static void imageUrl(ImageView imageView, String imageUrl) {
        GlideUtils.getInstance().LoadContextCircleBitmap(imageView.getContext(), imageUrl, imageView);
    }
}
