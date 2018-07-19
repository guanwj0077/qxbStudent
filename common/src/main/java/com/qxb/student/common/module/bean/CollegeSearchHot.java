package com.qxb.student.common.module.bean;

/**
 * 热门学校
 *
 * @author
 */
public class CollegeSearchHot {
    /**
     * 学校Id
     **/
    private int school_id;
    /**
     * 排序字段
     **/
    private int show_order;
    /**
     * 是否热门  1 是 2否
     **/
    private int status;
    /**
     * 是否自招热门 1 是 2否
     **/
    private int freedom_recruit_status;
    /**
     * 自招排序
     **/
    private int freedom_recruit_order;
    /**
     * 学校名称
     **/
    private String school_name;
    /**
     * 学校logo
     **/
    private String logo;
    /**
     * 学校logo实际路径
     **/
    private String logoRealPath;
    /**
     * 学校标签
     **/
    private String tag;

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public int getShow_order() {
        return show_order;
    }

    public void setShow_order(int show_order) {
        this.show_order = show_order;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSchool_name() {
        return school_name;
    }

    public String getLogo() {
        return logo;
    }

    public String getLogoRealPath() {
        return logoRealPath;
    }

    public String getTag() {
        return tag;
    }

    public int getFreedom_recruit_status() {
        return freedom_recruit_status;
    }

    public void setFreedom_recruit_status(int freedom_recruit_status) {
        this.freedom_recruit_status = freedom_recruit_status;
    }

    public int getFreedom_recruit_order() {
        return freedom_recruit_order;
    }

    public void setFreedom_recruit_order(int freedom_recruit_order) {
        this.freedom_recruit_order = freedom_recruit_order;
    }

}
