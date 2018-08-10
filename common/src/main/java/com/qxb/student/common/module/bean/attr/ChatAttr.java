package com.qxb.student.common.module.bean.attr;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author winky
 * @date 2018/8/10
 */
public class ChatAttr implements Parcelable {

    public static final String TAG = "ChatAttr";
    /**
     * 聊天页面标题
     */
    private final String title;
    /**
     * 目标id
     */
    private final String targetId;
    /**
     * 学校名称
     */
    private final String schoolId;
    /**
     * 学校id
     */
    private final String schoolName;
    /**
     * 是否是留学院校
     */
    private final int schoolType;
    /**
     * 是否有常见问题
     */
    private final boolean hasComProblem;

    ChatAttr(String title, String targetId, String schoolId, String schoolName, int schoolType, boolean hasComProblem) {
        this.title = title;
        this.targetId = targetId;
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.schoolType = schoolType;
        this.hasComProblem = hasComProblem;
    }

    public String getTitle() {
        return title;
    }

    public String getTargetId() {
        return targetId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public int getSchoolType() {
        return schoolType;
    }

    public boolean isHasComProblem() {
        return hasComProblem;
    }

    public static class Builder {
        private String title;
        private String targetId;
        private String schoolName;
        private String schoolId;
        private boolean hasComProblem;
        private int schoolType;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder targetId(String targetId) {
            this.targetId = targetId;
            return this;
        }

        public Builder schoolId(String schoolId) {
            this.schoolId = schoolId;
            return this;
        }

        public Builder schoolName(String schoolName) {
            this.schoolName = schoolName;
            return this;
        }

        public Builder schoolType(int schoolType) {
            this.schoolType = schoolType;
            return this;
        }

        public Builder hasComProblem() {
            this.hasComProblem = true;
            return this;
        }

        public Builder hasComProblem(boolean hasComProblem) {
            this.hasComProblem = hasComProblem;
            return this;
        }

        public ChatAttr build() {
            return new ChatAttr(title, targetId, schoolId, schoolName, schoolType, hasComProblem);
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.targetId);
        dest.writeString(this.schoolId);
        dest.writeString(this.schoolName);
        dest.writeInt(this.schoolType);
        dest.writeByte(this.hasComProblem ? (byte) 1 : (byte) 0);
    }

    protected ChatAttr(Parcel in) {
        this.title = in.readString();
        this.targetId = in.readString();
        this.schoolId = in.readString();
        this.schoolName = in.readString();
        this.schoolType = in.readInt();
        this.hasComProblem = in.readByte() != 0;
    }

    public static final Parcelable.Creator<ChatAttr> CREATOR = new Parcelable.Creator<ChatAttr>() {
        @Override
        public ChatAttr createFromParcel(Parcel source) {
            return new ChatAttr(source);
        }

        @Override
        public ChatAttr[] newArray(int size) {
            return new ChatAttr[size];
        }
    };
}
