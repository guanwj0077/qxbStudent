package com.qxb.student.common.module.bean;

import java.util.List;

/**
 * 留学咨询详情
 * @author qianle
 */
public class AbroadNewsDetial {

    /**留学咨询**/
    private AbroadNews detial;

    /**相关内容**/
    private List<AbroadNews> relateList;


    public AbroadNews getDetial() {
        return detial;
    }

    public void setDetial(AbroadNews detial) {
        this.detial = detial;
    }

    public List<AbroadNews> getRelateList() {
        return relateList;
    }

    public void setRelateList(List<AbroadNews> relateList) {
        this.relateList = relateList;
    }
}
