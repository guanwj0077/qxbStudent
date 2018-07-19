package com.qxb.student.common.module.bean;

/**
 * 订单信息实体类
 *
 * @author
 */

public class SysOrder {

    /**
     * 订单号
     */
    private String order_no;
    /**
     * 交易号
     */
    private String transaction_no;
    /**
     * 商品名称
     */
    private String goods_name;
    /**
     * 商品id  → 商品code
     */
    private String goods_id;
    /**
     * 商品关联
     */
    private String goods_obj_relate;
    /**
     * 商品编码× → 商品关联对象id
     */
    private String goods_obj_code;
    /**
     * 商品描述
     */
    private String descr;
    /**
     * 账户id
     */
    private int account_id;
    /**
     * 主体id
     */
    private int subject_id;
    /**
     * 用户id
     */
    private int user_id;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 年份
     */
    private int create_year;
    /**
     * 月份
     */
    private int create_month;
    /**
     * 创建时间
     */
    private Long create_time;
    /**
     * 创建人
     */
    private String create_user;
    /**
     * 支付状态 1.等待支付 2.支付完成 3.取消支付
     */
    private int pay_status;
    /**
     * 订单状态
     */
    private int status;
    /**
     * 支付方式
     */
    private String pay_way;
    /**
     * 支付渠道
     */
    private String pay_channel;
    /**
     * 支付价格
     */
    private double pay_price;
    /**
     * 支付时间
     */
    private Long pay_time;
    /**
     * 客户ip
     */
    private String client_ip;
    /**
     * 备注
     */
    private String remark;
    /**
     * 注册渠道
     */
    private String chan;
    /**
     * 系统类型
     */
    private int os_type;
    /**
     * 使用积分
     */
    private int integral;
    /**
     * 有效期起
     */
    private String start_time;
    /**
     * 有效期结束
     */
    private String end_time;
    /**
     * 价格
     */
    private Double price_sell;
    /**
     * 商品是否有效
     */
    private int goods_status;

    /**
     * 关联ID
     */
    private int correlate_id;
    /**
     * 关联状态
     * 1.待支付，2.完善资料，3.待处理，4.处理中，5.待评价，6.订单关闭，7.订单完成
     */
    private int correlate_status;
    /**
     * 退款金额
     */
    private double refund_amount;
    /**
     * 退款状态
     */
    private int refund_status;
    /**
     * 结算金额
     */
    private double clearing_amount;
    /**
     * 结算状态
     */
    private int clearing_status;

    /**
     * 订单完成时间
     **/
    private Long finish_time;

    /**
     * 抽成金额
     **/
    private double bonus;
    /**
     * 退款备注
     */
    private String refund_describe;
    /**
     * 显示状态
     */
    private int show_status;
    /**
     * 退款状态
     */
    private int refund_type;
    /**
     * 退款时间
     */
    private Long refund_time;
    /**
     * 结算时间
     **/
    private Long clearing_time;
    /**
     * Ping ++ 支付订单号
     */
    private String ch_id;
    /**
     * 收款人账户id
     **/
    private int payee_account;
    /**
     * 关联学生的id
     */
    private int relate_stu_id;
    /**
     * 返利关联的红包活动ID
     */
    private int rebate_activity_id;
    /**
     * 是否开启红包 1.已开启 其他未开启
     */
    private int is_open;
    /**
     * 活动价
     **/
    private double promote_price;
    /**
     * 是否参加活动   1 参与 0 未参与
     **/
    private int part_activity;

    /**非表字段**/
    /**
     * 收款人姓名
     */
    private String payee_name;
    /**
     * 收款人手机号
     */
    private String payee_telphone;
    /**
     * 机构名称
     */
    private String group_name;
    /**
     * 顾问Id
     */
    private int adviser_id;
    /**
     * 顾问类型 1.个人顾问 2.机构顾问
     */
    private int adviser_type;
    /**
     * 收款人备注
     */
    private String payee_note;
    /**
     * 院校端是否显示订单 1不显示 其他值 显示
     */
    private int college_show_status;
    private String pay_timeString;
    private Long upLong_time;

    public int getCollege_show_status() {
        return college_show_status;
    }

    public void setCollege_show_status(int college_show_status) {
        this.college_show_status = college_show_status;
    }

    public String getPayee_note() {
        return payee_note;
    }

    public void setPayee_note(String payee_note) {
        this.payee_note = payee_note;
    }

    public int getAdviser_id() {
        return adviser_id;
    }

    public void setAdviser_id(int adviser_id) {
        this.adviser_id = adviser_id;
    }

    public int getAdviser_type() {
        return adviser_type;
    }

    public void setAdviser_type(int adviser_type) {
        this.adviser_type = adviser_type;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getPayee_telphone() {
        return payee_telphone;
    }

    public void setPayee_telphone(String payee_telphone) {
        this.payee_telphone = payee_telphone;
    }

    public String getPayee_name() {
        return payee_name;
    }

    public void setPayee_name(String payee_name) {
        this.payee_name = payee_name;
    }

    public int getIs_open() {
        return is_open;
    }

    public void setIs_open(int is_open) {
        this.is_open = is_open;
    }

    public int getRebate_activity_id() {
        return rebate_activity_id;
    }

    public void setRebate_activity_id(int rebate_activity_id) {
        this.rebate_activity_id = rebate_activity_id;
    }

    public int getRelate_stu_id() {
        return relate_stu_id;
    }

    public void setRelate_stu_id(int relate_stu_id) {
        this.relate_stu_id = relate_stu_id;
    }

    public int getPayee_account() {
        return payee_account;
    }

    public void setPayee_account(int payee_account) {
        this.payee_account = payee_account;
    }

    public String getCh_id() {
        return ch_id;
    }

    public void setCh_id(String ch_id) {
        this.ch_id = ch_id;
    }

    /**
     * 非表字段
     **/
    /**
     * 专家评星
     */
    private int star;
    /**
     * 问题内容
     */
    private String question_content;
    /**
     * 回答时间
     */
    private Long answer_time;
    /**
     * 旁听次数
     */
    private int looknumber;
    /**
     * 问题点赞次数
     */
    private int praisenumber;
    /**
     * 学生昵称
     */
    private String student_nick_name;
    /**
     * 学生真实姓名
     */
    private String student_name;
    /**
     * 学生手机号码
     */
    private String student_phone;
    /**
     * 学生省份
     */
    private String student_province;
    /**
     * 商品编码
     */
    private String goods_code;
    /**
     * 产品编码
     */
    private String goods_product_code;
    /**
     * 专家姓名
     */
    private String expert_name;
    /**
     * 专家手机号码
     */
    private String expert_phone;
    /**
     * 问答提问时间
     */
    private Long question_time;
    /**
     * 围观时间
     */
    private Long question_look_time;
    /**
     * 订单资料完善时间
     */
    private Long msg_time;
    /**
     * 进入待处理状态时间
     */
    private Long pengding_time;
    /**
     * 回答内容
     */
    private String answer_content;
    /**
     * 服务完成时间
     */
    private Long serviced_time;
    /**
     * 是否对回答点赞
     */
    private int praise;
    /**
     * 评价时间
     */
    private Long evaluate_time;
    /**
     * 订单关闭时间
     */
    private Long order_cancel_time;
    /**
     * 回答ID
     */
    private int answer_id;
    /**
     * 专家ID
     */
    private int expert_id;
    /**
     * 问题ID
     */
    private int question_id;
    /**
     * 围观时答案ID
     */
    private int look_answer_id;
    /**
     * 围观时是否评价：1已评价 0未评价
     */
    private int has_look_praise;
    /**
     * user_student表中的name
     */
    private String name;
    /**
     * 实得金额
     */
    private double money;
    /**
     * 专家评价标签拼接字符串
     */
    private String evaluate_label;
    /**
     * 专家待处理回答问题总量
     */
    private int undeal_question_num;
    /**
     * 专家待处理一对一问题总量
     */
    private int undeal_wish_num;
    /**
     * 专家待处理自主招生问题总量
     */
    private int undeal_freedom_num;

    /**
     * 自招人工服务流程
     **/
    private String artificial_procedure;

    private String staffPic;

    private String staffName;

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffPic() {
        return staffPic;
    }

    public void setStaffPic(String staffPic) {
        this.staffPic = staffPic;
    }

    public Long getPengding_time() {
        return pengding_time;
    }

    public void setPengding_time(Long pengding_time) {
        this.pengding_time = pengding_time;
    }

    public Long getClearing_time() {
        return clearing_time;
    }

    public void setClearing_time(Long clearing_time) {
        this.clearing_time = clearing_time;
    }

    public Long getRefund_time() {
        return refund_time;
    }

    public void setRefund_time(Long refund_time) {
        this.refund_time = refund_time;
    }

    public int getLook_answer_id() {
        return look_answer_id;
    }

    public void setLook_answer_id(int look_answer_id) {
        this.look_answer_id = look_answer_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getExpert_id() {
        return expert_id;
    }

    public void setExpert_id(int expert_id) {
        this.expert_id = expert_id;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public Long getOrder_cancel_time() {
        return order_cancel_time;
    }

    public void setOrder_cancel_time(Long order_cancel_time) {
        this.order_cancel_time = order_cancel_time;
    }

    public int getShow_status() {
        return show_status;
    }

    public void setShow_status(int show_status) {
        this.show_status = show_status;
    }

    public int getRefund_type() {
        return refund_type;
    }

    public void setRefund_type(int refund_type) {
        this.refund_type = refund_type;
    }

    public String getRefund_describe() {
        return refund_describe;
    }

    public void setRefund_describe(String refund_describe) {
        this.refund_describe = refund_describe;
    }

    public Long getEvaluate_time() {
        return evaluate_time;
    }

    public void setEvaluate_time(Long evaluate_time) {
        this.evaluate_time = evaluate_time;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public Long getServiced_time() {
        return serviced_time;
    }

    public void setServiced_time(Long serviced_time) {
        this.serviced_time = serviced_time;
    }

    public String getAnswer_content() {
        return answer_content;
    }

    public void setAnswer_content(String answer_content) {
        this.answer_content = answer_content;
    }

    public Long getMsg_time() {
        return msg_time;
    }

    public void setMsg_time(Long msg_time) {
        this.msg_time = msg_time;
    }

    public String getStudent_province() {
        return student_province;
    }

    public void setStudent_province(String student_province) {
        this.student_province = student_province;
    }

    public Long getQuestion_look_time() {
        return question_look_time;
    }

    public void setQuestion_look_time(Long question_look_time) {
        this.question_look_time = question_look_time;
    }

    public Long getQuestion_time() {
        return question_time;
    }

    public void setQuestion_time(Long question_time) {
        this.question_time = question_time;
    }

    public String getStudent_nick_name() {
        return student_nick_name;
    }

    public void setStudent_nick_name(String student_nick_name) {
        this.student_nick_name = student_nick_name;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(String student_phone) {
        this.student_phone = student_phone;
    }

    public String getGoods_code() {
        return goods_code;
    }

    public void setGoods_code(String goods_code) {
        this.goods_code = goods_code;
    }

    public String getGoods_product_code() {
        return goods_product_code;
    }

    public void setGoods_product_code(String goods_product_code) {
        this.goods_product_code = goods_product_code;
    }

    public String getExpert_name() {
        return expert_name;
    }

    public void setExpert_name(String expert_name) {
        this.expert_name = expert_name;
    }

    public String getExpert_phone() {
        return expert_phone;
    }

    public void setExpert_phone(String expert_phone) {
        this.expert_phone = expert_phone;
    }

    public double getRefund_amount() {
        return refund_amount;
    }

    public void setRefund_amount(double refund_amount) {
        this.refund_amount = refund_amount;
    }

    public int getRefund_status() {
        return refund_status;
    }

    public void setRefund_status(int refund_status) {
        this.refund_status = refund_status;
    }

    public double getClearing_amount() {
        return clearing_amount;
    }

    public void setClearing_amount(double clearing_amount) {
        this.clearing_amount = clearing_amount;
    }

    public int getClearing_status() {
        return clearing_status;
    }

    public void setClearing_status(int clearing_status) {
        this.clearing_status = clearing_status;
    }

    public int getCorrelate_id() {
        return correlate_id;
    }

    public void setCorrelate_id(int correlate_id) {
        this.correlate_id = correlate_id;
    }

    public int getCorrelate_status() {
        return correlate_status;
    }

    public void setCorrelate_status(int correlate_status) {
        this.correlate_status = correlate_status;
    }

    public int getGoods_status() {
        return goods_status;
    }

    public void setGoods_status(int goods_status) {
        this.goods_status = goods_status;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Double getPrice_sell() {
        return price_sell;
    }

    public void setPrice_sell(Double price_sell) {
        this.price_sell = price_sell;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getTransaction_no() {
        return transaction_no;
    }

    public void setTransaction_no(String transaction_no) {
        this.transaction_no = transaction_no;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_obj_relate() {
        return goods_obj_relate;
    }

    public void setGoods_obj_relate(String goods_obj_relate) {
        this.goods_obj_relate = goods_obj_relate;
    }

    public String getGoods_obj_code() {
        return goods_obj_code;
    }

    public void setGoods_obj_code(String goods_obj_code) {
        this.goods_obj_code = goods_obj_code;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCreate_year() {
        return create_year;
    }

    public void setCreate_year(int create_year) {
        this.create_year = create_year;
    }

    public int getCreate_month() {
        return create_month;
    }

    public void setCreate_month(int create_month) {
        this.create_month = create_month;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public int getPay_status() {
        return pay_status;
    }

    public void setPay_status(int pay_status) {
        this.pay_status = pay_status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPay_way() {
        return pay_way;
    }

    public void setPay_way(String pay_way) {
        this.pay_way = pay_way;
    }

    public String getPay_channel() {
        return pay_channel;
    }

    public void setPay_channel(String pay_channel) {
        this.pay_channel = pay_channel;
    }

    public double getPay_price() {
        return pay_price;
    }

    public void setPay_price(double pay_price) {
        this.pay_price = pay_price;
    }

    public Long getPay_time() {
        return pay_time;
    }

    public String getPay_timeString() {
        return pay_timeString;
    }

    public void setPay_time(Long pay_time) {
        this.pay_time = pay_time;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getChan() {
        return chan;
    }

    public void setChan(String chan) {
        this.chan = chan;
    }

    public int getOs_type() {
        return os_type;
    }

    public void setOs_type(int os_type) {
        this.os_type = os_type;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getQuestion_content() {
        return question_content;
    }

    public void setQuestion_content(String question_content) {
        this.question_content = question_content;
    }

    public Long getAnswer_time() {
        return answer_time;
    }

    public void setAnswer_time(Long answer_time) {
        this.answer_time = answer_time;
    }

    public int getLooknumber() {
        return looknumber;
    }

    public void setLooknumber(int looknumber) {
        this.looknumber = looknumber;
    }

    public int getPraisenumber() {
        return praisenumber;
    }

    public void setPraisenumber(int praisenumber) {
        this.praisenumber = praisenumber;
    }

    public Long getUpLong_time() {
        return upLong_time;
    }

    public void setUpLong_time(Long upLong_time) {
        this.upLong_time = upLong_time;
    }

    public Long getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(Long finish_time) {
        this.finish_time = finish_time;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public int getHas_look_praise() {
        return has_look_praise;
    }

    public void setHas_look_praise(int has_look_praise) {
        this.has_look_praise = has_look_praise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getEvaluate_label() {
        return evaluate_label;
    }

    public void setEvaluate_label(String evaluate_label) {
        this.evaluate_label = evaluate_label;
    }

    public int getUndeal_freedom_num() {
        return undeal_freedom_num;
    }

    public void setUndeal_freedom_num(int undeal_freedom_num) {
        this.undeal_freedom_num = undeal_freedom_num;
    }

    public int getUndeal_wish_num() {
        return undeal_wish_num;
    }

    public void setUndeal_wish_num(int undeal_wish_num) {
        this.undeal_wish_num = undeal_wish_num;
    }

    public int getUndeal_question_num() {
        return undeal_question_num;
    }

    public void setUndeal_question_num(int undeal_question_num) {
        this.undeal_question_num = undeal_question_num;
    }

    public String getArtificial_procedure() {
        return artificial_procedure;
    }

    public void setArtificial_procedure(String artificial_procedure) {
        this.artificial_procedure = artificial_procedure;
    }

    public double getPromote_price() {
        return promote_price;
    }

    public void setPromote_price(double promote_price) {
        this.promote_price = promote_price;
    }

    public int getPart_activity() {
        return part_activity;
    }

    public void setPart_activity(int part_activity) {
        this.part_activity = part_activity;
    }

}
