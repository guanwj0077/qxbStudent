package com.qxb.student.common.rong.msg;

import android.os.Parcel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;

import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import okhttp3.internal.Util;

/**
 * 要电话
 * Created by winky on 2017/12/13.
 */
@MessageTag(value = "qxb:phoneMsg", flag = MessageTag.ISCOUNTED)
public class PhoneMsg extends MessageContent {

    private String name;
    private String phone;

    public PhoneMsg(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public PhoneMsg(byte[] data) {
        try {
            JSONObject jsonObject = JSON.parseObject(new String(data, Util.UTF_8.name()));
            name = jsonObject.getString("name");
            phone = jsonObject.getString("phone");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public byte[] encode() {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", name);
            jsonObject.put("phone", phone);
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
        dest.writeString(this.name);
        dest.writeString(this.phone);
    }

    PhoneMsg(Parcel in) {
        this.name = in.readString();
        this.phone = in.readString();
    }

    public static final Creator<PhoneMsg> CREATOR = new Creator<PhoneMsg>() {
        @Override
        public PhoneMsg createFromParcel(Parcel source) {
            return new PhoneMsg(source);
        }

        @Override
        public PhoneMsg[] newArray(int size) {
            return new PhoneMsg[size];
        }
    };
}

