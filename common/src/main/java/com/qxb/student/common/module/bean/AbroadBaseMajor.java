package com.qxb.student.common.module.bean;


import java.util.List;



/**
 * 出国留学-专业大类及专业
 * @author qianle
 *
 */
public class AbroadBaseMajor{

	private int id;
	/**专业层级 1：专业大类 2：普通专业*/
	private int depth;
	/**专业名称*/
	private String name;
	/**专业编码*/
	private String code;
	/**专业父级编码*/
	private String parent_code;

	/**非表字段**/
	
	/**专业在招院校数量*/
	private int recruit_num;
	private int isclose;
	/** 默认关闭节点 */
	private String state = "closed";
	private List<AbroadBaseMajor> children;
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getDepth() {
		return depth;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}

	public String getParent_code() {
		return parent_code;
	}

	public int getRecruit_num() {
		return recruit_num;
	}

	public void setRecruit_num(int recruit_num) {
		this.recruit_num = recruit_num;
	}

	public List<AbroadBaseMajor> getChildren() {
		return children;
	}

	public void setChildren(List<AbroadBaseMajor> children) {
		this.children = children;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getIsclose() {
		return isclose;
	}

	public void setIsclose(int isclose) {
		this.isclose = isclose;
	}
}
