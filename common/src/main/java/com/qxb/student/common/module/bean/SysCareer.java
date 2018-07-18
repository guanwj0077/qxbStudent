package com.qxb.student.common.module.bean;

import java.util.List;

/**
 * 职业实体类
 *
 * @author
 */
public class SysCareer {
    /**
     * 编码
     */
    private String code;
    /**
     * 父编码
     */
    private String pcode;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String descr;
    /**
     * 深度
     */
    private int depth;
    /**
     * 显示顺序
     */
    private int show_order;

    private String state = "closed";
    private List<SysCareer> children;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getShow_order() {
        return show_order;
    }

    public void setShow_order(int show_order) {
        this.show_order = show_order;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<SysCareer> getChildren() {
        return children;
    }

    public void setChildren(List<SysCareer> children) {
        this.children = children;
    }
}
