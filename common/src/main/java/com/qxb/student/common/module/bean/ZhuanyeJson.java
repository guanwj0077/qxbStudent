package com.qxb.student.common.module.bean;
/**
 * 专业json数据
 * @author hs017
 *
 */
public class ZhuanyeJson {
	private int id;
	/**专业名称**/
	private String name;
	/**关联程度**/
	private String degree;
	/**专业类别  1：本科  2：专科**/
	private int type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
