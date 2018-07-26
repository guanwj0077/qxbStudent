package com.qxb.student.common.module.bean;

import java.util.List;

/**
 * @author winky
 * @date 2018/7/25
 */
public class MajorSubject {

    private int id;
    private String name;
    private List<MajorBat> data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MajorBat> getData() {
        return data;
    }

    public void setData(List<MajorBat> data) {
        this.data = data;
    }
}
