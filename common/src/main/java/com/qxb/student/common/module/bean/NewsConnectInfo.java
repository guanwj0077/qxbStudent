package com.qxb.student.common.module.bean;

/**
 * 伴考关联学校、机构实体类
 *
 * @author hs011
 * @date 2018/7/18
 */
public class NewsConnectInfo {

    /**
     * id
     */
    private int id;

    /**
     * 学校名称
     */
    private String school_name;

    /**
     * 学校LOGO
     */
    private String logo;

    /**
     * 标签
     */
    private String tag;

    /**
     * 地址
     */
    private String address;

    /**
     * 关联类型school_baseinfo学校，t_sys_group机构
     */
    private String connect_type;

    /**
     * 视频背景图片
     */
    private String video_image;

    /**
     * 视频地址
     */
    private String video_url;

    /**
     * 伴考背景图片
     */
    private String image;

    /**
     * 接收消息实体的id
     **/
    private int receive_id;
    private String videoImageRealPath;
    private String logoRealPath;
    private String imageRealPath;

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
     * 获取学校名称
     */
    public String getSchool_name() {
        return school_name;
    }

    /**
     * 设置学校名称
     */
    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    /**
     * 获取详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取学校LOGO
     */
    public String getLogo() {
        return logo;
    }

    public String getLogoRealPath() {
        return logoRealPath;
    }

    /**
     * 设置学校LOGO
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * 获取标签
     */
    public String getTag() {
        return tag;
    }

    /**
     * 设置标签
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getConnect_type() {
        return connect_type;
    }

    public void setConnect_type(String connect_type) {
        this.connect_type = connect_type;
    }

    public String getVideo_image() {
        return video_image;
    }

    public void setVideo_image(String video_image) {
        this.video_image = video_image;
    }

    public String getVideoImageRealPath() {
        return videoImageRealPath;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageRealPath() {
        return imageRealPath;
    }

    public int getReceive_id() {
        return receive_id;
    }

    public void setReceive_id(int receive_id) {
        this.receive_id = receive_id;
    }

}
