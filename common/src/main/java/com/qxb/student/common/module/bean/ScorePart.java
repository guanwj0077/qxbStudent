package com.qxb.student.common.module.bean;

public class ScorePart {
    /**
     * id
     */
    private int id;

    /**
     * 年份
     */
    private int year;

    /**
     * 省份
     */
    private String province;
    private String province_name;

    /**
     * 类别(1文科/2理科)
     */
    private int type;

    /**
     * 分值
     */
    private int score;

    /**
     * 人数
     */
    private int num;

    /**
     * 累计人数
     */
    private int total;

    /**
     * 备注
     */
    private String note;


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
     * 获取年份
     */
    public int getYear() {
        return year;
    }

    /**
     * 设置年份
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * 获取省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取类别(1文科/2理科)
     */
    public int getType() {
        return type;
    }

    /**
     * 设置类别(1文科/2理科)
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * 获取分值
     */
    public int getScore() {
        return score;
    }

    /**
     * 设置分值
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * 获取人数
     */
    public int getNum() {
        return num;
    }

    /**
     * 设置人数
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * 获取累计人数
     */
    public int getTotal() {
        return total;
    }

    /**
     * 设置累计人数
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * 获取备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置备注
     */
    public void setNote(String note) {
        this.note = note;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }


}
