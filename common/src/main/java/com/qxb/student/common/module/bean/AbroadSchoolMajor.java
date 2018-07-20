package com.qxb.student.common.module.bean;


import java.util.List;

/**
 * 留学专业
 * @author qianle
 */
public class AbroadSchoolMajor {

	private int id;
	/**学校id*/
	private int school_id;
	/**学制（年）*/
	private double study_year;
	/**课程类型（对应原型上学位类型筛选） 1.本科 2.研究生 3.博士 4.专科 5.语言6.高中*/
	private int course_type;
	/**专业编码*/
	private String major_code;
	/**学校名称*/
	private String school_name;
	/**在招专业名称*/
	private String major_name;
	/**学位类型 例如：高级计算机学士*/
	private String degree_type;
	/**是否热门专业*/
	private int is_hot;
	/**专业大类编码*/
	private String base_major_code;
	
	/**专业方向名称*/
	private String base_major_name;
	/**在招专业学位类型列表*/
	private List<Integer> course_type_list;
	/**在招专业专业方向列表*/
	private List<AbroadSchoolMajor> major_list;
	/**学校所属国家编码*/
	private int country_code;
	/**学校所属国家名称*/
	private String country_name;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setSchool_id(int school_id) {
		this.school_id = school_id;
	}

	public int getSchool_id() {
		return school_id;
	}

	public void setStudy_year(double study_year) {
		this.study_year = study_year;
	}

	public double getStudy_year() {
		return study_year;
	}

	public void setCourse_type(int course_type) {
		this.course_type = course_type;
	}

	public int getCourse_type() {
		return course_type;
	}

	public void setMajor_code(String major_code) {
		this.major_code = major_code;
	}

	public String getMajor_code() {
		return major_code;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}

	public String getMajor_name() {
		return major_name;
	}

	public void setDegree_type(String degree_type) {
		this.degree_type = degree_type;
	}

	public String getDegree_type() {
		return degree_type;
	}

	public int getIs_hot() {
		return is_hot;
	}

	public void setIs_hot(int is_hot) {
		this.is_hot = is_hot;
	}

	public String getBase_major_name() {
		return base_major_name;
	}

	public void setBase_major_name(String base_major_name) {
		this.base_major_name = base_major_name;
	}

	public List<Integer> getCourse_type_list() {
		return course_type_list;
	}

	public void setCourse_type_list(List<Integer> course_type_list) {
		this.course_type_list = course_type_list;
	}

	public List<AbroadSchoolMajor> getMajor_list() {
		return major_list;
	}

	public void setMajor_list(List<AbroadSchoolMajor> major_list) {
		this.major_list = major_list;
	}

	public String getBase_major_code() {
		return base_major_code;
	}

	public void setBase_major_code(String base_major_code) {
		this.base_major_code = base_major_code;
	}

	public int getCountry_code() {
		return country_code;
	}

	public void setCountry_code(int country_code) {
		this.country_code = country_code;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}


}
