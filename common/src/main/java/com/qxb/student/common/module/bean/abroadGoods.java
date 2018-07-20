package com.qxb.student.common.module.bean;

import java.util.List;

/**
 * 留学商品
 * @author qianle
 */

public class abroadGoods {

    private int id;

    /** 商品编码 **/
    private String code;

    /** 商品名称 **/
    private String title;

    /** 产品类型编码 **/
    private String product_code;

    /** 产品类型名称 **/
    private String product_name;

    /** 顾问的头像 **/
    private String item_pic;

    /** 顾问名称 **/
    private String adviser_name;


    /** 订单完成数量 **/
    private int complete_order_num;

    /** 平均评价得分 **/
    private double average_evaluate_score;

    /** 售价 **/
    private double price_sell;

    /** 账户id **/
    private int account_id;

    /** 是否参与活动 0 未参与 1参与 **/
    private int part_activity;

    /** 活动价 **/
    private double promote_price;

    /** 活动价描述 简短的话 **/
    private String price_describe;

    /**
     * 商品评论信息
     */
    private List<AbroadEvaluate> evaluateList;
    /** 评论数量 **/
    private int evaluateListTotal;

    /** 商品描述 URL **/
    private String describe_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getItem_pic() {
        return item_pic;
    }

    public void setItem_pic(String item_pic) {
        this.item_pic = item_pic;
    }

    public String getAdviser_name() {
        return adviser_name;
    }

    public void setAdviser_name(String adviser_name) {
        this.adviser_name = adviser_name;
    }

    public int getComplete_order_num() {
        return complete_order_num;
    }

    public void setComplete_order_num(int complete_order_num) {
        this.complete_order_num = complete_order_num;
    }

    public double getAverage_evaluate_score() {
        return average_evaluate_score;
    }

    public void setAverage_evaluate_score(double average_evaluate_score) {
        this.average_evaluate_score = average_evaluate_score;
    }

    public double getPrice_sell() {
        return price_sell;
    }

    public void setPrice_sell(double price_sell) {
        this.price_sell = price_sell;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getPart_activity() {
        return part_activity;
    }

    public void setPart_activity(int part_activity) {
        this.part_activity = part_activity;
    }

    public double getPromote_price() {
        return promote_price;
    }

    public void setPromote_price(double promote_price) {
        this.promote_price = promote_price;
    }

    public String getPrice_describe() {
        return price_describe;
    }

    public void setPrice_describe(String price_describe) {
        this.price_describe = price_describe;
    }

    public List<AbroadEvaluate> getEvaluateList() {
        return evaluateList;
    }

    public void setEvaluateList(List<AbroadEvaluate> evaluateList) {
        this.evaluateList = evaluateList;
    }

    public int getEvaluateListTotal() {
        return evaluateListTotal;
    }

    public void setEvaluateListTotal(int evaluateListTotal) {
        this.evaluateListTotal = evaluateListTotal;
    }

    public String getDescribe_url() {
        return describe_url;
    }

    public void setDescribe_url(String describe_url) {
        this.describe_url = describe_url;
    }
}
