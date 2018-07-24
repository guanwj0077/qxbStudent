package com.qxb.student.common.module.bean;

/**
 * 员工信息实体类
 *
 * @author
 */
public class SysStaff {

    /**
     * 用户id
     */
    private Integer user_id;
    /**
     * 账户id
     */
    private Integer account_id;
    /**
     * 机构id
     */
    private Integer group_id;
    /**
     * 机构名称
     */
    private String group_name;
    /**
     * 机构编码
     */
    private String group_code;
    /**
     * 姓名
     */
    private String name;
    /**
     * 头像
     */
    private String pic;
    /**
     * 电话
     */
    private String phone;
    /**
     * 证件号码
     */
    private String id_num;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 简介
     */
    private String profile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 部门
     */
    private String department;
    /**
     * 职位
     */
    private String duty;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private long create_time;
    /**
     * 排序
     */
    private int show_order;
    /**
     * 创建者
     */
    private String create_user;
    /**
     * 支持省份
     */
    private String support_province;
    /**
     * 支持招生级别
     */
    private Integer support_recruit_level;
    /**
     * 组织编码
     */
    private String sys_code;
    /**
     * 支持普通招生
     */
    private Integer normal_recruit;
    /**
     * 支持自主招生
     */
    private Integer freedom_recruit;
    /**
     * 支持艺术招生
     */
    private Integer art_recruit;
    /**
     * 支持拨打电话
     */
    private Integer is_call;
    /**
     * 收款备注
     */
    private String note;

    private String province_code;

    private String provice_name;
    /**
     * 招办名称
     **/
    private String admissions_name;
    /**
     * 招办类型
     */
    private String recruit_type;

    /**
     * 留学顾问个人简历
     */
    private String resume;
    private String photoRealPath;

    public String getRecruit_type() {
        return recruit_type;
    }

    public void setRecruit_type(String recruit_type) {
        this.recruit_type = recruit_type;
    }

    public String getAdmissions_name() {
        return admissions_name;
    }

    public void setAdmissions_name(String admissions_name) {
        this.admissions_name = admissions_name;
    }

    public String getProvince_code() {
        return province_code;
    }

    public void setProvince_code(String province_code) {
        this.province_code = province_code;
    }

    public String getProvice_name() {
        return provice_name;
    }

    public void setProvice_name(String provice_name) {
        this.provice_name = provice_name;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }


    public String getGroup_code() {
        return group_code;
    }

    public void setGroup_code(String group_code) {
        this.group_code = group_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId_num() {
        return id_num;
    }

    public void setId_num(String id_num) {
        this.id_num = id_num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public int getShow_order() {
        return show_order;
    }

    public void setShow_order(int show_order) {
        this.show_order = show_order;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getSupport_province() {
        return support_province;
    }

    public void setSupport_province(String support_province) {
        this.support_province = support_province;
    }

    public String getSys_code() {
        return sys_code;
    }

    public void setSys_code(String sys_code) {
        this.sys_code = sys_code;
    }

    public Integer getSupport_recruit_level() {
        return support_recruit_level;
    }

    public void setSupport_recruit_level(Integer support_recruit_level) {
        this.support_recruit_level = support_recruit_level;
    }

    public String getPhotoRealPath() {
        return photoRealPath;
    }

    public Integer getArt_recruit() {
        return art_recruit;
    }

    public void setArt_recruit(Integer art_recruit) {
        this.art_recruit = art_recruit;
    }

    public Integer getIs_call() {
        return is_call;
    }

    public void setIs_call(Integer is_call) {
        this.is_call = is_call;
    }

    public Integer getNormal_recruit() {
        return normal_recruit;
    }

    public void setNormal_recruit(Integer normal_recruit) {
        this.normal_recruit = normal_recruit;
    }

    public Integer getFreedom_recruit() {
        return freedom_recruit;
    }

    public void setFreedom_recruit(Integer freedom_recruit) {
        this.freedom_recruit = freedom_recruit;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

}
