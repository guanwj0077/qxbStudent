package com.qxb.student.common.module.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * 系统广告
 *
 * @author caiZong
 */
@Entity(tableName = "SysAd")
public class SysAd {

    @PrimaryKey(autoGenerate = true)
    private int _id;

    /**
     * 状态
     */
    private int status;
    /**
     * 显示顺序
     */
    private String show_order;
    /**
     * 名称
     */
    private String name;
    /**
     * 标题
     */
    private String title;
    /**
     * 图片链接
     */
    private String img_url;

    /**
     * 图片链接
     */
    private String imageRealPath;
    /**
     * 广告位置
     */
    private String position;
    /**
     * 广告依附对象id
     */
    private Integer item_id;
    /**
     * 广告链接
     */
    private String link_url;
    /**
     * 类型
     */
    private String type;
    /**
     * 类型名称
     */
    private String type_name;
    /**
     * 简介
     */
    private String summary;
    /**
     * 创建时间
     */
    private Long create_time;
    /**
     * 省份编码
     **/
    private String province;

    /**
     * 广告跳转类型
     */
    private int binner_type;
    /**
     * 广告跳转ID
     */
    private int binner_id;
    /**
     * 商品code
     **/
    private String goods_code;
    /**
     * 支付方式
     **/
    private String pay_way;
    /**
     * 频道
     */
    private int channel;
    /**
     * url类型 1.网页2.视频
     */
    private int url_type;
    /**
     * 跳转类型
     **/
    private int jump_type;
    /**
     * 跳转目标（参数）
     **/
    private String jump_target;
    /**
     * 跳转目标说明
     **/
    private String target_name;


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUrl_type() {
        return url_type;
    }

    public void setUrl_type(int url_type) {
        this.url_type = url_type;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public Integer getStatus() {
        return status;
    }

    public String getShow_order() {
        return show_order;
    }

    public void setShow_order(String show_order) {
        this.show_order = show_order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }


    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public int getBinner_type() {
        return binner_type;
    }

    public void setBinner_type(int binner_type) {
        this.binner_type = binner_type;
    }

    public int getBinner_id() {
        return binner_id;
    }

    public void setBinner_id(int binner_id) {
        this.binner_id = binner_id;
    }

    public String getGoods_code() {
        return goods_code;
    }

    public void setGoods_code(String goods_code) {
        this.goods_code = goods_code;
    }

    public String getPay_way() {
        return pay_way;
    }

    public void setPay_way(String pay_way) {
        this.pay_way = pay_way;
    }

    public int getJump_type() {
        return jump_type;
    }

    public void setJump_type(int jump_type) {
        this.jump_type = jump_type;
    }

    public String getJump_target() {
        return jump_target;
    }

    public void setJump_target(String jump_target) {
        this.jump_target = jump_target;
    }

    public String getTarget_name() {
        return target_name;
    }

    public void setTarget_name(String target_name) {
        this.target_name = target_name;
    }

    public String getImageRealPath() {
        return imageRealPath;
    }

    public void setImageRealPath(String imageRealPath) {
        this.imageRealPath = imageRealPath;
    }

    public String getType_name() {
        return type_name;
    }
}
