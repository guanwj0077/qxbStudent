package com.qxb.student.common.module.bean;

/****
 * 艺考教学案例表
 * @author
 *
 */
public class ArtCase {

    /**
     * 案例id
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
     * 内容
     **/
    private String content;
    /**
     * 创建时间
     **/
    private Long create_time;
    /**
     * 案例详情Url
     */
    private String case_url;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCase_url() {
        return case_url;
    }

    public void setCase_url(String case_url) {
        this.case_url = case_url;
    }
}
