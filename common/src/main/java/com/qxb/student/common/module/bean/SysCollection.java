package com.qxb.student.common.module.bean;

/**
 * 收藏实体类
 * @author
 */
public class SysCollection {

    /**
     * 收藏对象ID
     **/
    private int item_id;
    /**
     * 收藏对象的名称
     **/
    private String item_name;
    /**
     * 收藏对象类型
     **/
    private int item_type;
    /**
     * 学生ID
     **/
    private int stu_id;
    /**
     * 收藏时间
     **/
    private long create_time;
    /**
     * 学生姓名
     **/
    private String stu_name;
    /**
     * 省份名称
     **/
    private String province_name;
    /**
     * 城市名称
     **/
    private String city_name;
    /**
     * 地区名称
     **/
    private String area_name;
    /**
     * 省份编码
     **/
    private int province_code;
    /**
     * 城市编码
     **/
    private int city_code;
    /**
     * 地区编码
     **/
    private int area_code;
    /**
     * 学生所在的高中
     **/
    private String highschool_name;


    /**
     * 临时字段  父级学科门类
     **/
    private String p_subject_name;
    /**
     * 临时字段  学科门类
     **/
    private String subject_name;

    /**
     * 学生预估分
     **/
    private int yugufen;
    /**
     * 学生高考分
     **/
    private int gaokaofen;

    /**
     * 学校英文名称
     */
    private String english_name;

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getItem_type() {
        return item_type;
    }

    public void setItem_type(int item_type) {
        this.item_type = item_type;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getP_subject_name() {
        return p_subject_name;
    }

    public void setP_subject_name(String p_subject_name) {
        this.p_subject_name = p_subject_name;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
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

    public int getProvince_code() {
        return province_code;
    }

    public void setProvince_code(int province_code) {
        this.province_code = province_code;
    }

    public int getCity_code() {
        return city_code;
    }

    public void setCity_code(int city_code) {
        this.city_code = city_code;
    }

    public int getArea_code() {
        return area_code;
    }

    public void setArea_code(int area_code) {
        this.area_code = area_code;
    }

    public String getHighschool_name() {
        return highschool_name;
    }

    public void setHighschool_name(String highschool_name) {
        this.highschool_name = highschool_name;
    }

    public int getYugufen() {
        return yugufen;
    }

    public void setYugufen(int yugufen) {
        this.yugufen = yugufen;
    }

    public int getGaokaofen() {
        return gaokaofen;
    }

    public void setGaokaofen(int gaokaofen) {
        this.gaokaofen = gaokaofen;
    }

    public String getEnglish_name() {
        return english_name;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
    }


}
