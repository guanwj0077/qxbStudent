package com.qxb.student.common.module.bean;

public class BaseNotic {
    /**
     * id
     */
    private int id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private long create_time;

    /**
     * 创建人
     */
    private int create_user;
    private String create_user_name;

    /**
     * 已读未读
     **/
    private int is_read = 0;

    /**
     * 关联类型school_baseinfo学校，t_sys_group机构
     */
    private String connect_type;

    /**
     * 关联ID
     */
    private int connect_id;

    /**
     * 关联名称
     */
    private String connect_name;

    /**
     * 学生端是否显示1:显示，2：不显示
     */
    private int show_stu;

    /**
     * 学生端是否显示1:显示，2：不显示
     */
    private int show_tea;

    /**
     * 政务通是否显示1:显示，2：不显示
     */
    private int show_admissions;
    private String create_timeString;
    private String share_pic;
    private String share_url;

    public int getShow_admissions() {
        return show_admissions;
    }

    public void setShow_admissions(int show_admissions) {
        this.show_admissions = show_admissions;
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
     * 获取标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取创建时间
     */
    public long getCreate_time() {
        return create_time;
    }

    public String getCreate_timeString() {
        return create_timeString;
    }

    /**
     * 设置创建时间
     */
    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    /**
     * 获取创建人
     */
    public int getCreate_user() {
        return create_user;
    }

    /**
     * 设置创建人
     */
    public void setCreate_user(int create_user) {
        this.create_user = create_user;
    }

    public String getCreate_user_name() {
        return create_user_name;
    }

    public void setCreate_user_name(String create_user_name) {
        this.create_user_name = create_user_name;
    }

    public int getIs_read() {
        return is_read;
    }

    public void setIs_read(int is_read) {
        this.is_read = is_read;
    }

    //分享图片
    public String getShare_pic() {
        return share_pic;
    }

    //分享地址
    public String getShare_url() {
        return share_url;
    }

    public String getConnect_type() {
        return connect_type;
    }

    public void setConnect_type(String connect_type) {
        this.connect_type = connect_type;
    }

    public int getConnect_id() {
        return connect_id;
    }

    public void setConnect_id(int connect_id) {
        this.connect_id = connect_id;
    }

    public String getConnect_name() {
        return connect_name;
    }

    public void setConnect_name(String connect_name) {
        this.connect_name = connect_name;
    }

    public int getShow_stu() {
        return show_stu;
    }

    public void setShow_stu(int show_stu) {
        this.show_stu = show_stu;
    }

    public int getShow_tea() {
        return show_tea;
    }

    public void setShow_tea(int show_tea) {
        this.show_tea = show_tea;
    }

}
