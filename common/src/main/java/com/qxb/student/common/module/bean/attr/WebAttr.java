package com.qxb.student.common.module.bean.attr;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/**
 * 通用页面入参
 * {@link com.qxb.student.common.basics.WebActivity}
 *
 * @author winky
 */
public class WebAttr implements Parcelable {

    public static final String TAG = "WebAttr";

    /**
     * 标题
     */
    private final String title;
    /**
     * 网页链接
     */
    private final String httpUrl;
    /**
     * 是否在外部浏览器打开
     */
    private final boolean external;
    /**
     * 网页认证头
     */
    private final String auth;
    /**
     * 能不能分享
     */
    private final boolean canShare;
    /**
     * 分享图片地址
     */
    private final String shareImageUrl;
    /**
     * 分享网页地址
     */
    private final String shareUrl;
    /**
     * 分享副标题
     */
    private final String shareText;

    private WebAttr(String title, String httpUrl, boolean external, String auth, boolean canShare, String shareImageUrl, String shareUrl, String shareText) {
        this.title = title;
        this.httpUrl = httpUrl;
        this.external = external;
        this.auth = auth;
        this.canShare = canShare;
        this.shareImageUrl = shareImageUrl;
        this.shareUrl = shareUrl;
        this.shareText = shareText;
    }

    public static class Builder {
        private String title;
        private String httpUrl;
        private boolean external;
        private String auth;
        private boolean canShare;
        private String shareImageUrl;
        private String shareUrl;
        private String shareText;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder url(String httpUrl) {
            this.httpUrl = httpUrl;
            return this;
        }

        public Builder external() {
            this.external = true;
            return this;
        }

        public Builder auth(String auth) {
            this.auth = auth;
            return this;
        }

        public Builder share() {
            this.canShare = true;
            return this;
        }

        public Builder shareImageUrl(String shareImageUrl) {
            this.shareImageUrl = shareImageUrl;
            return this;
        }

        public Builder shareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
            return this;
        }

        public Builder shareText(String shareText) {
            this.shareText = shareText;
            return this;
        }

        public WebAttr build() {
            if (TextUtils.isEmpty(title)) {
                title = "";
            }
            if (TextUtils.isEmpty(httpUrl)) {
                throw new IllegalArgumentException("web url Can't be empty");
            }
            if (TextUtils.isEmpty(auth)) {
                auth = "";
            }
            if (canShare) {
                if (TextUtils.isEmpty(shareImageUrl) || TextUtils.isEmpty(shareUrl) || TextUtils.isEmpty(shareText)) {
                    throw new IllegalArgumentException("share must be has imageUrl & shareUrl & shareText");
                }
            }
            return new WebAttr(title, httpUrl, external, auth, canShare, shareImageUrl, shareUrl, shareText);
        }
    }

    public String getTitle() {
        return title;
    }

    public String getHttpUrl() {
        return httpUrl;
    }

    public boolean isExternal() {
        return external;
    }

    public String getAuth() {
        return auth;
    }

    public boolean isCanShare() {
        return canShare;
    }

    public String getShareImageUrl() {
        return shareImageUrl;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public String getShareText() {
        return shareText;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.httpUrl);
        dest.writeByte(this.external ? (byte) 1 : (byte) 0);
        dest.writeString(this.auth);
        dest.writeByte(this.canShare ? (byte) 1 : (byte) 0);
        dest.writeString(this.shareImageUrl);
        dest.writeString(this.shareUrl);
        dest.writeString(this.shareText);
    }

    protected WebAttr(Parcel in) {
        this.title = in.readString();
        this.httpUrl = in.readString();
        this.external = in.readByte() != 0;
        this.auth = in.readString();
        this.canShare = in.readByte() != 0;
        this.shareImageUrl = in.readString();
        this.shareUrl = in.readString();
        this.shareText = in.readString();
    }

    public static final Parcelable.Creator<WebAttr> CREATOR = new Parcelable.Creator<WebAttr>() {
        @Override
        public WebAttr createFromParcel(Parcel source) {
            return new WebAttr(source);
        }

        @Override
        public WebAttr[] newArray(int size) {
            return new WebAttr[size];
        }
    };
}
