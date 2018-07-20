package com.qxb.student.common.module.bean;

import java.util.List;

/**
 * 留学活动
 * @author qianle
 */
public class AbroadActive {

    /** 活动描述 **/
    private String describe;
    /** 活动图片 **/
    private String img;
    /** 参与商品列表 **/
    private List<SysGoods> goodsList;
    /** 参与商品数量 **/
    private int goodsListCount;

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<SysGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<SysGoods> goodsList) {
        this.goodsList = goodsList;
    }

    public int getGoodsListCount() {
        return goodsListCount;
    }

    public void setGoodsListCount(int goodsListCount) {
        this.goodsListCount = goodsListCount;
    }
}
