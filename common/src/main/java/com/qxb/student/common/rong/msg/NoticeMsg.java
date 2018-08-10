package com.qxb.student.common.rong.msg;

import android.os.Parcel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;

import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;

/**
 * 自定义通知消息
 * Created by winky on 2017/12/7.
 */
@MessageTag(value = "qxb:noticeMsg", flag = MessageTag.ISPERSISTED)
public class NoticeMsg extends MessageContent {

    private final String UTF_8 = "UTF-8";

    public static final int OPEN_BAN = 1001;
    public static final int CLOSE_BAN = 1002;

    private String ownContent;
    private String tagetContent;
    private int status;

    public String getOwnContent() {
        return ownContent;
    }

    public void setOwnContent(String ownContent) {
        this.ownContent = ownContent;
    }

    public String getTagetContent() {
        return tagetContent;
    }

    public void setTagetContent(String tagetContent) {
        this.tagetContent = tagetContent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public NoticeMsg() {
    }

    public NoticeMsg(byte[] data) {
        try {
            JSONObject jsonObject = JSON.parseObject(new String(data, UTF_8));
            ownContent = jsonObject.getString("ownContent");
            tagetContent = jsonObject.getString("tagetContent");
            status = jsonObject.getIntValue("status");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public byte[] encode() {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ownContent", ownContent);
            jsonObject.put("tagetContent", tagetContent);
            jsonObject.put("status", status);
            return jsonObject.toString().getBytes(UTF_8);
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
        dest.writeString(this.ownContent);
        dest.writeString(this.tagetContent);
        dest.writeInt(this.status);
    }

    protected NoticeMsg(Parcel in) {
        this.ownContent = in.readString();
        this.tagetContent = in.readString();
        this.status = in.readInt();
    }

    public static final Creator<NoticeMsg> CREATOR = new Creator<NoticeMsg>() {
        @Override
        public NoticeMsg createFromParcel(Parcel source) {
            return new NoticeMsg(source);
        }

        @Override
        public NoticeMsg[] newArray(int size) {
            return new NoticeMsg[size];
        }
    };
}
