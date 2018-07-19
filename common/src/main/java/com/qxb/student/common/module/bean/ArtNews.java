package com.qxb.student.common.module.bean;


/**
 * 艺考资讯
 *
 * @author
 */
public class ArtNews {
    /**
     * --3：艺考百科
     * --4：历年真题
     * --5：艺考资讯
     * --6: 艺考广告
     */
    private int news_type;
    /**
     * 创建人id
     */
    private int create_user_id;
    /**
     * 创建人姓名
     */
    private String create_user_name;
    /**
     * 创建时间
     */
    private Long create_time;
    /**
     * 标题
     */
    private String title;
    /**
     * 封面图
     */
    private String front_cover;
    /**
     * 简介
     */
    private String summary;
    /**
     * 内容
     */
    private String content;
    /**
     * 状态 1.开启 2.关闭
     */
    private int status;
    /**
     * 图片地址
     */
    private String img_url;
    /**
     * 视频地址
     */
    private String video_url;

    private int istop;

    private int is_collectioned;

    private String content_html;
    private String create_timeString;

    public String getCreate_user_name() {
        return create_user_name;
    }

    public void setCreate_user_name(String create_user_name) {
        this.create_user_name = create_user_name;
    }

    public String getContent_html() {
        return content_html;
    }

    public void setContent_html(String content_html) {
        this.content_html = content_html;
    }

    public int getIs_collectioned() {
        return is_collectioned;
    }

    public void setIs_collectioned(int is_collectioned) {
        this.is_collectioned = is_collectioned;
    }

    public int getIstop() {
        return istop;
    }

    public void setIstop(int istop) {
        this.istop = istop;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setNews_type(int news_type) {
        this.news_type = news_type;
    }

    public int getNews_type() {
        return news_type;
    }

    public void setCreate_user_id(int create_user_id) {
        this.create_user_id = create_user_id;
    }

    public int getCreate_user_id() {
        return create_user_id;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setFront_cover(String front_cover) {
        this.front_cover = front_cover;
    }

    public String getFront_cover() {
        return front_cover;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getCreate_timeString() {
        return create_timeString;
    }

}
