package com.qxb.student.common.module.bean;


import java.util.Date;

/**
 * 留学机构-经典案例实体类
 * @author qianle
 *
 */
public class AbroadGroupCase{

	
	private int id;
	/**机构id*/
	private int group_id;
	/**案例创建时间*/
	private Date create_time;
	/**案例商品编码*/
	private String goods_code;
	/**案例图片链接 多个用逗号分隔*/
	private String img_url;
	/**案例学生名字*/
	private String stu_name;
	/**案例文字描述*/
	private String content;

	private String shortCreateTime;

	private String create_timeString;

	/**商品名称**/
	private String abroadGoodsName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getGoods_code() {
		return goods_code;
	}

	public void setGoods_code(String goods_code) {
		this.goods_code = goods_code;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getShortCreateTime() {
		return shortCreateTime;
	}

	public void setShortCreateTime(String shortCreateTime) {
		this.shortCreateTime = shortCreateTime;
	}

	public String getCreate_timeString() {
		return create_timeString;
	}

	public void setCreate_timeString(String create_timeString) {
		this.create_timeString = create_timeString;
	}

	public String getAbroadGoodsName() {
		return abroadGoodsName;
	}

	public void setAbroadGoodsName(String abroadGoodsName) {
		this.abroadGoodsName = abroadGoodsName;
	}
}
