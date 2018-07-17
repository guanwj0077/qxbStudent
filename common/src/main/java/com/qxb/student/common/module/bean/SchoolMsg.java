package com.qxb.student.common.module.bean;

import java.util.Date;

public class SchoolMsg {
    /**
     * id
     */
    private int id;

    /**
     * 发送者类型
     */
    private String sender_type;

    /**
     * 学校ID
     */
    private int school_id;
    /**
     * 学校名称
     */
    private String school_name;
    /**
     * 学生ID
     */
    private int stu_id;
    /**
     * 学生名称
     */
    private String stu_name;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 发送时间
     */
    private Date createtime;
    /**
     * 已读未读
     **/
    private int is_read = 0;

    /**
     * 标题
     **/
    private String title;

    /**
     * 学校LOGO
     */
    private String logo;

    /**
     * 标签
     */
    private String tag;

    /**
     * 机构地址
     */
    private String address;
    private String createtimeString;
    private String logoRealPath;

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

    public String getSender_type() {
        return sender_type;
    }

    public void setSender_type(String sender_type) {
        this.sender_type = sender_type;
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
     * 获取学生ID
     */
    public int getStu_id() {
        return stu_id;
    }

    /**
     * 设置学生ID
     */
    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    /**
     * 获取学生名称
     */
    public String getStu_name() {
        return stu_name;
    }

    /**
     * 设置学生名称
     */
    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    /**
     * 获取消息内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置消息内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取发送时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 获取发送时间
     */
    public String getCreatetimeString() {
        return createtimeString;
    }

    /**
     * 设置发送时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getIs_read() {
        return is_read;
    }

    public void setIs_read(int is_read) {
        this.is_read = is_read;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLogoRealPath() {
        return logoRealPath;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
