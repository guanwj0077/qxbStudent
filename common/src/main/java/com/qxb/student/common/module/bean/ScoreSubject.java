package com.qxb.student.common.module.bean;

import java.util.List;

/**
 * @author winky
 * @date 2018/7/25
 */
public class ScoreSubject {

    private int id;
    private String name;
    private List<ScoreBat> data;

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

    public List<ScoreBat> getData() {
        return data;
    }

    public void setData(List<ScoreBat> data) {
        this.data = data;
    }
}
