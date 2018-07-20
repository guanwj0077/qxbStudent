package com.qxb.student.common.module.bean;

/**
 * 留学资讯
 * @author qianle
 *
 */
public class AbroadNews {

    private int id;
    /**
     * 资讯类型  1：资讯 2：大学 3：专业 4：文书 5：签证 6：广告
     */
    private int news_type;
    /**
     *  创建者id  sysuser的id
     */
    private int create_user_id;
    /**
     * 状态  1：开启 2：关闭
     */
    private int status;
    /**
     * 是否置顶 1：是 2：否
     */
    private int istop;
    /**
     * 浏览数
     */
    private int visit_num;
    /**
     * 创建时间
     */
    private long create_time;
    /**
     * 标题
     */
    private String title;
    /**
     * 封面图
     */
    private String img_url;
    private String imgUrlRealPath;

    /**
     * 简介
     */
    private String summary;
    /**
     * 视屏链接
     */
    private String video_url;
    /**
     * 资讯内容
     */
    private String content;


    /**
     * 非数据库字段
     */
    /** 创建者姓名 */
    private String create_user_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNews_type() {
        return news_type;
    }

    public void setNews_type(int news_type) {
        this.news_type = news_type;
    }

    public int getCreate_user_id() {
        return create_user_id;
    }

    public void setCreate_user_id(int create_user_id) {
        this.create_user_id = create_user_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIstop() {
        return istop;
    }

    public void setIstop(int istop) {
        this.istop = istop;
    }

    public int getVisit_num() {
        return visit_num;
    }

    public void setVisit_num(int visit_num) {
        this.visit_num = visit_num;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getImgUrlRealPath() {
        return imgUrlRealPath;
    }

    public void setImgUrlRealPath(String imgUrlRealPath) {
        this.imgUrlRealPath = imgUrlRealPath;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate_user_name() {
        return create_user_name;
    }

    public void setCreate_user_name(String create_user_name) {
        this.create_user_name = create_user_name;
    }
}
