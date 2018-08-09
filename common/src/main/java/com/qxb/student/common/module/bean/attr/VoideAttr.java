package com.qxb.student.common.module.bean.attr;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author: zjk9527
 * created on: 2018/8/3 15:57
 * description:
 */
public class VoideAttr implements Parcelable {

    /**
     * 视屏播放的地址
     */
    private final String url;

    /**
     * 视屏播放的标题
     */

    private final String title;

    /**
     * 视屏封面
     */
    private final String coverRealPath;

    /**
     * 是否显示分享按钮
     */
    private final boolean isShare;


   public VoideAttr(VoideBuilder voideBuilder) {
        this.url = voideBuilder.url;
        this.title = voideBuilder.title;
        this.coverRealPath = voideBuilder.coverRealPath;
        this.isShare = voideBuilder.isShare;

    }


    protected VoideAttr(Parcel in) {
        url = in.readString();
        title = in.readString();
        coverRealPath = in.readString();
        isShare = in.readByte() != 0;
    }



    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(title);
        dest.writeString(coverRealPath);
        dest.writeByte((byte) (isShare ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<VoideAttr> CREATOR = new Creator<VoideAttr>() {
        @Override
        public VoideAttr createFromParcel(Parcel in) {
            return new VoideAttr(in);
        }

        @Override
        public VoideAttr[] newArray(int size) {
            return new VoideAttr[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getCoverRealPath() {
        return coverRealPath;
    }

    public boolean isShare() {
        return isShare;
    }

    public static class VoideBuilder {
        /**
         * 必传
         */
        private final String url;

        /**
         * 必传
         */
        private final String title;

        /**
         * 必传
         */
        private  final String coverRealPath;

        /**
         * 非必传
         * */
        private boolean isShare;

        public VoideBuilder(String url, String title, String coverRealPath) {
            this.url = url;
            this.title = title;
            this.coverRealPath = coverRealPath;
        }

        public VoideBuilder isShare(boolean isShare) {
            this.isShare = isShare;
            return this;
        }

        public VoideAttr build() {

            return new VoideAttr(this);
        }
    }
}
