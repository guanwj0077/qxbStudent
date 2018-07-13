package com.qxb.student.helper;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.qxb.student.common.utils.GlideUtils;

public class BindingUtils {

    @BindingAdapter({"imageUrl"})
    public static void imageUrl(ImageView imageView, String imageUrl) {
        GlideUtils.getInstance().LoadContextCircleBitmap(imageView.getContext(), imageUrl, imageView);
    }
}
