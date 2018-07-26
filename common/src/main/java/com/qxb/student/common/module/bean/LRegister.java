package com.qxb.student.common.module.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author: zjk9527
 * created on: 2018/7/25 13:43
 * description:
 */
public class LRegister implements Parcelable{

    /*标识*/
    private int id;
    /*标题*/
    private String title;
    /*是否显示“登录”*/
    private boolean showLogin;
    /*短信验证码*/
    private String smsCode;
    /*手机号码*/
    private String phone;
    /*密码*/
    private String password;
    /*性别*/
    private String sex;
    /*头像地址*/
    private String pic;
    /*三方登录唯一id*/
    private String open_id;
    /*第三方登录区分 1为QQ  2为微信*/
    private String typep;
    /*是否已经注册过*/
    private String has_regist;

    public String getHas_regist() {
        return has_regist;
    }

    public void setHas_regist(String has_regist) {
        this.has_regist = has_regist;
    }

    public String getTypep() {
        return typep;
    }

    public void setTypep(String typep) {
        this.typep = typep;
    }



    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShowLogin(boolean showLogin) {
        this.showLogin = showLogin;
    }

    public String getTitle() {
        return title;
    }

    public boolean isShowLogin() {
        return showLogin;
    }

    public LRegister(int id, String title, boolean showLogin) {
        this.id = id;
        this.title = title;
        this.showLogin = showLogin;
    }

    public LRegister() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeByte(this.showLogin ? (byte) 1 : (byte) 0);
        dest.writeString(this.smsCode);
        dest.writeString(this.phone);
        dest.writeString(this.password);
        dest.writeString(this.sex);
        dest.writeString(this.pic);
        dest.writeString(this.open_id);
        dest.writeString(this.typep);
        dest.writeString(this.has_regist);
    }

    protected LRegister(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.showLogin = in.readByte() != 0;
        this.smsCode = in.readString();
        this.phone = in.readString();
        this.password = in.readString();
        this.sex = in.readString();
        this.pic = in.readString();
        this.open_id = in.readString();
        this.typep = in.readString();
        this.has_regist = in.readString();
    }

    public static final Creator<LRegister> CREATOR = new Creator<LRegister>() {
        @Override
        public LRegister createFromParcel(Parcel source) {
            return new LRegister(source);
        }

        @Override
        public LRegister[] newArray(int size) {
            return new LRegister[size];
        }
    };
}
