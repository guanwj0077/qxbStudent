package com.qxb.student.common.rong.msg;

import android.os.Parcel;

import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;

/**
 * Created by winky on 2017/12/21.
 */
@MessageTag(value = "qxb:phoneInviteMsg", flag = MessageTag.ISCOUNTED)
public class PhoneInviteMsg extends MessageContent {

    public PhoneInviteMsg() {
    }

    public PhoneInviteMsg(byte[] data) {
    }

    @Override
    public byte[] encode() {
        return null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    protected PhoneInviteMsg(Parcel in) {
    }

    public static final Creator<PhoneInviteMsg> CREATOR = new Creator<PhoneInviteMsg>() {
        @Override
        public PhoneInviteMsg createFromParcel(Parcel source) {
            return new PhoneInviteMsg(source);
        }

        @Override
        public PhoneInviteMsg[] newArray(int size) {
            return new PhoneInviteMsg[size];
        }
    };
}
