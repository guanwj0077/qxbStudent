package com.qxb.student.common.module.bean;

import java.util.Date;
import java.util.List;

public class BaseEvaluationResult {

    /**
     * id
     */
    private int id;
    /**
     * 用户ID
     */
    private int user_id;
    /**
     * 用户姓名
     */
    private String user_name;
    /**
     * 用户得分
     */
    private String result;
    /**
     * 生成时间
     */
    private Date createtime;
    /**
     * 霍兰德六种得分类型json串
     **/
    private String holland_score;

    /**
     * 类型1：mbti测评 2：霍兰德测评
     */
    private int type;

    private String name;
    /**
     * 送积分数
     */
    private int addIntegral;

    /**
     * 总积分数
     */
    private int integral;

    public String getHolland_score() {
        return holland_score;
    }

    public void setHolland_score(String holland_score) {
        this.holland_score = holland_score;
    }

    private String description;
    /**
     * 职业信息列表
     **/
    private List<ZhiYeJson> zhiYeList;

    /**
     * 获取id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取用户ID
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * 设置用户ID
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * 获取用户姓名
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * 设置用户姓名
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * 获取用户得分
     */
    public String getResult() {
        return result;
    }

    /**
     * 设置用户得分
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * 获取生成时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置生成时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ZhiYeJson> getZhiYeList() {
        return zhiYeList;
    }

    public void setZhiYeList(List<ZhiYeJson> zhiYeList) {
        this.zhiYeList = zhiYeList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAddIntegral() {
        return addIntegral;
    }

    public void setAddIntegral(int addIntegral) {
        this.addIntegral = addIntegral;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }
}
