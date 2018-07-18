package com.qxb.student.common.module.bean;

/**
 * 参会院校类
 * @author
 */
public class CollegeMetting {
    /**
     * 学校ID
     */
    private int school_id;
    /**
     * 是否热门
     */
    private int is_hot;
    /**
     * 热门院校显示序号
     */
    private int hot_order;
    /**
     * 是否专科
     */
    private int is_zk;
    /**
     * 是否本科
     */
    private int is_bk;
    /**
     * 合作院校排序权重
     */
    private int show_order;


    /**
     * 以下字段查询使用
     */
    /**
     * 学校LOGO
     */
    private String logo;
    /**
     * 学校名称
     */
    private String school_name;
    /**
     * 标签
     */
    private String tag;
    /**
     * 省
     */
    private String province;

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public int getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(int is_hot) {
        this.is_hot = is_hot;
    }

    public int getHot_order() {
        return hot_order;
    }

    public void setHot_order(int hot_order) {
        this.hot_order = hot_order;
    }

    public int getIs_zk() {
        return is_zk;
    }

    public void setIs_zk(int is_zk) {
        this.is_zk = is_zk;
    }

    public int getIs_bk() {
        return is_bk;
    }

    public void setIs_bk(int is_bk) {
        this.is_bk = is_bk;
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

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }


}
