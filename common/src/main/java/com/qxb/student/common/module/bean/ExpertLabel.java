package com.qxb.student.common.module.bean;


public class ExpertLabel {

    /**
     * 创建人ID
     */
    private int creator_id;
    /**
     * 状态 1启用2关闭
     */
    private int status;
    /**
     * 创建时间
     */
    private long create_time;
    /**
     * 标签名称
     */
    private String name;
    /**
     * 创建人名称
     */
    private String creator_name;

    /**
     * 标记次数
     **/
    private int number;
    /**
     * 专家被评的标签的数量
     */
    private int label_num;
    /**
     * 问题累计点赞的数量
     */
    private int praise_num;

    /**
     * 是否评价
     **/
    private int is_evaluate;

    public int getLabel_num() {
        return label_num;
    }

    public void setLabel_num(int label_num) {
        this.label_num = label_num;
    }

    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }

    public int getCreator_id() {
        return creator_id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCreator_name(String creator_name) {
        this.creator_name = creator_name;
    }

    public String getCreator_name() {
        return creator_name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPraise_num() {
        return praise_num;
    }

    public void setPraise_num(int praise_num) {
        this.praise_num = praise_num;
    }

    public int getIs_evaluate() {
        return is_evaluate;
    }

    public void setIs_evaluate(int is_evaluate) {
        this.is_evaluate = is_evaluate;
    }

}
