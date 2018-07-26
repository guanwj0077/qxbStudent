package com.qxb.student.common.module.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.text.TextUtils;

import com.qxb.student.common.Constant;

/**
 * 用户信息
 *
 * @author winky
 */
@Entity(tableName = "User")
public class User {

    private String area;
    private String area_name;
    private String city;
    private String city_name;
    private int gaokaofen;
    @PrimaryKey
    private int id;
    private int login_number;
    private long login_time;
    private String name;
    private String noticeRealPath;
    private long notice_book_time;
    private String notice_book_url;
    private String password;
    private String pic;
    private String picRealPath;
    /**
     * 省份编码
     */
    private String province;
    /**
     * 省份名称
     */
    private String province_name;
    private String baominghao;
    /**
     * 高中学校名
     */
    private String highschool_name;
    private String ticketno;
    private String address;
    private long reg_time;
    private String sex;
    private int status;
    private String subject;
    private String telphone;
    private String tonken;
    private int total;
    private String nick_name;
    private int years;
    private int yugufen;
    private int type;
    private String luquSchoolPicRealPath;
    private String student_code;
    private String app_showname;
    private int account_id;
    private int highschool_id;
    /**
     * 招办编码
     */
    private String area_code;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public int getGaokaofen() {
        return gaokaofen;
    }

    public void setGaokaofen(int gaokaofen) {
        this.gaokaofen = gaokaofen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLogin_number() {
        return login_number;
    }

    public void setLogin_number(int login_number) {
        this.login_number = login_number;
    }

    public long getLogin_time() {
        return login_time;
    }

    public void setLogin_time(long login_time) {
        this.login_time = login_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoticeRealPath() {
        return noticeRealPath;
    }

    public void setNoticeRealPath(String noticeRealPath) {
        this.noticeRealPath = noticeRealPath;
    }

    public long getNotice_book_time() {
        return notice_book_time;
    }

    public void setNotice_book_time(long notice_book_time) {
        this.notice_book_time = notice_book_time;
    }

    public String getNotice_book_url() {
        return notice_book_url;
    }

    public void setNotice_book_url(String notice_book_url) {
        this.notice_book_url = notice_book_url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPicRealPath() {
        return picRealPath;
    }

    public void setPicRealPath(String picRealPath) {
        this.picRealPath = picRealPath;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getBaominghao() {
        return baominghao;
    }

    public void setBaominghao(String baominghao) {
        this.baominghao = baominghao;
    }

    public String getHighschool_name() {
        return highschool_name;
    }

    public void setHighschool_name(String highschool_name) {
        this.highschool_name = highschool_name;
    }

    public String getTicketno() {
        return ticketno;
    }

    public void setTicketno(String ticketno) {
        this.ticketno = ticketno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getReg_time() {
        return reg_time;
    }

    public void setReg_time(long reg_time) {
        this.reg_time = reg_time;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public int getSubjectType() {
        return Constant.WEN_KE.equals(subject) ? 1 : 2;
    }

    public boolean isLiberalArt() {
        return Constant.WEN_KE.equals(subject);
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getTonken() {
        return tonken;
    }

    public void setTonken(String tonken) {
        this.tonken = tonken;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getYugufen() {
        return yugufen;
    }

    public void setYugufen(int yugufen) {
        this.yugufen = yugufen;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLuquSchoolPicRealPath() {
        return luquSchoolPicRealPath;
    }

    public void setLuquSchoolPicRealPath(String luquSchoolPicRealPath) {
        this.luquSchoolPicRealPath = luquSchoolPicRealPath;
    }

    public String getStudent_code() {
        return student_code;
    }

    public void setStudent_code(String student_code) {
        this.student_code = student_code;
    }

    public String getApp_showname() {
        return app_showname;
    }

    public void setApp_showname(String app_showname) {
        this.app_showname = app_showname;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getHighschool_id() {
        return highschool_id;
    }

    public void setHighschool_id(int highschool_id) {
        this.highschool_id = highschool_id;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }
}
