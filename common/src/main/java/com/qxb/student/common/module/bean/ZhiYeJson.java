package com.qxb.student.common.module.bean;

import java.util.List;

/**
 * 职业json数据
 * @author hs017
 *
 */
public class ZhiYeJson {
	/**职业名称**/
	private String name;
	/**对口专业数量**/
	private int size;
	/**对口专业列表**/
	private List<ZhuanyeJson> zhuanYeList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<ZhuanyeJson> getZhuanYeList() {
		return zhuanYeList;
	}
	public void setZhuanYeList(List<ZhuanyeJson> zhuanYeList) {
		this.zhuanYeList = zhuanYeList;
	}
	
}
