package com.qxb.student.common.module.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 组织信息实体类
 *
 * @author
 */
public class SysGroup {

    private int id;
    /**
     * 所属组织ID
     */
    private int pid;
    /**
     * 所属组织名称
     */
    private String pname;
    /**
     * 组织名称
     */
    private String name;
    /**
     * 组织类型1、org_01_01:艺考机构。org_01_02：法国直通车。org_01_03：职业技能。org_01_04：出国留学。
     */
    private String type;
    /**
     * 组织简介
     */
    private String summary;
    /**
     * 组织网址
     */
    private String website;
    /**
     * 创建时间
     */
    private Date create_time;
    /**
     * 系统编码
     */
    private String sys_code;
    /**
     * 显示排序
     */
    private int show_order;
    /**
     * LOGO
     */
    private String logo;
    /**
     * 背景图
     */
    private String image_bg;
    /**
     * 组织编码
     */
    private String group_code;
    /**
     * 省份编码
     */
    private String province_code;
    /**
     * 省份名称
     */
    private String province_name;
    /**
     * 市编码
     */
    private String city_code;
    /**
     * 市名称
     */
    private String city_name;
    /**
     * 区编码
     */
    private String area_code;
    /**
     * 区名称
     */
    private String area_name;
    /**
     * 状态
     */
    private int status;

    /**
     * 入驻时间
     */
    private String sign_time;

    /**
     * 入驻状态1:正常，2：作废
     */
    private int sign_status;

    /**
     * app显示名称
     */
    private String app_showname;

    /**
     * 机构后台显示名称
     */
    private String edu_showname;

    /**
     * 机构地址
     */
    private String address;

    /**
     * 机构电话
     */
    private String phone;

    /**
     * 是否优秀机构  1.优秀，0非优秀
     **/
    private int is_good;

    /**
     * 机构专业方向
     **/
    private String category_code;

    /**
     * 收藏次数
     **/
    private int praise;

    /**
     * 是否已经点赞
     **/
    private int is_praise;

    /**
     * 推送消息条数
     **/
    private int balance = 0;

    /**
     * 用户id
     */
    private int user_id;
    /**
     * 登录名称
     */
    private String login_name;

    /**
     * 留学 服务类型 1境内服务 2境外服务 3全程服务  4境内外服务
     **/
    private int serve_type;
    /**
     * 留学 服务区域
     **/
    private String serve_area;
    /**
     * 留学机构资质证明
     **/
    private String credentials;
    /**
     * 留学机构擅长服务
     **/
    private String good_at_service;
    /**
     * 会员等级 0：普通会员 1：VIP会员 2：超级VIP会员
     */
    private int level;
    /**
     * 非数据库字段
     */
    /**
     * 已完成订单数 （已服务人数）
     **/
    private int order_num;
    /**
     * 综合评分
     **/
    private double average;
    /**
     * 5分好评人数
     **/
    private int good_num;
    /**
     * 是否平台认证 1是 2否
     **/
    private int is_platform;
    /**
     * 是否关注 1是 2否
     **/
    private int is_attention;
    /**
     * 机构下的员工顾问列表
     **/
    private List<AbroadStaffInfo> memberList;
    private String imageBgRealPath;
    private String serve_area_name;
    private Map<String, String> good_at_service_name;
    private String credentialsUrl;
    private String logoRealPath;
    private String serve_type_name;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getSys_code() {
        return sys_code;
    }

    public void setSys_code(String sys_code) {
        this.sys_code = sys_code;
    }

    public int getShow_order() {
        return show_order;
    }

    public void setShow_order(int show_order) {
        this.show_order = show_order;
    }

    public String getLogo() {
        return logo;
    }

    public String getLogoRealPath() {
        return logoRealPath;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getImage_bg() {
        return image_bg;
    }

    public String getImageBgRealPath() {
        return imageBgRealPath;
    }

    public void setImage_bg(String image_bg) {
        this.image_bg = image_bg;
    }

    public String getGroup_code() {
        return group_code;
    }

    public void setGroup_code(String group_code) {
        this.group_code = group_code;
    }

    public String getProvince_code() {
        return province_code;
    }

    public void setProvince_code(String province_code) {
        this.province_code = province_code;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSign_time() {
        return sign_time;
    }

    public void setSign_time(String sign_time) {
        this.sign_time = sign_time;
    }

    public int getSign_status() {
        return sign_status;
    }

    public void setSign_status(int sign_status) {
        this.sign_status = sign_status;
    }

    public String getApp_showname() {
        return app_showname;
    }

    public void setApp_showname(String app_showname) {
        this.app_showname = app_showname;
    }

    public String getEdu_showname() {
        return edu_showname;
    }

    public void setEdu_showname(String edu_showname) {
        this.edu_showname = edu_showname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIs_good() {
        return is_good;
    }

    public void setIs_good(int is_good) {
        this.is_good = is_good;
    }

    public String getCategory_code() {
        return category_code;
    }

    public void setCategory_code(String category_code) {
        this.category_code = category_code;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public int getIs_praise() {
        return is_praise;
    }

    public void setIs_praise(int is_praise) {
        this.is_praise = is_praise;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public int getServe_type() {
        return serve_type;
    }

    public void setServe_type(int serve_type) {
        this.serve_type = serve_type;
    }

    public int getOrder_num() {
        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getGood_num() {
        return good_num;
    }

    public void setGood_num(int good_num) {
        this.good_num = good_num;
    }

    public int getIs_platform() {
        return is_platform;
    }

    public void setIs_platform(int is_platform) {
        this.is_platform = is_platform;
    }

    public String getServe_area() {
        return serve_area;
    }

    public void setServe_area(String serve_area) {
        this.serve_area = serve_area;
    }

    /**
     * 获取服务区域文本
     *
     * @return 例：美国,英国
     */
    public String getServe_area_name() {
        return serve_area_name;
    }

    /**
     * 获取境内外服务的文本
     *
     * @return 例：境外服务
     */
    public String getServe_type_name() {
        return serve_type_name;
    }

    /**
     * 获取擅长服务的文本
     */
    public Map<String, String> getGood_at_service_name() {
        return good_at_service_name;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public List<AbroadStaffInfo> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<AbroadStaffInfo> memberList) {
        this.memberList = memberList;
    }

    public String getGood_at_service() {
        return good_at_service;
    }

    public void setGood_at_service(String good_at_service) {
        this.good_at_service = good_at_service;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getIs_attention() {
        return is_attention;
    }

    public void setIs_attention(int is_attention) {
        this.is_attention = is_attention;
    }

    public String getCredentialsUrl() {
        return credentialsUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImageBgRealPath(String imageBgRealPath) {
        this.imageBgRealPath = imageBgRealPath;
    }

    public void setServe_area_name(String serve_area_name) {
        this.serve_area_name = serve_area_name;
    }

    public void setGood_at_service_name(Map<String, String> good_at_service_name) {
        this.good_at_service_name = good_at_service_name;
    }

    public void setCredentialsUrl(String credentialsUrl) {
        this.credentialsUrl = credentialsUrl;
    }

    public void setLogoRealPath(String logoRealPath) {
        this.logoRealPath = logoRealPath;
    }

    public void setServe_type_name(String serve_type_name) {
        this.serve_type_name = serve_type_name;
    }
}
