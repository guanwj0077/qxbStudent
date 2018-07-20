package com.qxb.student.common.module.bean;


import java.util.Map;
import java.util.Set;

/**
 * 专家问题实体类
 * @author
 */
public class ExpertQuestion {

    /**
     * 问题id
     */
    private int id;

    /**
     * 订单id
     **/
    private int order_id;
    /**
     * 学生id
     **/
    private int stu_id;
    /**
     * 专家id
     **/
    private int expert_id;
    /**
     * 专家名称
     **/
    private String expert_name;
    /**
     * 问题状态
     **/
    private int status;
    /**
     * 问题类型 1.志愿填报2.自主招生3.艺术招生4.学习指导5.学科专业
     */
    private int type;
    /**
     * 问题创建时间
     */
    private Long create_time;
    /**
     * 学生省份
     **/
    private String stu_province;
    /**
     * 问题内容
     **/
    private String content;
    /**
     * 问题答案的id
     */
    private int answer_id;
    /**非表字段**/
    /**
     * 学生昵称
     */
    private String stu_name;
    /**
     * 学生真实姓名
     **/
    private String student_name;
    /**
     * 学生手机号码
     **/
    private String stu_phone;
    /**
     * 专家手机号码
     **/
    private String expert_phone;
    /**
     * 学生头像
     */
    private String stu_pic;
    /**
     * 问题内容
     */
    private String question;
    /**
     * 答案内容
     */
    private String answer;
    /**
     * 问题回答时间
     */
    private Long answer_time;
    /**
     * 学生提问问题在该学生所有问题里的编号
     */
    private int stu_question_no;
    /**
     * 专家头像
     */
    private String photo;
    /**
     * 围观价格
     */
    private double look_price;
    /**
     * 问题价格
     */
    private double question_price;
    /**
     * 订单支付状态
     */
    private int pay_status;
    /**
     * 点赞数
     */
    private int praise_count;
    /**
     * 围观数
     */
    private int look_count;
    /**
     * 订单关联状态
     */
    private int correlate_status;

    /**
     * 是否围观
     */
    private int is_look;
    /**
     * 是否对回答点赞
     */
    private int is_praise;
    /**
     * 订单状态
     */
    private int order_status;
    /**
     * 热度
     **/
    private int heat_count;

    /**非表字段**/
    /**
     * 专家的服务类型
     */
    private String good_service;
    /**
     * 专家的一句话简介
     */
    private String a_word_intro;
    /**
     * 提问学生的省份
     */
    private String stu_province_name;
    /**
     * 提问学生的文理科
     */
    private String stu_subject;
    /**
     * 提问学生的性别
     */
    private int stu_sex;
    /**
     * 提问时间
     */
    private String create_timeString;
    /**
     * 回答时间
     */
    private String answer_timeString;
    /**
     * 提问学生头像
     */
    private String stuPicRealPath;
    /**
     * 专家头像
     */
    private String photoRealPath;

    /**
     * 提问内容(后台书写错误)
     */
    private String centent;
    /**
     * 专家头像
     */
    private String expert_pic;

    /**
     * 问题状态
     */
    private String question_status;
    /**
     * 商品编码
     */
    private String goods_code;
    /**
     * 显示专家升级服务 1：显示
     */
    private int upgradeFlag;
    /**
     * 专家升级服务
     */
    private Map<String, Object> upgrade;
    /**
     * 专家支持的问答类型
     */
    private Set<Integer> questionTypeList;

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    public int getPraise_count() {
        return praise_count;
    }

    public void setPraise_count(int praise_count) {
        this.praise_count = praise_count;
    }

    public int getLook_count() {
        return look_count;
    }

    public void setLook_count(int look_count) {
        this.look_count = look_count;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStu_phone() {
        return stu_phone;
    }

    public void setStu_phone(String stu_phone) {
        this.stu_phone = stu_phone;
    }

    public String getExpert_phone() {
        return expert_phone;
    }

    public void setExpert_phone(String expert_phone) {
        this.expert_phone = expert_phone;
    }

    public int getIs_look() {
        return is_look;
    }

    public void setIs_look(int is_look) {
        this.is_look = is_look;
    }

    public double getLook_price() {
        return look_price;
    }

    public void setLook_price(double look_price) {
        this.look_price = look_price;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setExpert_id(int expert_id) {
        this.expert_id = expert_id;
    }

    public int getExpert_id() {
        return expert_id;
    }

    public String getExpert_name() {
        return expert_name;
    }

    public void setExpert_name(String expert_name) {
        this.expert_name = expert_name;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public String getCreate_timeString() {
        return create_timeString;
    }

    public void setStu_province(String stu_province) {
        this.stu_province = stu_province;
    }

    public String getStu_province() {
        return stu_province;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getAnswer_time() {
        return answer_time;
    }

    public String getAnswer_timeString() {
        return answer_timeString;
    }

    public void setAnswer_time(Long answer_time) {
        this.answer_time = answer_time;
    }

    public int getStu_question_no() {
        return stu_question_no;
    }

    public void setStu_question_no(int stu_question_no) {
        this.stu_question_no = stu_question_no;
    }

    public String getStu_pic() {
        return stu_pic;
    }

    public String getStuPicRealPath() {
        return stuPicRealPath;
    }

    public void setStu_pic(String stu_pic) {
        this.stu_pic = stu_pic;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPhotoRealPath() {
        return photoRealPath;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getCorrelate_status() {
        return correlate_status;
    }

    public void setCorrelate_status(int correlate_status) {
        this.correlate_status = correlate_status;
    }

    public int getPay_status() {
        return pay_status;
    }

    public void setPay_status(int pay_status) {
        this.pay_status = pay_status;
    }

    public int getIs_praise() {
        return is_praise;
    }

    public void setIs_praise(int is_praise) {
        this.is_praise = is_praise;
    }

    public double getQuestion_price() {
        return question_price;
    }

    public void setQuestion_price(double question_price) {
        this.question_price = question_price;
    }

    public int getHeat_count() {
        return heat_count;
    }

    public void setHeat_count(int heat_count) {
        this.heat_count = heat_count;
    }

    public String getGood_service() {
        return good_service;
    }

    public void setGood_service(String good_service) {
        this.good_service = good_service;
    }

    public String getA_word_intro() {
        return a_word_intro;
    }

    public void setA_word_intro(String a_word_intro) {
        this.a_word_intro = a_word_intro;
    }

    public String getStu_province_name() {
        return stu_province_name;
    }

    public void setStu_province_name(String stu_province_name) {
        this.stu_province_name = stu_province_name;
    }

    public String getStu_subject() {
        return stu_subject;
    }

    public void setStu_subject(String stu_subject) {
        this.stu_subject = stu_subject;
    }

    public int getStu_sex() {
        return stu_sex;
    }

    public void setStu_sex(int stu_sex) {
        this.stu_sex = stu_sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCreate_timeString(String create_timeString) {
        this.create_timeString = create_timeString;
    }

    public void setAnswer_timeString(String answer_timeString) {
        this.answer_timeString = answer_timeString;
    }

    public void setStuPicRealPath(String stuPicRealPath) {
        this.stuPicRealPath = stuPicRealPath;
    }

    public void setPhotoRealPath(String photoRealPath) {
        this.photoRealPath = photoRealPath;
    }

    public String getCentent() {
        return centent;
    }

    public void setCentent(String centent) {
        this.centent = centent;
    }

    public String getExpert_pic() {
        return expert_pic;
    }

    public void setExpert_pic(String expert_pic) {
        this.expert_pic = expert_pic;
    }

    public String getQuestion_status() {
        return question_status;
    }

    public void setQuestion_status(String question_status) {
        this.question_status = question_status;
    }

    public String getGoods_code() {
        return goods_code;
    }

    public void setGoods_code(String goods_code) {
        this.goods_code = goods_code;
    }

    public int getUpgradeFlag() {
        return upgradeFlag;
    }

    public void setUpgradeFlag(int upgradeFlag) {
        this.upgradeFlag = upgradeFlag;
    }

    public Map<String, Object> getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(Map<String, Object> upgrade) {
        this.upgrade = upgrade;
    }

    public Set<Integer> getQuestionTypeList() {
        return questionTypeList;
    }

    public void setQuestionTypeList(Set<Integer> questionTypeList) {
        this.questionTypeList = questionTypeList;
    }
}
