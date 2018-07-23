package com.qxb.student.common.module.bean;

/**
 * 学校视频
 * @author winky
 * @date 2018/7/23
 */
public class SchoolVideo {

    private int id;
    private String image;
    private String imageRealPath;
    private int scan_num;
    private String title;
    private int user_id;
    private String user_name;
    private int video_id;
    private String school_name;
    private String profess_name;
    private String video_url;
    private String share_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setImageRealPath(String imageRealPath) {
        this.imageRealPath = imageRealPath;
    }

    public int getScan_num() {
        return scan_num;
    }

    public void setScan_num(int scan_num) {
        this.scan_num = scan_num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getProfess_name() {
        return profess_name;
    }

    public void setProfess_name(String profess_name) {
        this.profess_name = profess_name;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }
}
