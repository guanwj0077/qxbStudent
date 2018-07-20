package com.qxb.student.common.module.bean;


import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 问答专家
 *
 * @author
 */
public class Expert {

    private int id;

    /**
     * 上架状态
     **/
    private int status;
    /**
     * 登录状态
     **/
    private int is_login;
    /**
     * 创建时间
     **/
    private Date create_time;
    /**
     * 专家名称
     **/
    private String name;
    /**
     * 专家照片
     **/
    private String photo;
    /**
     * 服务省份
     **/
    private String province;
    /**
     * 擅长服务
     **/
    private String good_service;
    /**
     * 简介
     **/
    private String intro;
    /**
     * 专家所在省份
     **/
    private String expert_province;
    /**
     * 专家所在区域
     **/
    private String expert_area;
    /**
     * 专家所在城市
     **/
    private String expert_city;
    /**
     * 专家详细地址
     **/
    private String expert_detail_addr;
    /**
     * 在线时长
     **/
    private String time_online;
    /**
     * 联系方式
     **/
    private String phone;
    /**
     * 附近简历（图片）
     **/
    private String resume;
    /**
     * 一句话简介
     **/
    private String a_word_intro;
    /**
     * 开户行
     **/
    private String opening_bank;
    /**
     * 开户账号
     **/
    private String bank_account;
    /**
     * 开户人姓名
     **/
    private String bank_name;
    /**
     * 账号备注
     **/
    private String bank_account_remark;
    /**
     * 专家邀请码分享二维码图片链接
     **/
    private String invite_barcode_img;

    /******非表字段*******/
    /**
     * 专家标签
     **/
    private String labels;
    /**
     * 回答数
     **/
    private int answer_count;
    /**
     * 被点赞次数
     **/
    private int praise_count;
    /**
     * 专家所在地省份名称
     **/
    private String expert_province_name;
    /**
     * 专家所在地城市名称
     **/
    private String expert_city_name;
    /**
     * 专家已完成订单数
     **/
    private int expert_completed;
    /**
     * 专家已关闭订单数
     **/
    private int expert_closed;
    /**
     * 提问价格
     */
    private double answer_price;
    /**
     * 热门回答列表
     */
    private List<ExpertQuestion> hotAnswerList;
    /**
     * 专家服务
     */
    private List<Map<String, Object>> serviceList;
    /**
     * 专家服务
     */
    private List<Map<String, Object>> onLineServiceList;
    /**
     * 结算金额
     **/
    private double settle_amount;
    /**
     * 城市中文名
     */
    private String city_name;
    /**
     * 是否为热门专家     1为非热门专家,2为热门专家
     **/
    private int is_hot;
    /**
     * 是否为今日大咖     1否,2是
     **/
    private int app_hot;

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getOpening_bank() {
        return opening_bank;
    }

    public void setOpening_bank(String opening_bank) {
        this.opening_bank = opening_bank;
    }

    public String getBank_account() {
        return bank_account;
    }

    public void setBank_account(String bank_account) {
        this.bank_account = bank_account;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_account_remark() {
        return bank_account_remark;
    }

    public void setBank_account_remark(String bank_account_remark) {
        this.bank_account_remark = bank_account_remark;
    }

    public double getSettle_amount() {
        return settle_amount;
    }

    public void setSettle_amount(double settle_amount) {
        this.settle_amount = settle_amount;
    }

    public List<Map<String, Object>> getOnLineServiceList() {
        return onLineServiceList;
    }

    public void setOnLineServiceList(List<Map<String, Object>> onLineServiceList) {
        this.onLineServiceList = onLineServiceList;
    }

    public List<Map<String, Object>> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Map<String, Object>> serviceList) {
        this.serviceList = serviceList;
    }

    public List<ExpertQuestion> getHotAnswerList() {
        return hotAnswerList;
    }

    public void setHotAnswerList(List<ExpertQuestion> hotAnswerList) {
        this.hotAnswerList = hotAnswerList;
    }

    public double getAnswer_price() {
        return answer_price;
    }

    public void setAnswer_price(double answer_price) {
        this.answer_price = answer_price;
    }

    public int getExpert_completed() {
        return expert_completed;
    }

    public void setExpert_completed(int expert_completed) {
        this.expert_completed = expert_completed;
    }

    public int getExpert_closed() {
        return expert_closed;
    }

    public void setExpert_closed(int expert_closed) {
        this.expert_closed = expert_closed;
    }

    public String getExpert_province_name() {
        return expert_province_name;
    }

    public void setExpert_province_name(String expert_province_name) {
        this.expert_province_name = expert_province_name;
    }

    public String getExpert_city_name() {
        return expert_city_name;
    }

    public void setExpert_city_name(String expert_city_name) {
        this.expert_city_name = expert_city_name;
    }

    public int getAnswer_count() {
        return answer_count;
    }

    public void setAnswer_count(int answer_count) {
        this.answer_count = answer_count;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setIs_login(int is_login) {
        this.is_login = is_login;
    }

    public int getIs_login() {
        return is_login;
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

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setGood_service(String good_service) {
        this.good_service = good_service;
    }

    public String getGood_service() {
        return good_service;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getIntro() {
        return intro;
    }

    public void setExpert_province(String expert_province) {
        this.expert_province = expert_province;
    }

    public String getExpert_province() {
        return expert_province;
    }

    public void setExpert_area(String expert_area) {
        this.expert_area = expert_area;
    }

    public String getExpert_area() {
        return expert_area;
    }

    public void setExpert_city(String expert_city) {
        this.expert_city = expert_city;
    }

    public String getExpert_city() {
        return expert_city;
    }

    public void setExpert_detail_addr(String expert_detail_addr) {
        this.expert_detail_addr = expert_detail_addr;
    }

    public String getExpert_detail_addr() {
        return expert_detail_addr;
    }

    public void setTime_online(String time_online) {
        this.time_online = time_online;
    }

    public String getTime_online() {
        return time_online;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getResume() {
        return resume;
    }

    public String getA_word_intro() {
        return a_word_intro;
    }

    public void setA_word_intro(String a_word_intro) {
        this.a_word_intro = a_word_intro;
    }

    public String getInvite_barcode_img() {
        return invite_barcode_img;
    }

    public void setInvite_barcode_img(String invite_barcode_img) {
        this.invite_barcode_img = invite_barcode_img;
    }

    public int getPraise_count() {
        return praise_count;
    }

    public void setPraise_count(int praise_count) {
        this.praise_count = praise_count;
    }

    public int getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(int is_hot) {
        this.is_hot = is_hot;
    }

    public int getApp_hot() {
        return app_hot;
    }

    public void setApp_hot(int app_hot) {
        this.app_hot = app_hot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
