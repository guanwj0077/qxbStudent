package com.qxb.student.common.module.bean;

public class SubjectCategory {

    /**
     * 学科名称
     */
    private String name;

    /**
     * 学科等级
     */
    private int degree;

    /**
     * 学校ID
     */
    private int school_id;

    /**
     * 学校名称
     */
    private String school_name;

    /**
     * 学校等级
     */
    private int school_degree;

    /**
     * 获取学科名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置学科名称
     */
    public void setName(String name) {
        this.name = name;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public int getSchool_degree() {
        return school_degree;
    }

    public void setSchool_degree(int school_degree) {
        this.school_degree = school_degree;
    }

}
