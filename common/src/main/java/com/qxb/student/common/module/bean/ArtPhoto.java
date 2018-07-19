package com.qxb.student.common.module.bean;

import java.util.Date;

/***
 * 艺考相册表
 * @author
 *
 */
public class ArtPhoto {

    /**
     * 类型 1:个人老师  2：机构
     **/
    private int type;
    /**
     * 关联id
     **/
    private int item_id;
    /**
     * 图片地址
     **/
    private String img_url;
    /**
     * 图片说明
     **/
    private String summary;
    /**
     * 创建时间
     **/
    private Date create_time;
    /**
     * 图片状态
     **/
    private int status;
    /**
     * 图片完整Url
     */
    private String img_urlRealPath;

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

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImg_urlRealPath() {
        return img_urlRealPath;
    }

}
