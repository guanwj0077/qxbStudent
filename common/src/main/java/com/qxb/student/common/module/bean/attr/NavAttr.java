package com.qxb.student.common.module.bean.attr;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.annotation.NavigationRes;
import android.support.annotation.Nullable;

/**
 * 导航入参
 * @author winky
 * @date 2018/7/20
 */
public class NavAttr implements Parcelable {

    public static final String TAG = "NavAttr";

    /**
     * 导航资源
     */
    private final int graphResId;
    /**
     * 导航id
     */
    private final int navigationId;
    /**
     * 参数
     */
    private final Bundle bundle;

    public NavAttr(int graphResId, int navigationId, Bundle bundle) {
        this.graphResId = graphResId;
        this.navigationId = navigationId;
        this.bundle = bundle;
    }

    public int getGraphResId() {
        return graphResId;
    }

    public int getNavigationId() {
        return navigationId;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public static class Builder {

        private int graphResId;
        private int navigationId;
        private Bundle bundle;

        public Builder graphRes(@NavigationRes int graphResId) {
            this.graphResId = graphResId;
            return this;
        }

        public Builder navId(@IdRes int navigationId) {
            this.navigationId = navigationId;
            return this;
        }

        public Builder params(@Nullable Bundle bundle) {
            this.bundle = bundle;
            return this;
        }

        public NavAttr build() {
            return new NavAttr(graphResId, navigationId, bundle);
        }

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.graphResId);
        dest.writeInt(this.navigationId);
        dest.writeBundle(this.bundle);
    }

    protected NavAttr(Parcel in) {
        this.graphResId = in.readInt();
        this.navigationId = in.readInt();
        this.bundle = in.readBundle();
    }

    public static final Parcelable.Creator<NavAttr> CREATOR = new Parcelable.Creator<NavAttr>() {
        @Override
        public NavAttr createFromParcel(Parcel source) {
            return new NavAttr(source);
        }

        @Override
        public NavAttr[] newArray(int size) {
            return new NavAttr[size];
        }
    };
}
