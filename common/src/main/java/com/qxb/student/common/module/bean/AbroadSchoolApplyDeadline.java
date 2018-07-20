package com.qxb.student.common.module.bean;

/**
 * 留学学校申请时间
 * @author qianle
 */
public class AbroadSchoolApplyDeadline {

    private int id;
    /**学校id*/
    private int school_id;
    /**类型 1：本科 2：研究生 3：艺术生*/
    private int type;
    /**申请截止时间*/
    private String deadline;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
