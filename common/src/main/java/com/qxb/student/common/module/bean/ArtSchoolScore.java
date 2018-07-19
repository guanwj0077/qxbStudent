package com.qxb.student.common.module.bean;

/**
 * 艺考历年分数
 *
 * @author
 */
public class ArtSchoolScore {

    /**
     * 学校id
     **/
    private int school_id;
    /**
     * 专业大类code
     **/
    private String art_category_code;
    /**
     * 年份
     **/
    private int year;
    /**
     * 省份
     **/
    private String province;
    /**
     * 文化分
     **/
    private int culture_score;
    /**
     * 专业分
     **/
    private int major_score;
    /**
     * 综合分
     **/
    private int synthetic_score;
    /**
     * 是否需要校考
     **/
    private int is_exam;
    /**
     * 智能分
     **/
    private int smart_score;
    /**
     * 学校名称
     */
    private String school_name;
    /**
     * 省份名称
     */
    private String province_name;


    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public String getArt_category_code() {
        return art_category_code;
    }

    public void setArt_category_code(String art_category_code) {
        this.art_category_code = art_category_code;
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

    public int getCulture_score() {
        return culture_score;
    }

    public void setCulture_score(int culture_score) {
        this.culture_score = culture_score;
    }

    public int getMajor_score() {
        return major_score;
    }

    public void setMajor_score(int major_score) {
        this.major_score = major_score;
    }

    public int getIs_exam() {
        return is_exam;
    }

    public void setIs_exam(int is_exam) {
        this.is_exam = is_exam;
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

    public int getSynthetic_score() {
        return synthetic_score;
    }

    public void setSynthetic_score(int synthetic_score) {
        this.synthetic_score = synthetic_score;
    }

    public int getSmart_score() {
        return smart_score;
    }

    public void setSmart_score(int smart_score) {
        this.smart_score = smart_score;
    }

}
