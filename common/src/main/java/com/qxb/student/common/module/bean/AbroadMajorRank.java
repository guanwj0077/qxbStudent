package com.qxb.student.common.module.bean;


/**
 * 出国留学 专业排行榜
 * @author qianle
 *
 */
public class AbroadMajorRank{

	private int id;
	/**专业类型*/
	private int major_type;
	/**学校id*/
	private int school_id;
	/**排名*/
	private int rank;
	/**年份*/
	private int year;
	/**排名类型*/
	private int rank_type;
	/**学校名称*/
	private String school_name;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMajor_type() {
		return major_type;
	}

	public void setMajor_type(int major_type) {
		this.major_type = major_type;
	}

	public int getSchool_id() {
		return school_id;
	}

	public void setSchool_id(int school_id) {
		this.school_id = school_id;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRank_type() {
		return rank_type;
	}

	public void setRank_type(int rank_type) {
		this.rank_type = rank_type;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
}
