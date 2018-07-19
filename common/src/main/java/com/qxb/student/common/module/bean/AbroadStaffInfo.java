package com.qxb.student.common.module.bean;


import java.util.Map;


/**
 * 留学 机构员工 个人顾问 拓展信息
 *
 * @author
 */
public class AbroadStaffInfo {

    private int id;

    /**
     * 服务类型 1境内服务 2境外服务 3全程服务
     **/
    private int serve_type;
    /**
     * t_sys_staff 表id
     **/
    private int staff_id;
    /**
     * t_sys_group 表id
     **/
    private int group_id;
    /**
     * 服务区域
     **/
    private String serve_area;
    /**
     * 学位
     **/
    private String degree;
    /**
     * 擅长服务
     **/
    private String good_at_service;
    /**
     * 擅长专业
     **/
    private String good_at_professional;
    /**
     * 自述
     **/
    private String readme;
    /**
     * 所在省
     **/
    private String province_code;
    /**
     * 所在市
     **/
    private String city_code;
    /**
     * 所在区
     **/
    private String area_code;

    /**
     * 非表字段
     */
    /**
     * 类型
     **/
    private int type;
    /**
     * 机构名称
     **/
    private String group_name;
    /**
     * 是否平台认证
     **/
    private int is_platform;
    /**
     * 头像
     **/
    private String pic;
    /**
     * 顾问名称
     **/
    private String name;
    /**
     * 已完成订单数 （已服务人数）
     **/
    private int order_num;
    /**
     * 综合评分
     **/
    private double average;
    private String province_name;
    private String serve_area_name;
    private Map<String, String> good_at_service_name;
    private String picRealPath;
    private String serve_type_name;


    public void setServe_type(int serve_type) {
        this.serve_type = serve_type;
    }

    public int getServe_type() {
        return serve_type;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setServe_area(String serve_area) {
        this.serve_area = serve_area;
    }

    public String getServe_area() {
        return serve_area;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }

    public void setGood_at_service(String good_at_service) {
        this.good_at_service = good_at_service;
    }

    public String getGood_at_service() {
        return good_at_service;
    }

    public void setGood_at_professional(String good_at_professional) {
        this.good_at_professional = good_at_professional;
    }

    public String getGood_at_professional() {
        return good_at_professional;
    }

    public void setReadme(String readme) {
        this.readme = readme;
    }

    public String getReadme() {
        return readme;
    }

    public void setProvince_code(String province_code) {
        this.province_code = province_code;
    }

    public String getProvince_code() {
        return province_code;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public String getArea_code() {
        return area_code;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
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
     * 获取服务区域文本
     *
     * @return 例：美国,英国
     */
    public String getServe_area_name() {

        return serve_area_name;
    }

    /**
     * 获取擅长服务的文本
     */
    public Map<String, String> getGood_at_service_name() {

        return good_at_service_name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public int getIs_platform() {
        return is_platform;
    }

    public void setIs_platform(int is_platform) {
        this.is_platform = is_platform;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPicRealPath() {
        return picRealPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public void setServe_area_name(String serve_area_name) {
        this.serve_area_name = serve_area_name;
    }

    public void setGood_at_service_name(Map<String, String> good_at_service_name) {
        this.good_at_service_name = good_at_service_name;
    }

    public void setPicRealPath(String picRealPath) {
        this.picRealPath = picRealPath;
    }

    public void setServe_type_name(String serve_type_name) {
        this.serve_type_name = serve_type_name;
    }
}
