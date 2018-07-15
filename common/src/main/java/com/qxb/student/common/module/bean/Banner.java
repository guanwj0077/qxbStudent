package com.qxb.student.common.module.bean;

/**
 * Created by winky on 2018/4/10.
 */

public class Banner {

    private int group_id;
    private int id;
    private String img_url;
    private int recruit_bannner_num;
    private int status;
    private String title;
    private int type;
    private String url;
    private String web_url;
    private int item_id;
    private String imgUrlRealPath;

    public String getImgUrlRealPath() {
        return imgUrlRealPath;
    }

    public void setImgUrlRealPath(String imgUrlRealPath) {
        this.imgUrlRealPath = imgUrlRealPath;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getRecruit_bannner_num() {
        return recruit_bannner_num;
    }

    public void setRecruit_bannner_num(int recruit_bannner_num) {
        this.recruit_bannner_num = recruit_bannner_num;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }
}
