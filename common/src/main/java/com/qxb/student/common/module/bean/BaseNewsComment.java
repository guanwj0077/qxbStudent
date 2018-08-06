package com.qxb.student.common.module.bean;


/**
 * 伴考评论实体
 *
 * @author
 */
public class BaseNewsComment {

    private int id;
    private int student_id;
    private int base_news_id;
    private int praise;
    private int status;
    private long create_time;
    private String content;

    private String stu_name;

    private String news_title;

    private String photo_url;

    private int ispraise;

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public int getIspraise() {
        return ispraise;
    }

    public void setIspraise(int ispraise) {
        this.ispraise = ispraise;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setBase_news_id(int base_news_id) {
        this.base_news_id = base_news_id;
    }

    public int getBase_news_id() {
        return base_news_id;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public int getPraise() {
        return praise;
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

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
