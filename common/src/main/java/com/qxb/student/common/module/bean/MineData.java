package com.qxb.student.common.module.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * author: zjk9527
 * created on: 2018/7/18 15:22
 * description:
 */
public class MineData implements Parcelable{
    /**
     * draw_id 图片资源
     */
    private int draw_id;
    /**
     * name item名字
     */
    private String name;
    /**
     * isView  是否显示加粗分割线
     */
    private boolean isView;
    /**
     * isShow 是否显示布局
     */
    private boolean isShow;

    public MineData(int draw_id, String name, boolean isView, boolean isShow) {
        this.draw_id = draw_id;
        this.name = name;
        this.isView = isView;
        this.isShow = isShow;
    }

    public MineData() {
    }

    protected MineData(Parcel in) {
        draw_id = in.readInt();
        name = in.readString();
        isView = in.readByte() != 0;
        isShow = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(draw_id);
        dest.writeString(name);
        dest.writeByte((byte) (isView ? 1 : 0));
        dest.writeByte((byte) (isShow ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MineData> CREATOR = new Creator<MineData>() {
        @Override
        public MineData createFromParcel(Parcel in) {
            return new MineData(in);
        }

        @Override
        public MineData[] newArray(int size) {
            return new MineData[size];
        }
    };

    public int getDraw_id() {
        return draw_id;
    }

    public void setDraw_id(int draw_id) {
        this.draw_id = draw_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isView() {
        return isView;
    }

    public void setView(boolean view) {
        isView = view;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }
}
