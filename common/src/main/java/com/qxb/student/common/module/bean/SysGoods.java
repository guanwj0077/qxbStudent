package com.qxb.student.common.module.bean;

import java.util.Date;

/**
 * 商品表
 * @author qianle
 */
public class SysGoods{

	private int id;
	private String code;	//商品编码 100C1001
	private String product_code;	//产品编码
	private String type;	//商品类型
	private String goods_relate; //商品关联
	private int goods_relate_id;//商品关联id
	private String title;	//显示名称
	private String name;	//名称
	private String descr;	//描述
	private String remark;	//价格备注
	private int status;//状态
	private int show_order;	//显示顺序
	private String unit;//单位
	private double price_origin;//原价
	private double price_sell;//售价
	private double price_ratio;//折扣
	private long start_time;//开始时间
	private long end_time;//结束时间
	private long create_time;//创建时间
	private String create_user;//创建人
	private String success_notice;//成功提示
	
	//积分新增字段
	private int integral_max;	//可使用积分最大数
	private String detail_page;//商品详情页面
	
	//订单完成数量
	private int complete_order_num;
	//评价条数
	private int evaluate_num;
	//平均评价得分
	private double average_evaluate_score;
	
	//是否参与活动  1 参与 0 未参与
	private int part_activity;
	//活动价（促销价）
	private double promote_price;
	//活动名称
	private String price_describe;
	//顾问名称,关联顾问名称
	private String adviser_name;
	//关联的个人顾问、机构员工顾问id
	private int item_id;
	//顾问账户 关联用户名称,手机号码
	private String item_phone;
	//顾问机构,关联机构名称
	private String group_name;
	//关联头像
	private String item_pic;
	//产品名称
	private String product_name;
	//顾问id
	private int adviser_id;

	private String abroadGoodsName;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGoods_relate() {
		return goods_relate;
	}

	public void setGoods_relate(String goods_relate) {
		this.goods_relate = goods_relate;
	}

	public int getGoods_relate_id() {
		return goods_relate_id;
	}

	public void setGoods_relate_id(int goods_relate_id) {
		this.goods_relate_id = goods_relate_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getShow_order() {
		return show_order;
	}

	public void setShow_order(int show_order) {
		this.show_order = show_order;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getPrice_origin() {
		return price_origin;
	}

	public void setPrice_origin(double price_origin) {
		this.price_origin = price_origin;
	}

	public double getPrice_sell() {
		return price_sell;
	}

	public void setPrice_sell(double price_sell) {
		this.price_sell = price_sell;
	}

	public double getPrice_ratio() {
		return price_ratio;
	}

	public void setPrice_ratio(double price_ratio) {
		this.price_ratio = price_ratio;
	}

	public long getStart_time() {
		return start_time;
	}

	public void setStart_time(long start_time) {
		this.start_time = start_time;
	}

	public long getEnd_time() {
		return end_time;
	}

	public void setEnd_time(long end_time) {
		this.end_time = end_time;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	public String getSuccess_notice() {
		return success_notice;
	}

	public void setSuccess_notice(String success_notice) {
		this.success_notice = success_notice;
	}

	public int getIntegral_max() {
		return integral_max;
	}

	public void setIntegral_max(int integral_max) {
		this.integral_max = integral_max;
	}

	public String getDetail_page() {
		return detail_page;
	}

	public void setDetail_page(String detail_page) {
		this.detail_page = detail_page;
	}

	public int getComplete_order_num() {
		return complete_order_num;
	}

	public void setComplete_order_num(int complete_order_num) {
		this.complete_order_num = complete_order_num;
	}

	public int getEvaluate_num() {
		return evaluate_num;
	}

	public void setEvaluate_num(int evaluate_num) {
		this.evaluate_num = evaluate_num;
	}

	public double getAverage_evaluate_score() {
		return average_evaluate_score;
	}

	public void setAverage_evaluate_score(double average_evaluate_score) {
		this.average_evaluate_score = average_evaluate_score;
	}

	public int getPart_activity() {
		return part_activity;
	}

	public void setPart_activity(int part_activity) {
		this.part_activity = part_activity;
	}

	public double getPromote_price() {
		return promote_price;
	}

	public void setPromote_price(double promote_price) {
		this.promote_price = promote_price;
	}

	public String getPrice_describe() {
		return price_describe;
	}

	public void setPrice_describe(String price_describe) {
		this.price_describe = price_describe;
	}

	public String getAdviser_name() {
		return adviser_name;
	}

	public void setAdviser_name(String adviser_name) {
		this.adviser_name = adviser_name;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_phone() {
		return item_phone;
	}

	public void setItem_phone(String item_phone) {
		this.item_phone = item_phone;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public String getItem_pic() {
		return item_pic;
	}

	public void setItem_pic(String item_pic) {
		this.item_pic = item_pic;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getAdviser_id() {
		return adviser_id;
	}

	public void setAdviser_id(int adviser_id) {
		this.adviser_id = adviser_id;
	}

	public String getAbroadGoodsName() {
		return abroadGoodsName;
	}

	public void setAbroadGoodsName(String abroadGoodsName) {
		this.abroadGoodsName = abroadGoodsName;
	}
}
