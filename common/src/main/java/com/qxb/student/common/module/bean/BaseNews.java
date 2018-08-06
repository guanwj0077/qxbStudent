package com.qxb.student.common.module.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "BaseNews")
public class BaseNews{
	/** id */
	@PrimaryKey
	private int id;

	/** 标题 */
	private String title;

	/** 类别 */
	private int type;

	private String province;
	private String province_name;

	/** 图片 */
	private String image;

	private String imageRealPath;

	/** 内容 */
	private String content;

	/** 创建时间 */
	private long create_time;

	private String create_timeString;

	/** 排序 */
	private int order;

	/** 是否置项 */
	private int istop;

	/** 状态 */
	private int status;
	
	/**简介*/
	private String summary;
	
	/**浏览次数*/
	private int scan_num;

	/** 院校后台浏览次数 */
	private int edu_scan_num;
	
	/** 关联类型school_baseinfo学校，t_sys_group机构*/
	private String connect_type;
	
	/** 关联ID*/
	private int connect_id;
	
	/** 关联名称*/
	private String connect_name;
	
	/**	 学生端是否显示1:显示，2：不显示*/
	private int show_stu;
	
	/**	 学生端是否显示1:显示，2：不显示*/
	private int show_tea;

	/**	视频背景图片	*/
	private String video_image;
	
	/**	视频地址	*/
	private String video_url;
	/** 是否更新创建时间  */
	private int uplongTime;
	/*频道 1.资讯2.备考3.报考4.大学5.专业*/
	private int channel;
	/*是否收藏*/
	private int is_collectioned;
	/*收藏数*/
	private int collection_count;
	/*点赞数*/
	private int comment_count;

	private String shortCreateTime;
	private String videoImageRealPath;

	public int getCollection_count() {
		return collection_count;
	}

	public void setCollection_count(int collection_count) {
		this.collection_count = collection_count;
	}

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}

	public int getIs_collectioned() {
		return is_collectioned;
	}

	public void setIs_collectioned(int is_collectioned) {
		this.is_collectioned = is_collectioned;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

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
	 * 获取标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 获取类别
	 */
	public int getType() {
		return type;
	}

	/**
	 * 设置类别
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * 获取图片
	 */
	public String getImage() {
		return image;
	}

	/**
	 * 设置图片
	 */
	public void setImage(String image) {
		this.image = image;
	}

	public String getImageRealPath() {
		return imageRealPath;
	}

	/**
	 * 获取内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取创建时间
	 */
	public long getCreate_time() {
		return create_time;
	}

	public String getCreate_timeString() {
		return create_timeString;
	}

	public String getShortCreateTime(){
		return shortCreateTime;
	}
	/**
	 * 设置创建时间
	 */
	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	/**
	 * 获取排序
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * 设置排序
	 */
	public void setOrder(int order) {
		this.order = order;
	}

	/**
	 * 获取是否置项
	 */
	public int getIstop() {
		return istop;
	}

	/**
	 * 设置是否置项
	 */
	public void setIstop(int istop) {
		this.istop = istop;
	}

	/**
	 * 获取状态
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * 设置状态
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvince_name() {
		return province_name;
	}

	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getScan_num() {
		return scan_num;
	}

	public void setScan_num(int scan_num) {
		this.scan_num = scan_num;
	}

	public int getEdu_scan_num() {
		return edu_scan_num;
	}

	public void setEdu_scan_num(int edu_scan_num) {
		this.edu_scan_num = edu_scan_num;
	}

	public String getConnect_type() {
		return connect_type;
	}

	public void setConnect_type(String connect_type) {
		this.connect_type = connect_type;
	}

	public int getConnect_id() {
		return connect_id;
	}

	public void setConnect_id(int connect_id) {
		this.connect_id = connect_id;
	}

	public String getConnect_name() {
		return connect_name;
	}

	public void setConnect_name(String connect_name) {
		this.connect_name = connect_name;
	}

	public int getShow_stu() {
		return show_stu;
	}

	public void setShow_stu(int show_stu) {
		this.show_stu = show_stu;
	}

	public int getShow_tea() {
		return show_tea;
	}

	public void setShow_tea(int show_tea) {
		this.show_tea = show_tea;
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

	public int getUplongTime() {
		return uplongTime;
	}

	public void setUplongTime(int uplongTime) {
		this.uplongTime = uplongTime;
	}

	public void setImageRealPath(String imageRealPath) {
		this.imageRealPath = imageRealPath;
	}

	public void setCreate_timeString(String create_timeString) {
		this.create_timeString = create_timeString;
	}

	public void setShortCreateTime(String shortCreateTime) {
		this.shortCreateTime = shortCreateTime;
	}

	public void setVideoImageRealPath(String videoImageRealPath) {
		this.videoImageRealPath = videoImageRealPath;
	}

}
