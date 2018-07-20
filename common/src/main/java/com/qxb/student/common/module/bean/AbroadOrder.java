package com.qxb.student.common.module.bean;

/**
 * 留学订单详情
 * @author qianle
 */
public class AbroadOrder {

    /**订单对象**/
    private SysOrder order;

    /** 待评价,已完成获取处理时间 **/
    private long process_time;

    /** 评价星级 1.0~5.0 **/
    private int evaluate_score;

    /** 评价内容 **/
    private String grade_content;

    public SysOrder getOrder() {
        return order;
    }

    public void setOrder(SysOrder order) {
        this.order = order;
    }

    public long getProcess_time() {
        return process_time;
    }

    public void setProcess_time(long process_time) {
        this.process_time = process_time;
    }

    public int getEvaluate_score() {
        return evaluate_score;
    }

    public void setEvaluate_score(int evaluate_score) {
        this.evaluate_score = evaluate_score;
    }

    public String getGrade_content() {
        return grade_content;
    }

    public void setGrade_content(String grade_content) {
        this.grade_content = grade_content;
    }
}
