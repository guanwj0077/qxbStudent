package com.qxb.student.common.module.bean;

import java.util.List;

/**
 * 奖项实体（自主招生）
 *
 * @author hs011
 */
public class Award {

    private int id;
    /**
     * 奖项编码
     **/
    private String award_code;
    /**
     * 奖项名称
     **/
    private String award_name;
    /**
     * 上级奖项编码
     **/
    private String parent_code;
    /**
     * 层级
     **/
    private int depth;
    /**
     * 奖项简介
     **/
    private String award_summary;
    /**
     * 默认关闭节点
     */
    private String state = "closed";
    private List<Award> children;

    private String text;
    /**
     * 自找院校奖项查询需要判断是否有相关院校
     **/
    private boolean hava = true;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAward_code() {
        return award_code;
    }

    public void setAward_code(String award_code) {
        this.award_code = award_code;
    }

    public String getAward_name() {
        return award_name;
    }

    public void setAward_name(String award_name) {
        this.award_name = award_name;
    }

    public String getParent_code() {
        return parent_code;
    }

    public void setParent_code(String parent_code) {
        this.parent_code = parent_code;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getAward_summary() {
        return award_summary;
    }

    public void setAward_summary(String award_summary) {
        this.award_summary = award_summary;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Award> getChildren() {
        return children;
    }

    public void setChildren(List<Award> children) {
        this.children = children;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isHava() {
        return hava;
    }

    public void setHava(boolean hava) {
        this.hava = hava;
    }

}
