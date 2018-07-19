package com.qxb.student.common.module.bean;


public class ArtNewsComment {

    private int id;
    /**
     * 学生id
     */
    private int Student_id;
    /**
     * 艺考新闻id
     */
    private int art_news_id;
    /**
     * 点赞数
     */
    private int praise;
    /**
     * 创建时间
     */
    private Long create_time;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 状态 1显示 2关闭
     */
    private int status;
    /**
     * 学生姓名
     */
    private String stu_name;
    /**
     * 艺考资讯标题
     */
    private String art_title;
    /**
     * 学生头像url
     */
    private String photo_url;

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

    public String getArt_title() {
        return art_title;
    }

    public void setArt_title(String art_title) {
        this.art_title = art_title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 是否点赞
     */
    private int ispraise;

    public int getIspraise() {
        return ispraise;
    }

    public void setIspraise(int ispraise) {
        this.ispraise = ispraise;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(int student_id) {
        this.Student_id = student_id;
    }

    public void setArt_news_id(int art_news_id) {
        this.art_news_id = art_news_id;
    }

    public int getArt_news_id() {
        return art_news_id;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public int getPraise() {
        return praise;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }


}
