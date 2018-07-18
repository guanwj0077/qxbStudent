package com.qxb.student.common.module.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * created on: 2018/7/18 15:20
 * description:
 * @author zjk9527
 */
public class ScoreInfo implements Parcelable{
    public static final String TAG = ScoreInfo.class.getSimpleName();

    /**
     * descr : 其他成绩
     * edit_type : 0
     * id : 26
     * score : 555
     * stu_id : 26
     * title : 其他成绩（如：高中阶段期中、期末等）
     * type : 1
     * type_id : 0
     */

    private String descr;
    private int edit_type;
    private int id;
    private String score;
    private int stu_id;
    private String title;
    private int type;
    private int type_id;
    private int _id;
    public ScoreInfo() {
    }

    protected ScoreInfo(Parcel in) {
        descr = in.readString();
        edit_type = in.readInt();
        id = in.readInt();
        score = in.readString();
        stu_id = in.readInt();
        title = in.readString();
        type = in.readInt();
        type_id = in.readInt();
    }

    public static final Creator<ScoreInfo> CREATOR = new Creator<ScoreInfo>() {
        @Override
        public ScoreInfo createFromParcel(Parcel in) {
            return new ScoreInfo(in);
        }

        @Override
        public ScoreInfo[] newArray(int size) {
            return new ScoreInfo[size];
        }
    };

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getEdit_type() {
        return edit_type;
    }

    public void setEdit_type(int edit_type) {
        this.edit_type = edit_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
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

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(descr);
        parcel.writeInt(edit_type);
        parcel.writeInt(id);
        parcel.writeString(score);
        parcel.writeInt(stu_id);
        parcel.writeString(title);
        parcel.writeInt(type);
        parcel.writeInt(type_id);
    }
}
