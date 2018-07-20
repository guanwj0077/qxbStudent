package com.qxb.student.common.module.bean;

import java.util.List;

/**
 * @author hs011
 * @date 2018/7/20
 */

public class ExpertOneToOneServiceDetail {

    /**
     * 价格
     */
    private String price;

    /**
     * 网页Url
     */
    private String url;
    /**
     * 专家列表
     */
    private List<Expert> expertList;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Expert> getExpertList() {
        return expertList;
    }

    public void setExpertList(List<Expert> expertList) {
        this.expertList = expertList;
    }
}
