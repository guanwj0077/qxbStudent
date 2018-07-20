package com.qxb.student.common.module.bean;

import java.util.Date;
import java.util.Map;

/**
 * 留学顾问
 * @author zhoujie
 */
public class AbroadAdviser{

	private int id;
	/** 用户id */
	private int user_id;
	/** 账户id */
	private int account_id;
	/** 状态 1开启 2关闭*/
	private int status;
	/** 服务类型  1境内服务 2境外服务 3全程服务 4境内外服务*/
	private int serve_type;
	/** 创建时间 */
	private Date create_time;
	/** 名称 */
	private String name;
	/**头像 */
	private String pic;
	private String picRealPath;

	/** 从业经验 */
	private String remark;
	/** 服务地区 */
	private String serve_area;
	/** 学位 */
	private String degree;
	/** 擅长服务 */
	private String good_at_service;
	/** 擅长专业 */
	private String good_at_professional;
	/** 所在省份 */
	private String province_code;
	/** 所在城市 */
	private String city_code;
	/** 所在区域 */
	private String area_code;
	/** 序号 **/
	private int show_order;
	/** 手机号 **/
	private String telphone;
	/** 个人自述 **/
	private String readme;
	/** 会员等级 0：普通会员 1：VIP会员 2：超级VIP会员*/
	private int level;
	/** 收款备注*/
	private String note;
	
	/** 所在区域名称 */
	private String area_name;
	/**类型，添加商品使用该实体，1.个人顾问，2.机构顾问**/
	private int type;
	/** 已完成订单数 （已服务人数） **/
	private int order_num;
	/** 综合评分 **/
	private double average;
	/** 5分好评人数 **/
	private int good_num;
	/** 机构名称 */
	private String group_name;
	/** 机构id */
	private int group_id;
	/** 是否平台认证 1是 2否 **/
	private int is_platform;
	/** 学生是否关注该顾问 1是 2否 **/
	private int is_attention;

	private String serve_area_name;

	private Map<String, String> good_at_service_name;

	private String province_name;

	private String city_name;

	private Object[] remarkText;

	private String readmeUrl;

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public int getServe_type() {
		return serve_type;
	}

	public void setServe_type(int serve_type) {
		this.serve_type = serve_type;
	}

	/**
	 * 获取境内外服务的文本
	 * @return 例：境外服务
	 */
	public String getServe_type_name() {
		if(serve_type==1){
			return "境内服务";
		}else if(serve_type==2){
			return "境外服务";
		}else if(serve_type==3){
			return "全程服务";
		}else if(serve_type==4){
			return "境内外服务";
		}
		return "";
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPic() {
		return pic;
	}
	
	public String getPicRealPath() {
		return picRealPath;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public void setServe_area(String serve_area) {
		this.serve_area = serve_area;
	}

	public String getServe_area() {
		return serve_area;
	}
	
	/**
	 * 获取服务区域文本
	 * @return 例：美国,英国
	 */
	public String getServe_area_name() {
		return serve_area_name;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getDegree() {
		return degree;
	}

	public void setGood_at_service(String good_at_service) {
		this.good_at_service = good_at_service;
	}

	public String getGood_at_service() {
		return good_at_service;
	}
	
	/**
	 * 获取擅长服务的文本
	 */
	public Map<String, String> getGood_at_service_name() {
		return good_at_service_name;
	}

	public void setGood_at_professional(String good_at_professional) {
		this.good_at_professional = good_at_professional;
	}

	public String getGood_at_professional() {
		return good_at_professional;
	}

	public void setProvince_code(String province_code) {
		this.province_code = province_code;
	}

	public String getProvince_code() {
		return province_code;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProvince_name() {
		return province_name;
	}

	public String getCity_code() {
		return city_code;
	}

	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}

	public String getArea_code() {
		return area_code;
	}

	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}

	public String getCity_name() {
		return city_name;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	public int getShow_order() {
		return show_order;
	}

	public void setShow_order(int show_order) {
		this.show_order = show_order;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public String getReadme() {
		return readme;
	}

	public void setReadme(String readme) {
		this.readme = readme;
	}

	public int getGood_num() {
		return good_num;
	}

	public void setGood_num(int good_num) {
		this.good_num = good_num;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public int getIs_platform() {
		return is_platform;
	}

	public void setIs_platform(int is_platform) {
		this.is_platform = is_platform;
	}

	public int getIs_attention() {
		return is_attention;
	}

	public void setIs_attention(int is_attention) {
		this.is_attention = is_attention;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	
	//个人简历返回数组    [{"time":"2013~2016","text":"第一个"},{"time":"2016~2018","text":"第二个"}]
	public Object[] getRemarkText(){
		return remarkText;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public  String getReadmeUrl(){
		return readmeUrl;
	}
}
