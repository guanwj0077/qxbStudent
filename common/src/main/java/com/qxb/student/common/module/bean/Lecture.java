package com.qxb.student.common.module.bean;

import java.util.List;

/**
 * @author: zjk9527
 * created on: 2018/8/1 10:06
 * description:
 */
public class Lecture {

    private boolean isBuy;
    private List<LectureVideo> list;
    private String goods_code;

    public Lecture() {
    }

    public Lecture(boolean isBuy, List<LectureVideo> list, String goods_code) {
        this.isBuy = isBuy;
        this.list = list;
        this.goods_code = goods_code;
    }

    public boolean isBuy() {
        return isBuy;
    }

    public void setBuy(boolean buy) {
        isBuy = buy;
    }

    public List<LectureVideo> getList() {
        return list;
    }

    public void setList(List<LectureVideo> list) {
        this.list = list;
    }

    public String getGoods_code() {
        return goods_code;
    }

    public void setGoods_code(String goods_code) {
        this.goods_code = goods_code;
    }
}
