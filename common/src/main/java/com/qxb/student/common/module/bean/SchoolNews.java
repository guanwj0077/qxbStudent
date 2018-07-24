package com.qxb.student.common.module.bean;

public class SchoolNews{
	/** id */
    private int id;
    
	/** 学校ID */
    private int school_id;
    private String school_name;
    
	/** 标题 */
    private String title;
    
	/** 内容 */
    private String content;
      
	/** 类别 */
    private int type;
    
	/** 创建时间 */
    private long create_time;
    
	/** 排序 */
    private int order;
    
	/** 是否置顶 */
    private int istop;
    
	/** 状态 */
    private int status;
    
    private String summary;
    
	private String logo;

	/** 封面图片 */
	private String image;

	/** 浏览次数 */
	private int scan_num;
	private String create_timeString;
	private String imageRealPath;

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
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
	 * 获取学校ID
	 */
	public int getSchool_id() {
		return school_id;
	}

	/**
	 * 设置学校ID
	 */
	public void setSchool_id(int school_id) {
		this.school_id = school_id;
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

	public String getCreate_timeString() {
		return create_timeString;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public void setCreate_timeString(String create_timeString) {
		this.create_timeString = create_timeString;
	}

	public void setImageRealPath(String imageRealPath) {
		this.imageRealPath = imageRealPath;
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
	 * 获取是否置顶
	 */
	public int getIstop() {
		return istop;
	}

	/**
	 * 设置是否置顶
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public String getImage() {
		return image;
	}

	public String getImageRealPath() {
		return imageRealPath;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getScan_num() {
		return scan_num;
	}

	public void setScan_num(int scan_num) {
		this.scan_num = scan_num;
	}

}
