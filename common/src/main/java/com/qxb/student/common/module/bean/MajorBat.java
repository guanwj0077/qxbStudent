package com.qxb.student.common.module.bean;

import java.util.List;

/**
 * @author winky
 * @date 2018/7/25
 */
public class MajorBat {

    private int bat;
    private String name;
    private List<MajorParent> data;

    public int getBat() {
        return bat;
    }

    public void setBat(int bat) {
        this.bat = bat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MajorParent> getData() {
        return data;
    }

    public void setData(List<MajorParent> data) {
        this.data = data;
    }
}
