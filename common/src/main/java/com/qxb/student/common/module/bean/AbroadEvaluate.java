package com.qxb.student.common.module.bean;


import java.util.Date;

/**
 * 留学商品评价
 * @author qianle
 */
public class AbroadEvaluate{

	private int id;
	/**
	 * 订单id
	 */
	private int order_id;
	/**
	 * 关联的id （顾问 accountID）
	 */
	private int relate_id;
	/**
	 * 学生ID
	 */
	private int stu_id;
	/**
	 * 评价星级 1.0~5.0
	 */
	private double grade;
	/**
	 * 状态 1 正常
	 */
	private int status;
	/**
	 * 创建时间
	 */
	private Date create_time;
	/**
	 * 评价内容
	 */
	private String grade_content;
		
	
	/**非表字段**/
	private String stu_name;
	
	//学生名称
	private String name;

	//用户头像
	private String pic;
	//用户昵称
	private String nick_name;
	//商品code
	private String product_code;

	/** 留学商品名称 **/
	private String abroadGoodsName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getRelate_id() {
		return relate_id;
	}

	public void setRelate_id(int relate_id) {
		this.relate_id = relate_id;
	}

	public int getStu_id() {
		return stu_id;
	}

	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getGrade_content() {
		return grade_content;
	}

	public void setGrade_content(String grade_content) {
		this.grade_content = grade_content;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getAbroadGoodsName() {
		return abroadGoodsName;
	}

	public void setAbroadGoodsName(String abroadGoodsName) {
		this.abroadGoodsName = abroadGoodsName;
	}
}
