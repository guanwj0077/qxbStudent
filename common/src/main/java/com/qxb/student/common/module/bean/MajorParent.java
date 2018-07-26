package com.qxb.student.common.module.bean;

import java.util.List;

/**
 * @author winky
 * @date 2018/7/25
 */
public class MajorParent {

    private String name;
    private int total;
    private List<MajorChild> childrens;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<MajorChild> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<MajorChild> childrens) {
        this.childrens = childrens;
    }
}
