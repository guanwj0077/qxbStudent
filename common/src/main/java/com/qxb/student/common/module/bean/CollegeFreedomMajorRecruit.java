package com.qxb.student.common.module.bean;

/**
 * 自招在招专业
 *
 * @author
 */
public class CollegeFreedomMajorRecruit {

    /**
     * 学校ID
     **/
    private int school_id;
    /**
     * 学校名称
     **/
    private String school_name;
    /**
     * 招生省份
     **/
    private String province;
    /**
     * 专业ID
     **/
    private int major_id;
    /**
     * 专业名称
     **/
    private String major_name;
    /**
     * 专业类别（本专）
     **/
    private int major_type;
    /**
     * 科目类别（文理）
     **/
    private int subject_type;
    /**
     * 招生人数
     **/
    private int recruit_num;
    /**
     * 招生年份
     **/
    private int year;
    /**
     * 学科大类
     **/
    private String category_code;
    /**
     * 计划id
     **/
    private int plan_id;
    /**
     * 备注
     **/
    private String remark;
    /**
     * 科目要求
     **/
    private String subject_requirements;

    /**
     * 非表字段
     **/
    /**
     * 学校所在省份
     */
    private String school_province_name;
    /**
     * 学科大类
     */
    private String subject_name;
    /**
     * 学科门类
     */
    private String psubject_name;
    /**
     * 专业介绍
     */
    private String summary;
    /**
     * 计划名称
     */
    private String plan_name;
    /**
     * 学校封面图片
     */
    private String front_cover;
    /**
     * 学校封面图片完整url
     */
    private String coverRealPath;


    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getMajor_id() {
        return major_id;
    }

    public void setMajor_id(int major_id) {
        this.major_id = major_id;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    public int getMajor_type() {
        return major_type;
    }

    public void setMajor_type(int major_type) {
        this.major_type = major_type;
    }

    public int getSubject_type() {
        return subject_type;
    }

    public void setSubject_type(int subject_type) {
        this.subject_type = subject_type;
    }

    public int getRecruit_num() {
        return recruit_num;
    }

    public void setRecruit_num(int recruit_num) {
        this.recruit_num = recruit_num;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCategory_code() {
        return category_code;
    }

    public void setCategory_code(String category_code) {
        this.category_code = category_code;
    }

    public String getRemark() {
        return remark;
    }

    public String getSubject_requirements() {
        return subject_requirements;
    }

    public void setSubject_requirements(String subject_requirements) {
        this.subject_requirements = subject_requirements;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSchool_province_name() {
        return school_province_name;
    }

    public void setSchool_province_name(String school_province_name) {
        this.school_province_name = school_province_name;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getPsubject_name() {
        return psubject_name;
    }

    public void setPsubject_name(String psubject_name) {
        this.psubject_name = psubject_name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    public String getPlan_name() {
        return plan_name;
    }

    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
    }

    public String getFront_cover() {
        return front_cover;
    }

    public String getCoverRealPath() {
        return coverRealPath;
    }

    public void setFront_cover(String front_cover) {
        this.front_cover = front_cover;
    }

}
