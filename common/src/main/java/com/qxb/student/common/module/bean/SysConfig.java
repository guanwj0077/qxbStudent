package com.qxb.student.common.module.bean;


/**
 * 系统配置
 */
public class SysConfig {

	/**状态*/
	private Integer status;
	/**显示顺序*/
	private String show_order;
	/**编码*/
	private String code;
	/**名称*/
	private String name;
	/**类型*/
	private String type;
	/**配置值*/
	private String value;
	/**描述*/
	private String descr;
	/**创建时间*/
	private long create_time;
	
	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public long getCreate_time() {
		return create_time;
	}
	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

}
