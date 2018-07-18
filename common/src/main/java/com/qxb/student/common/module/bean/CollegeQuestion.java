package com.qxb.student.common.module.bean;

public class CollegeQuestion {

    /**
     * 大学id
     */
    private int school_id;
    /**
     * 常见问题标题
     */
    private String title;
    /**
     * 常见问题标签
     */
    private String tags;
    /**
     * 常见问题答案
     */
    private String content;
    /**
     * 常见问题展示顺序
     */
    private int show_order;
    /**
     * 浏览量
     */
    private int scan_num;
    /**
     * 好评
     */
    private int good_num;
    /**
     * 差评
     */
    private int neg_num;
    /**
     * 创建时间
     */
    private Long create_time;
    /**
     * 大学名称
     */
    private String school_name;
    /**
     * 问题内容标志
     */
    private String content_tag;
    /**
     * 常见问题所属招生类型
     */
    private int enroll_type;
    private String create_timeString;

    public String getContent_tag() {
        return content_tag;
    }

    public void setContent_tag(String content_tag) {
        this.content_tag = content_tag;
    }

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getShow_order() {
        return show_order;
    }

    public void setShow_order(int show_order) {
        this.show_order = show_order;
    }

    public int getScan_num() {
        return scan_num;
    }

    public void setScan_num(int scan_num) {
        this.scan_num = scan_num;
    }

    public int getGood_num() {
        return good_num;
    }

    public void setGood_num(int good_num) {
        this.good_num = good_num;
    }

    public int getNeg_num() {
        return neg_num;
    }

    public void setNeg_num(int neg_num) {
        this.neg_num = neg_num;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public String getCreate_timeString() {
        return create_timeString;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public int getEnroll_type() {
        return enroll_type;
    }

    public void setEnroll_type(int enroll_type) {
        this.enroll_type = enroll_type;
    }
}
