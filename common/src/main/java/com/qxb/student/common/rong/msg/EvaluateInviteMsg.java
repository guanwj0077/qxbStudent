package com.qxb.student.common.rong.msg;

import android.os.Parcel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;

import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import okhttp3.internal.Util;

/**
 * 邀请评价
 * Created by winky on 2017/12/13.
 */
@MessageTag(value = "qxb:evaluateInviteMsg", flag = MessageTag.ISCOUNTED)
public class EvaluateInviteMsg extends MessageContent {

    private String teacherId;
    private String schoolId;

    public EvaluateInviteMsg() {
    }

    public EvaluateInviteMsg(byte[] data) {
        try {
            JSONObject jsonObject = JSON.parseObject(new String(data, Util.UTF_8.name()));
            teacherId = jsonObject.getString("teacherId");
            schoolId = jsonObject.getString("schoolId");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public byte[] encode() {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("teacherId", teacherId);
            jsonObject.put("schoolId", schoolId);
            return jsonObject.toString().getBytes(Util.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.teacherId);
        dest.writeString(this.schoolId);
    }

    protected EvaluateInviteMsg(Parcel in) {
        this.teacherId = in.readString();
        this.schoolId = in.readString();
    }

    public static final Creator<EvaluateInviteMsg> CREATOR = new Creator<EvaluateInviteMsg>() {
        @Override
        public EvaluateInviteMsg createFromParcel(Parcel source) {
            return new EvaluateInviteMsg(source);
        }

        @Override
        public EvaluateInviteMsg[] newArray(int size) {
            return new EvaluateInviteMsg[size];
        }
    };
}
