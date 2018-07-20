package com.qxb.student.common.module.bean;

/**
 * 出国留学 学校排行榜
 * @author qianle
 */
public class AbroadSchoolRank {

	/**排行榜id*/
	private int id;
	/**排名类型*/
	private int rank_type;
	/**学校id*/
	private int school_id;
	/**排名 1：QS大学排名 2：US News大学排名 3：Times Higher Education大学排名*/
	private int rank;
	/**年份*/
	private int year;
	/**学校名字*/
	private String school_name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRank_type() {
		return rank_type;
	}

	public void setRank_type(int rank_type) {
		this.rank_type = rank_type;
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

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
}
