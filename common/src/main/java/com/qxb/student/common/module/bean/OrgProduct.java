package com.qxb.student.common.module.bean;

public class OrgProduct {
    private String title;
    private String image;
    private String keywords;
    private String summary;
    private String tags;
    private int type;
    private int status;
    private String publish_time;
    private String remark;
    private long create_time;
    private long uplong_time;
    private int show_order;
    private int scan_num;
    private int regist_num;
    private String create_user;
    private int owner_id;
    private String owner_type;
    private String owner_name;
    private String content;
    /**
     * 项目有效截止时间
     */
    private int deadline;
    private String imageRealPath;


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageRealPath() {
        return imageRealPath;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPublish_time() {
        return this.publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public long getCreate_time() {
        return this.create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public long getUplong_time() {
        return this.uplong_time;
    }

    public void setUplong_time(long uplong_time) {
        this.uplong_time = uplong_time;
    }

    public int getShow_order() {
        return this.show_order;
    }

    public void setShow_order(int show_order) {
        this.show_order = show_order;
    }

    public int getScan_num() {
        return this.scan_num;
    }

    public void setScan_num(int scan_num) {
        this.scan_num = scan_num;
    }

    public int getRegist_num() {
        return this.regist_num;
    }

    public void setRegist_num(int regist_num) {
        this.regist_num = regist_num;
    }

    public String getCreate_user() {
        return this.create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public int getOwner_id() {
        return this.owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getOwner_type() {
        return this.owner_type;
    }

    public void setOwner_type(String owner_type) {
        this.owner_type = owner_type;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOwner_name() {
        return this.owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

}