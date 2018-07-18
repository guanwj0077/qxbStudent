package com.qxb.student.common.module.bean;

import java.util.Date;


public class BaseHighSchool {

    private int id;
    /**
     * 学校名称
     */
    private String school_name;
    /**
     * 学校网址
     */
    private String weburl;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String area;
    /**
     * 状态
     */
    private int status;

    private String province_name;

    private String city_name;

    private String area_name;



    /**
     * 获取
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取学校名称
     */
    public String getSchool_name() {
        return school_name;
    }

    /**
     * 设置学校名称
     */
    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    /**
     * 获取学校网址
     */
    public String getWeburl() {
        return weburl;
    }

    /**
     * 设置学校网址
     */
    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    /**
     * 获取省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置区
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取状态
     */
    public int getStatus() {
        return status;
    }

    /**
     * 设置状态
     */
    public void setStatus(int status) {
        this.status = status;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }
}
