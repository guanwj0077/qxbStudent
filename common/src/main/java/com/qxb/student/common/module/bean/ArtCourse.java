package com.qxb.student.common.module.bean;

/**
 * 艺考课程信息表
 *
 * @author
 */
public class ArtCourse {

    /**
     * 课程id
     */
    private int id;

    /**
     * 类型 1:个人老师  2：机构
     **/
    private int type;
    /**
     * 关联id
     **/
    private int item_id;
    /**
     * 标题
     **/
    private String title;
    /**
     * 价格
     **/
    private double price;
    /**
     * 付费类型 :1：课时 2：学期 3：套
     **/
    private String pay_type;

    /**
     * 课程内容
     **/
    private String content;
    /**
     * 创建时间
     **/
    private Long create_time;
    /**
     * 课程状态（1：正常  0表示暂停）
     **/
    private int status;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
