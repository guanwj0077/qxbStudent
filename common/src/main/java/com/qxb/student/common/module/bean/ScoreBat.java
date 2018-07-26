package com.qxb.student.common.module.bean;

import java.util.List;

/**
 * @author winky
 * @date 2018/7/25
 */
public class ScoreBat {

    private int bat;
    private String name;

    private List<ScoreLine> data;

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

    public List<ScoreLine> getData() {
        return data;
    }

    public void setData(List<ScoreLine> data) {
        this.data = data;
    }
}
