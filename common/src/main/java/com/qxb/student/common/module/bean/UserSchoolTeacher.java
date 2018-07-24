package com.qxb.student.common.module.bean;

public class UserSchoolTeacher {

    /**
     * id
     */
    private int id;

    /**
     * 头像
     */
    private String pic;

    /**
     * 用户类型(学校/老师)
     */
    private int user_type;

    /**
     * 学校ID
     */
    private int school_id;

    /**
     * 学校名称
     */
    private String school_name;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 创建人
     */
    private int create_user;

    /**
     * 创建人姓名
     */
    private String create_user_name;

    /**
     * 创建时间
     */
    private long create_time;

    /**
     * 登录时间
     */
    private long login_time;

    /**
     * 登录次数
     */
    private int login_number;

    /**
     * 登录地址
     */
    private String login_addr;

    /**
     * 登录IP
     */
    private String login_ip;

    /**
     * 状态
     */
    private int status;

    /**
     * 在线时长
     */
    private double online_time;

    /**
     * 部门
     */
    private String department;

    /**
     * 职务
     */
    private String duty;

    private String tonken;

    /**
     * 省份编码
     */
    private String province_code;

    /**
     * 省份名称
     */
    private String province_name;

    /**
     * 账户ID
     */
    private int account_id;

    /**
     * 回复次数
     */
    private int chat_times;

    /**
     * 是否有常见问题
     */
    private int have_question;

    /**
     * 院校VIP级别
     */
    private int level;

    /**
     * 0：国内老师 1：国外老师
     */
    private int is_abroad;
    private String picRealPath;
    private String create_timeString;

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


    public String getProvince_code() {
        return province_code;
    }

    public void setProvince_code(String province_code) {
        this.province_code = province_code;
    }

    public String getPic() {
        return pic;
    }

    public String getPicRealPath() {
        return picRealPath;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * 获取用户类型(学校/老师)
     */
    public int getUser_type() {
        return user_type;
    }

    /**
     * 设置用户类型(学校/老师)
     */
    public void setUser_type(int user_type) {
        this.user_type = user_type;
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
     * 获取姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
     * 设置登录时间
     */
    public void setLogin_time(long login_time) {
        this.login_time = login_time;
    }

    /**
     * 获取登录次数
     */
    public int getLogin_number() {
        return login_number;
    }

    /**
     * 设置登录次数
     */
    public void setLogin_number(int login_number) {
        this.login_number = login_number;
    }

    /**
     * 获取登录地址
     */
    public String getLogin_addr() {
        return login_addr;
    }

    /**
     * 设置登录地址
     */
    public void setLogin_addr(String login_addr) {
        this.login_addr = login_addr;
    }

    /**
     * 获取登录IP
     */
    public String getLogin_ip() {
        return login_ip;
    }

    /**
     * 设置登录IP
     */
    public void setLogin_ip(String login_ip) {
        this.login_ip = login_ip;
    }

    /**
     * 获取状态
     */
    public int getStatus() {
        return status;
    }

    /**
     * 设置状态
     */
    public void setStatus(int status) {
        this.status = status;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getCreate_user_name() {
        return create_user_name;
    }

    public void setCreate_user_name(String create_user_name) {
        this.create_user_name = create_user_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getTonken() {
        return tonken;
    }

    public void setTonken(String tonken) {
        this.tonken = tonken;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getChat_times() {
        return chat_times;
    }

    public void setChat_times(int chat_times) {
        this.chat_times = chat_times;
    }

    public int getHave_question() {
        return have_question;
    }

    public void setHave_question(int have_question) {
        this.have_question = have_question;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getIs_abroad() {
        return is_abroad;
    }

    public void setIs_abroad(int is_abroad) {
        this.is_abroad = is_abroad;
    }

}
