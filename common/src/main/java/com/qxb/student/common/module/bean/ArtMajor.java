package com.qxb.student.common.module.bean;

/**
 * 艺术院校专业
 *
 * @author
 */
public class ArtMajor {

    /**
     * 学校id
     **/
    private int school_id;
    /**
     * 专业名称
     **/
    private String name;
    /**
     * 专业大类
     **/
    private String art_category_code;
    /**
     * 专业类别（本专）
     **/
    private String major_type;
    /**
     * 招生年份
     **/
    private int year;
    /**
     * 招生省份
     **/
    private String province;
    /**
     * 招生人数
     **/
    private int recruit_num;
    /**
     * 最新标识
     **/
    private int newest;
    /**
     * 学校名称
     */
    private String school_name;
    /**
     * 省份名称
     */
    private String province_name;

    /**
     * 专业介绍
     */
    private String summary;


    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArt_category_code() {
        return art_category_code;
    }

    public void setArt_category_code(String art_category_code) {
        this.art_category_code = art_category_code;
    }

    public String getMajor_type() {
        return major_type;
    }

    public void setMajor_type(String major_type) {
        this.major_type = major_type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getRecruit_num() {
        return recruit_num;
    }

    public void setRecruit_num(int recruit_num) {
        this.recruit_num = recruit_num;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public int getNewest() {
        return newest;
    }

    public void setNewest(int newest) {
        this.newest = newest;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
