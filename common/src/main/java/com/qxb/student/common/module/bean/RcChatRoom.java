package com.qxb.student.common.module.bean;


/**
 * @author
 */
public class RcChatRoom {

    private int id;

    /**
     * status 1.审核中 2.未开始 3.进行中 4.已完成 5.不同意 6. 回看
     */
    private int status;
    /**
     * 创建时间
     */
    private long create_time;
    /**
     * 直播开启时间
     */
    private long live_start_time;
    /**
     * 直播结束时间
     */
    private long live_end_time;
    /**
     * 直播主题
     */
    private String name;
    /**
     * 简介
     */
    private String intro;

    /**
     * 直播人ID
     */
    private int item_id;
    /**
     * 直播人名称
     */
    private String item_name;
    /**
     * 角色类型
     */
    private String service_id;
    /**
     * 助教ID 客服
     */
    private int assistant_id;
    /**
     * 封面
     */
    private String cover_img;
    /**
     * 预计时长
     */
    private double expect_time_length;
    /**
     * 所属组织名称
     */
    private String group_name;

    /**
     * 所属组织id
     */
    private int group_id;

    /**
     * 是否全员禁言
     */
    private int is_banned;
    /**
     * 助教名称
     */
    private String assistant_name;
    /**
     * 不通过原因
     */
    private String reason;
    private int people_count;
    /**
     * 直播人数
     */
    private int live_count;
    /**
     * 是否订阅
     */
    private int is_subscriber;

    /**
     * 直播老师ID(兼容老版本)
     */
    private int teacher_id;
    /**
     * 直播学校ID(兼容老版本)
     */
    private int school_id;
    /**
     * 老师名称(兼容老版本)
     */
    private String teacher_name;
    /**
     * 学校名称(兼容老版本)
     */
    private String school_name;

    /**
     * 订阅人数
     */
    private int subscibe_number;
    /**
     * 封面图片Url
     */
    private String coverImgRealPath;

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public int getLive_count() {
        return live_count;
    }

    public void setLive_count(int live_count) {
        this.live_count = live_count;
    }

    public int getIs_banned() {
        return is_banned;
    }

    public void setIs_banned(int is_banned) {
        this.is_banned = is_banned;
    }

    public double getExpect_time_length() {
        return expect_time_length;
    }

    public void setExpect_time_length(double expect_time_length) {
        this.expect_time_length = expect_time_length;
    }

    public int getIs_subscriber() {
        return is_subscriber;
    }

    public void setIs_subscriber(int is_subscriber) {
        this.is_subscriber = is_subscriber;
    }

    public int getPeople_count() {
        return people_count;
    }

    public void setPeople_count(int people_count) {
        this.people_count = people_count;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAssistant_name() {
        return assistant_name;
    }

    public void setAssistant_name(String assistant_name) {
        this.assistant_name = assistant_name;
    }

    public String getCoverImgRealPath() {
        return coverImgRealPath;
    }


    public int getAssistant_id() {
        return assistant_id;
    }

    public void setAssistant_id(int assistant_id) {
        this.assistant_id = assistant_id;
    }

    public String getCover_img() {
        return cover_img;
    }

    public void setCover_img(String cover_img) {
        this.cover_img = cover_img;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setLive_start_time(long live_start_time) {
        this.live_start_time = live_start_time;
    }

    public long getLive_start_time() {
        return live_start_time;
    }

    public void setLive_end_time(long live_end_time) {
        this.live_end_time = live_end_time;
    }

    public long getLive_end_time() {
        return live_end_time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getIntro() {
        return intro;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public int getSubscibe_number() {
        return subscibe_number;
    }

    public void setSubscibe_number(int subscibe_number) {
        this.subscibe_number = subscibe_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCoverImgRealPath(String coverImgRealPath) {
        this.coverImgRealPath = coverImgRealPath;
    }
}
