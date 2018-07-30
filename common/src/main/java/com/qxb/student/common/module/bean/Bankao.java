package com.qxb.student.common.module.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity(tableName = "Bankao")
public class Bankao implements Parcelable {
    @Ignore
    public static final String TAG = "Bankao";

    /**
     * id
     */
    @PrimaryKey
    private int id;
    /**
     * 图片地址
     */
    private String img_url;
    /**
     * 简介
     */
    private String intro;
    /**
     * 是否广告
     */
    private int isAd;
    /**
     * 是否收藏  1.收藏 0未收藏
     */
    private int is_collectioned;
    /**
     * 标题
     */
    private String title;
    /**
     * 类型 1.资讯2.备考3.报考4.大学5.专业
     */
    private int type;
    /**
     * 视频地址
     */
    private String video_url;
    /**
     * 链接地址
     */
    private String http_link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getIsAd() {
        return isAd;
    }

    public void setIsAd(int isAd) {
        this.isAd = isAd;
    }

    public int getIs_collectioned() {
        return is_collectioned;
    }

    public void setIs_collectioned(int is_collectioned) {
        this.is_collectioned = is_collectioned;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getHttp_link() {
        return http_link;
    }

    public void setHttp_link(String http_link) {
        this.http_link = http_link;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.img_url);
        dest.writeString(this.intro);
        dest.writeInt(this.isAd);
        dest.writeInt(this.is_collectioned);
        dest.writeString(this.title);
        dest.writeInt(this.type);
        dest.writeString(this.video_url);
        dest.writeString(this.http_link);
    }

    public Bankao() {
    }

    protected Bankao(Parcel in) {
        this.id = in.readInt();
        this.img_url = in.readString();
        this.intro = in.readString();
        this.isAd = in.readInt();
        this.is_collectioned = in.readInt();
        this.title = in.readString();
        this.type = in.readInt();
        this.video_url = in.readString();
        this.http_link = in.readString();
    }

    public static final Parcelable.Creator<Bankao> CREATOR = new Parcelable.Creator<Bankao>() {
        @Override
        public Bankao createFromParcel(Parcel source) {
            return new Bankao(source);
        }

        @Override
        public Bankao[] newArray(int size) {
            return new Bankao[size];
        }
    };
}
