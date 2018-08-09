package com.qxb.student.common.module.bean;

public class RongyUser{

	/** 姓名 */
    private String name;
	/** 头像 */
	private String pic;
	/** 账户ID */
	private int account_id;
	
	/** 学校名id*/
	private int school_id;
	/** 学校名称 */
    private String school_name;
    /** 老师部门*/
    private String department;
    /** 老师职务 */
    private String duty;
    
    /** 类型  1:学校老师 2:机构（客服，留学机构员工，艺考机构员工，留学机构顾问） ,3 艺考个人老师 4.个人顾问 */
    private int type;
    
    /** 电话 */
    private String phone;
    
    /** 实体类型 */
    private String subject_type;
    
    /** 是否有常见问题 */
    private int have_question;
	/**
	 * 学校类型 0.国内 1.国外大学
	 */
	private int school_type;
	/**
	 * 老师头像
	 */
	private String picRealPath;

	public void setPicRealPath(String picRealPath) {
		this.picRealPath = picRealPath;
	}

	public int getSchool_type() {
		return school_type;
	}

	public void setSchool_type(int school_type) {
		this.school_type = school_type;
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

	public String getPicRealPath() {
		return picRealPath;
	}
	
	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getSchool_id() {
		return school_id;
	}

	public void setSchool_id(int school_id) {
		this.school_id = school_id;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSubject_type() {
		return subject_type;
	}

	public void setSubject_type(String subject_type) {
		this.subject_type = subject_type;
	}

	public int getHave_question() {
		return have_question;
	}

	public void setHave_question(int have_question) {
		this.have_question = have_question;
	}
	
}
