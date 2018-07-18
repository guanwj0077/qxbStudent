package com.qxb.student.common.module.bean;

import java.util.Date;

public class SysRank{

	/**
	 * 业务ID
	 */
	private String item_id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 状态 1=显示 2=隐藏
	 */
	private Integer status;
	/**
	 * 排序
	 */
	private String show_order;
	/**
	 * 业务类型
	 */
	private Integer type;
	/**
	 * 创建时间
	 */
	private Date create_time;
	/**
	 * 对象
	 */
	private Object obj;

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getShow_order() {
		return show_order;
	}

	public void setShow_order(String show_order) {
		this.show_order = show_order;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
