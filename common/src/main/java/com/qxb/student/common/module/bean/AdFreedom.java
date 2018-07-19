package com.qxb.student.common.module.bean;

/**
 * 自主招生广告
 * @author
 *
 */
public class AdFreedom{

	private int id;
	/**
	 * 类型1视频，0链接
	 */
	private int type;
	/**
	 * 序号
	 */
	private int no;
	/**
	 * 状态1启用，0关闭
	 */
	private int status;
	/**
	 * 标题
	 */
	private String title;
	/**
	 *图片地址
	 */
	private String imgpath;
	/**
	 * 链接
	 */
	private String url;
	/**
	 * 创建时间
	 */
	private Long create_Long;
	/**
	 *图片地址Url
	 */
	private String imgpathRealPath;


	public Long getCreate_Long() {
		return create_Long;
	}

	public void setCreate_Long(Long create_Long) {
		this.create_Long = create_Long;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public String getImgpath() {
		return imgpath;
	}
	
	public String getImgpathRealPath() {
		return imgpathRealPath;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}



}
