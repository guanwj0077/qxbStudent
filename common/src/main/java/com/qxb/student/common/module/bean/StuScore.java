package com.qxb.student.common.module.bean;

public class StuScore {

    /**
     * 学生ID
     */
    private int stu_id;
    /**
     * 分数类型ID
     */
    private int type_id;
    /**
     * 类型
     */
    private int type;
    /**
     * 分数
     */
    private int score;
    /**
     * 位次值
     */
    private int precedence;

    /**
     * 标题
     */
    private String title;

    /**
     * 开始时间结束时间
     */
    private String value;

    /**
     * 编辑状态  1、未填,2、已填,3、过期,4、暂未开放
     */
    private int edit_type;

    private String msg;
    private String descr;
    private long create_time;

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getEdit_type() {
        return edit_type;
    }

    public void setEdit_type(int edit_type) {
        this.edit_type = edit_type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public int getPrecedence() {
        return precedence;
    }

    public void setPrecedence(int precedence) {
        this.precedence = precedence;
    }

}
