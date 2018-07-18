package com.qxb.student.common.module.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "tb_user_student")
public class UserStudent{
	/** id */
	@PrimaryKey
	private int id;
	
	/**会员类型  1 普通用户	；2 VIP	；3 测试用户 **/
	private int type;

	/** 头像 */
	private String pic;

	private String picRealPath;

	private int school_id;

	private String school_name;

	private String baominghao;
	/** 准考证号 */
    private String ticketno;

	/** 手机号 */

	private String telphone;

	/** 姓名 */
	private String name;

	/** 科目(理科/文科) */
	private String subject;

	/** 所在年份 */
	private int years;

	/** 省 */
	private String province;
	private String province_name;

	/** 市 */
	private String city;
	private String city_name;

	/** 区 */
	private String area;
	private String area_name;
	
	 /** 高中 */
    private int highschool_id;
    /** 地址 */
    private String address;

	/** 预估分 */
	private int yugufen;

	/** 高考分 */
	private int gaokaofen;

	/** 录取通知书 */
	private String notice_book_url;

	/** 上传录取通知书时间 */
	private Date notice_book_time;

	/** 注册时间 */
	private Date reg_time;

	/** 登录时间 */
	private Date login_time;

	/** 登录IP */
	private String login_ip;

	/** 登录地址 */
	private String login_addr;

	/** 登录次数 */
	private int login_number;

	/** 状态 */
	private int status;

	private String tonken;
	
	 /** 高中名称 */
    private String highschool_name;
    
    /**身份证号*/
    private String id_number;
    
    /**学籍号*/
    private String student_code;

	private int num;
	
	/** 账户ID */
	private int account_id;
	
	/** App显示名称 */
	private String app_showname;
	
	/** 描述  */
	private String descr;
	
	/** 付费用户，付费时间 */
	private Date pay_time;
	
	/** 激活码 */
	private String activate_code;
	
	/** 昵称 */
	private String nick_name;

	/**积分值，非数据库字段*/
	private int integral;
	
	/** 第三方微信登录id */
	private String wx_open_id;
	
	/** 第三方QQ登录id */
	private String qq_open_id;
	
	/**是否艺术生*/
	private int is_art;
	
	private String sex;
	/**注册渠道（首次注册的方式）   1：手机注册  2：qq  3：微信  4.官网  5.融e联  6小程序**/
	private int regist_channel;
	
	/**是否考虑出国留学  0：否   1：是  （ 默认否）*/
	private int is_plan_abroad;

	private String password ;

	private int is_read;

	private Date relate_time;
	/**
	 * 标记时间
	 */
	private Date mark_time;
	/**
	 * 学生类型 1.重点发展2.保持联系3.兴趣不大
	 */
	private int student_type;
	/**学生看过学校的时间*/
	private Date visit_school_time;
	/**
	 * 是否置顶
	 */
	private int is_top;
	/**学生是否交换手机号码*/
	private int is_change_phone;

	private String stu_name;
    /**
     * 招办机构地区编码
     */
	private String area_code;
	/**学生用户id**/
	private int user_id;

	//edu标记学生信息属性
	/** 是否预报名 1是 0否 **/
	private int is_registration;
	/** 是否收藏我校 1是 0否 **/
	private int is_collection;
	/** 是否看过我校 1是 0否 **/
	private int is_visit;
	
	/**留学意向**/
	private String target_abroad;
	
	/**微信小程序appId**/
	private String mini_app_id;
	
	/**网站QQ openId**/
	private String web_qq_open_id;
	
	/**网站WX openId**/
	private String web_wx_open_id;
	
	/**qq unionid**/
	private String qq_unionid;
	
	/**wx unionid**/
	private String wx_unionid;
	/**融e联open_id*/
	private  String icbc_open_id;
	/**
	 * 分数列表
	 */
	private int score;
	
	/** 意向报考院校 */
	private String target_college;
	/** 意向报考专业 */
	private String target_majors;

	/**
	 * 是否存在图片
	 */
	private int photo_exist;

	public int getPhoto_exist() {
		return photo_exist;
	}

	public void setPhoto_exist(int photo_exist) {
		this.photo_exist = photo_exist;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getArea_code() {
		return area_code;
	}

	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public int getIs_top() {
		return is_top;
	}

	public void setIs_top(int is_top) {
		this.is_top = is_top;
	}

	public Date getMark_time() {
		return mark_time;
	}

	public void setMark_time(Date mark_time) {
		this.mark_time = mark_time;
	}

	public int getStudent_type() {
		return student_type;
	}

	public void setStudent_type(int student_type) {
		this.student_type = student_type;
	}

	public Date getRelate_time() {
		return relate_time;
	}

	public void setRelate_time(Date relate_time) {
		this.relate_time = relate_time;
	}

	public int getIs_read() {
		return is_read;
	}

	public void setIs_read(int is_read) {
		this.is_read = is_read;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getIntegral() {
		return integral;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}

	public String getActivate_code() {
		return activate_code;
	}

	public void setActivate_code(String activate_code) {
		this.activate_code = activate_code;
	}

	/**
	 * 获取id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取手机号
	 */
	public String getTelphone() {
		return telphone;
	}

	/**
	 * 设置手机号
	 */
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	/**
	 * 获取姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取科目(理科/文科)
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * 设置科目(理科/文科)
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 获取所在年份
	 */
	public int getYears() {
		return years;
	}

	/**
	 * 设置所在年份
	 */
	public void setYears(int years) {
		this.years = years;
	}

	/**
	 * 获取省
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 设置省
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 获取市
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 设置市
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 获取区
	 */
	public String getArea() {
		return area;
	}

	/**
	 * 设置区
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * 获取预估分
	 */
	public int getYugufen() {
		return yugufen;
	}

	/**
	 * 设置预估分
	 */
	public void setYugufen(int yugufen) {
		this.yugufen = yugufen;
	}

	/**
	 * 获取高考分
	 */
	public int getGaokaofen() {
		return gaokaofen;
	}

	/**
	 * 设置高考分
	 */
	public void setGaokaofen(int gaokaofen) {
		this.gaokaofen = gaokaofen;
	}

	/**
	 * 获取录取通知书
	 */
	public String getNotice_book_url() {
		return notice_book_url;
	}

	/**
	 * 设置录取通知书
	 */
	public void setNotice_book_url(String notice_book_url) {
		this.notice_book_url = notice_book_url;
	}

	/**
	 * 获取上传录取通知书时间
	 */
	public Date getNotice_book_time() {
		return notice_book_time;
	}

	/**
	 * 设置上传录取通知书时间
	 */
	public void setNotice_book_time(Date notice_book_time) {
		this.notice_book_time = notice_book_time;
	}

	/**
	 * 获取注册时间
	 */
	public Date getReg_time() {
		return reg_time;
	}

	/**
	 * 设置注册时间
	 */
	public void setReg_time(Date reg_time) {
		this.reg_time = reg_time;
	}

	/**
	 * 获取登录时间
	 */
	public Date getLogin_time() {
		return login_time;
	}


	/**
	 * 设置登录时间
	 */
	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}

	/**
	 * 获取登录IP
	 */
	public String getLogin_ip() {
		return login_ip;
	}

	/**
	 * 设置登录IP
	 */
	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}

	/**
	 * 获取登录地址
	 */
	public String getLogin_addr() {
		return login_addr;
	}

	/**
	 * 设置登录地址
	 */
	public void setLogin_addr(String login_addr) {
		this.login_addr = login_addr;
	}

	/**
	 * 获取登录次数
	 */
	public int getLogin_number() {
		return login_number;
	}

	/**
	 * 设置登录次数
	 */
	public void setLogin_number(int login_number) {
		this.login_number = login_number;
	}

	/**
	 * 获取状态
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * 设置状态
	 */
	public void setStatus(int status) {
		this.status = status;
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

	public String getPic() {
		return pic;
	}

	public String getPicRealPath() { return picRealPath; }

	public void setPic(String pic) {
		this.pic = pic;
	}

	public void setPicRealPath(String picRealPath) { this.picRealPath = picRealPath; }

	public String getBaominghao() {
		return baominghao;
	}

	public void setBaominghao(String baominghao) {
		this.baominghao = baominghao;
	}

	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	public String getTonken() {
		return tonken;
	}

	public void setTonken(String tonken) {
		this.tonken = tonken;
	}

	public String getTicketno() {
		return ticketno;
	}

	public void setTicketno(String ticketno) {
		this.ticketno = ticketno;
	}

	public int getHighschool_id() {
		return highschool_id;
	}

	public void setHighschool_id(int highschool_id) {
		this.highschool_id = highschool_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHighschool_name() {
		return highschool_name;
	}

	public void setHighschool_name(String highschool_name) {
		this.highschool_name = highschool_name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getId_number() {
		return id_number;
	}

	public void setId_number(String id_number) {
		this.id_number = id_number;
	}

	public String getStudent_code() {
		return student_code;
	}

	public void setStudent_code(String student_code) {
		this.student_code = student_code;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getApp_showname() {
		return app_showname;
	}

	public void setApp_showname(String app_showname) {
		this.app_showname = app_showname;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Date getPay_time() {
		return pay_time;
	}

	public void setPay_time(Date pay_time) {
		this.pay_time = pay_time;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getWx_open_id() {
		return wx_open_id;
	}

	public void setWx_open_id(String wx_open_id) {
		this.wx_open_id = wx_open_id;
	}

	public String getQq_open_id() {
		return qq_open_id;
	}

	public void setQq_open_id(String qq_open_id) {
		this.qq_open_id = qq_open_id;
	}

	public int getIs_art() {
		return is_art;
	}

	public void setIs_art(int is_art) {
		this.is_art = is_art;
	}

	public int getRegist_channel() {
		return regist_channel;
	}

	public void setRegist_channel(int regist_channel) {
		this.regist_channel = regist_channel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getVisit_school_time() {
		return visit_school_time;
	}

	public void setVisit_school_time(Date visit_school_time) {
		this.visit_school_time = visit_school_time;
	}

	public int getIs_plan_abroad() {
		return is_plan_abroad;
	}

	public void setIs_plan_abroad(int is_plan_abroad) {
		this.is_plan_abroad = is_plan_abroad;
	}

	public int getIs_change_phone() {
		return is_change_phone;
	}

	public void setIs_change_phone(int is_change_phone) {
		this.is_change_phone = is_change_phone;
	}

	public int getIs_registration() {
		return is_registration;
	}

	public void setIs_registration(int is_registration) {
		this.is_registration = is_registration;
	}

	public int getIs_collection() {
		return is_collection;
	}

	public void setIs_collection(int is_collection) {
		this.is_collection = is_collection;
	}

	public int getIs_visit() {
		return is_visit;
	}

	public void setIs_visit(int is_visit) {
		this.is_visit = is_visit;
	}

	public String getTarget_abroad() {
		return target_abroad;
	}

	public void setTarget_abroad(String target_abroad) {
		this.target_abroad = target_abroad;
	}

	/**是否购买志愿卡（能上的大学）**/
	public boolean isBuyVcard() {
		if(this.type>1){
			return true;
		}
		return false;
	}

	public String getMini_app_id() {
		return mini_app_id;
	}

	public void setMini_app_id(String mini_app_id) {
		this.mini_app_id = mini_app_id;
	}

	public String getWeb_qq_open_id() {
		return web_qq_open_id;
	}

	public void setWeb_qq_open_id(String web_qq_open_id) {
		this.web_qq_open_id = web_qq_open_id;
	}

	public String getWeb_wx_open_id() {
		return web_wx_open_id;
	}

	public void setWeb_wx_open_id(String web_wx_open_id) {
		this.web_wx_open_id = web_wx_open_id;
	}

	public String getQq_unionid() {
		return qq_unionid;
	}

	public void setQq_unionid(String qq_unionid) {
		this.qq_unionid = qq_unionid;
	}

	public String getWx_unionid() {
		return wx_unionid;
	}

	public void setWx_unionid(String wx_unionid) {
		this.wx_unionid = wx_unionid;
	}

	public String getIcbc_open_id() {
		return icbc_open_id;
	}

	public void setIcbc_open_id(String icbc_open_id) {
		this.icbc_open_id = icbc_open_id;
	}

	public String getTarget_college() {
		return target_college;
	}

	public void setTarget_college(String target_college) {
		this.target_college = target_college;
	}

	public String getTarget_majors() {
		return target_majors;
	}

	public void setTarget_majors(String target_majors) {
		this.target_majors = target_majors;
	}
}
