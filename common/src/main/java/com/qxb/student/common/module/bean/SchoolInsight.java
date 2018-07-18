package com.qxb.student.common.module.bean;

import java.util.List;

public class SchoolInsight {

    /**
     * id
     */
    private int id;
    /**
     * 年份
     */
    private int year;
    /**
     * 学校ID
     */
    private int school_id;
    /**
     * 省份
     */
    private String province;
    /**
     * 类别(1:预估分/2:高考分)
     */
    private int score_type;
    /**
     * 学科类型(文科/理科)
     */
    private int subject_type;
    /**
     * 批次
     */
    private int bat;
    /**
     * 位次值
     */
    private int precedence;
    /**
     * 平均分
     */
    private int score_avg;
    /**
     * 同位分
     */
    private int score_apposition;
    /**
     * 备注
     */
    private String remark;
    /**
     * 学科门类  01,02,
     **/
    private String subject_category_codes;
    private String province_name;
    private String school_name;
    private String logo;
    private String tag;

    /**
     * 学校所在省份
     */
    private String sprovince;

    /**
     * 是否入驻
     **/
    private int is_join_metting;

    /**
     * 学校录取最低分
     */
    private int score_min;
    /**
     * 学校招生数量
     */
    private int recruit_num;
    /**
     * 是否关注
     */
    private Boolean is_att = false;

    /**
     * 是否预报名
     */
    private Boolean is_reg = false;
    /**
     * 在招专业
     */
    private List<String> majorList;
    private String logoRealPath;
    /**
     * 学生所在省份
     */
    private String sprovince_name;
    /**
     * 批次名称
     */
    private String bat_name;

    public List<String> getMajorList() {
        return majorList;
    }

    public void setMajorList(List<String> majorList) {
        this.majorList = majorList;
    }

    public String getSubject_category_codes() {
        return subject_category_codes;
    }

    public void setSubject_category_codes(String subject_category_codes) {
        this.subject_category_codes = subject_category_codes;
    }

    /**
     * 获取id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取年份
     */
    public int getYear() {
        return year;
    }

    /**
     * 设置年份
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * 获取学校ID
     */
    public int getSchool_id() {
        return school_id;
    }

    /**
     * 设置学校ID
     */
    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取类别(预估分/高考分)
     */
    public int getScore_type() {
        return score_type;
    }

    /**
     * 设置类别(预估分/高考分)
     */
    public void setScore_type(int score_type) {
        this.score_type = score_type;
    }

    /**
     * 获取学科类型(文科/理科)
     */
    public int getSubject_type() {
        return subject_type;
    }

    /**
     * 设置学科类型(文科/理科)
     */
    public void setSubject_type(int subject_type) {
        this.subject_type = subject_type;
    }

    /**
     * 获取批次
     */
    public int getBat() {
        return bat;
    }

    public String getBat_name() {

        return bat_name;
    }

    /**
     * 设置批次
     */
    public void setBat(int bat) {
        this.bat = bat;
    }

    /**
     * 获取位次值
     */
    public int getPrecedence() {
        return precedence;
    }

    /**
     * 设置位次值
     */
    public void setPrecedence(int precedence) {
        this.precedence = precedence;
    }

    /**
     * 获取平均分
     */
    public int getScore_avg() {
        return score_avg;
    }

    /**
     * 设置平均分
     */
    public void setScore_avg(int score_avg) {
        this.score_avg = score_avg;
    }

    /**
     * 获取同位分
     */
    public int getScore_apposition() {
        return score_apposition;
    }

    /**
     * 设置同位分
     */
    public void setScore_apposition(int score_apposition) {
        this.score_apposition = score_apposition;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLogoRealPath() {
        return logoRealPath;
    }

    public String getSprovince() {
        return sprovince;
    }

    public String getSprovince_name() {
        return sprovince_name;
    }

    public void setSprovince(String sprovince) {
        this.sprovince = sprovince;
    }

    public int getIs_join_metting() {
        return is_join_metting;
    }

    public int getScore_min() {
        return score_min;
    }

    public void setScore_min(int score_min) {
        this.score_min = score_min;
    }

    public int getRecruit_num() {
        return recruit_num;
    }

    public void setRecruit_num(int recruit_num) {
        this.recruit_num = recruit_num;
    }

    public Boolean getIs_att() {
        return is_att;
    }

    public void setIs_att(Boolean is_att) {
        this.is_att = is_att;
    }

    public Boolean getIs_reg() {
        return is_reg;
    }

    public void setIs_reg(Boolean is_reg) {
        this.is_reg = is_reg;
    }


}
