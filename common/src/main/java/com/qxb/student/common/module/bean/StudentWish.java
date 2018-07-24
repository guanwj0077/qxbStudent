package com.qxb.student.common.module.bean;

/**
 * 学生志愿实体类
 * @author
 */
public class StudentWish{

	/**学生ID**/
	private int stu_id;
	/**志愿标题**/
	private String title;
	/**志愿表json数据**/
	private String wish_table_json;
	/**考生成绩**/
	private int score;
	/**填报年份**/
	private int year;
	/**考生省份**/
	private String province;
	/**科目类别（文理）**/
	private int subject_type;
	/**填报方式 （1：大学优先  2：职业优先）**/
	private int fill_way;
	/**填报条件**/
	private String fill_condition;
	/**备注**/
	private String note;
	/**状态**/
	private int status;
	/**创建时间**/
	private long create_time;
	/**更新时间**/
	private long uplong_time;
	/**省份中文名称**/
	private String province_name;
	/**学生姓名*/
	private String name;
	/**学生性别*/
	private String sex;
	/**科目类别（文理）*/
	private String subject;
	/**城市编码*/
	private String city;
	/**城市名称*/
	private String city_name;
	/**区域编码*/
	private String area;
	/**区域名称*/
	private String area_name;
	/**高中学校ID*/
	private int highschool_id;
	/**高中学校*/
	private String highschool_name;
	/**联系电话*/
	private String telphone;

	/** 订单id */
	private int order_id;
	/** 志愿类型  1.智能填报志愿,2.志愿填报服务草表,3.自主招生服务草表*/
	private int wish_type;
	
	/**
	 * 非数据库字段-----------------------
	 */
	/**
	 * 订单状态
	 */
	private int correlate_status;
	/**
	 * 专家id
	 */
	private int expert_id;

	public int getStu_id() {
		return stu_id;
	}

	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public int getSubject_type() {
		return subject_type;
	}

	public void setSubject_type(int subject_type) {
		this.subject_type = subject_type;
	}

	public int getFill_way() {
		return fill_way;
	}

	public void setFill_way(int fill_way) {
		this.fill_way = fill_way;
	}

	public String getFill_condition() {
		return fill_condition;
	}

	public void setFill_condition(String fill_condition) {
		this.fill_condition = fill_condition;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public long getUplong_time() {
		return uplong_time;
	}

	public void setUplong_time(long uplong_time) {
		this.uplong_time = uplong_time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWish_table_json() {
		return wish_table_json;
	}

	public void setWish_table_json(String wish_table_json) {
		this.wish_table_json = wish_table_json;
	}

	public String getProvince_name() {
		return province_name;
	}

	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	public int getHighschool_id() {
		return highschool_id;
	}

	public void setHighschool_id(int highschool_id) {
		this.highschool_id = highschool_id;
	}

	public String getHighschool_name() {
		return highschool_name;
	}

	public void setHighschool_name(String highschool_name) {
		this.highschool_name = highschool_name;
	}

	public String getTelphone() {
		return telphone;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getWish_type() {
		return wish_type;
	}

	public void setWish_type(int wish_type) {
		this.wish_type = wish_type;
	}

	public int getCorrelate_status() {
		return correlate_status;
	}

	public void setCorrelate_status(int correlate_status) {
		this.correlate_status = correlate_status;
	}

	public int getExpert_id() {
		return expert_id;
	}

	public void setExpert_id(int expert_id) {
		this.expert_id = expert_id;
	}
	
	
	
}
