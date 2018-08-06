package com.qxb.student.common.module.bean;

import android.util.Base64;

import com.qxb.student.common.module.IFuckBean;

/**
 * @author: zjk9527
 * created on: 2018/8/1 10:09
 * description:
 */
public class LectureVideo implements IFuckBean {

    private int id;
    private String image;
    private String name;
    private String phone;
    private String photo;
    private String power_code;
    private String profile;
    private int scan_num;
    private String share_url;
    private String show_order;
    private int staffId;
    private String summary;
    private String title;
    private int video_id;
    private String video_web_url;
    private boolean isChecked;
    private String goods_code;
    private boolean isBuy;
    private boolean isShare;

    public LectureVideo() {
    }

    public LectureVideo(int id, String image, String name, String phone, String photo, String power_code, String profile, int scan_num, String share_url, String show_order, int staffId, String summary, String title, int video_id, String video_web_url, boolean isChecked, String goods_code, boolean isBuy, boolean isShare) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.phone = phone;
        this.photo = photo;
        this.power_code = power_code;
        this.profile = profile;
        this.scan_num = scan_num;
        this.share_url = share_url;
        this.show_order = show_order;
        this.staffId = staffId;
        this.summary = summary;
        this.title = title;
        this.video_id = video_id;
        this.video_web_url = video_web_url;
        this.isChecked = isChecked;
        this.goods_code = goods_code;
        this.isBuy = isBuy;
        this.isShare = isShare;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPower_code() {
        return power_code;
    }

    public void setPower_code(String power_code) {
        this.power_code = power_code;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getScan_num() {
        return scan_num;
    }

    public void setScan_num(int scan_num) {
        this.scan_num = scan_num;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getShow_order() {
        return show_order;
    }

    public void setShow_order(String show_order) {
        this.show_order = show_order;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String getUrl() {
        return new String(Base64.decode(getVideo_web_url(),0));
    }


    public String getTitle() {
        return title;
    }

    @Override
    public String getCoverRealPath() {
        return null;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public String getVideo_web_url() {
        return video_web_url;
    }

    public void setVideo_web_url(String video_web_url) {
        this.video_web_url = video_web_url;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getGoods_code() {
        return goods_code;
    }

    public void setGoods_code(String goods_code) {
        this.goods_code = goods_code;
    }

    public boolean isBuy() {
        return isBuy;
    }

    public void setBuy(boolean buy) {
        isBuy = buy;
    }

    public boolean isShare() {
        return isShare;
    }

    public void setShare(boolean share) {
        isShare = share;
    }
}
