package com.qxb.student.common.module.bean;

public class LiuxueMajor {

    /**
     * 专业编码
     */
    private String code;
    private int depth;
    private int id;
    private int isClose;
    /**
     * 专业名称
     */
    private String name;
    private String parent_code;
    /**
     * 招生人数
     */
    private int recruit_num;
    private String state;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsClose() {
        return isClose;
    }

    public void setIsClose(int isClose) {
        this.isClose = isClose;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent_code() {
        return parent_code;
    }

    public void setParent_code(String parent_code) {
        this.parent_code = parent_code;
    }

    public int getRecruit_num() {
        return recruit_num;
    }

    public void setRecruit_num(int recruit_num) {
        this.recruit_num = recruit_num;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
