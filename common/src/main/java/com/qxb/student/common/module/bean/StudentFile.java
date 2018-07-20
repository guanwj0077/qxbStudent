package com.qxb.student.common.module.bean;


/**
 * 学生档案实体类
 *
 * @author
 */
public class StudentFile {


    private int id;
    /**
     * 学生表（user_student）id
     */
    private int stu_id;
    /**
     * 性别 1.男2.女
     */
    private int sex;
    /**
     * 科目
     */
    private int subject;
    /**
     * 学校id
     */
    private int school_id;
    /**
     * 身高
     */
    private int hight;
    /**
     * 是否色盲 1.是2.否
     */
    private int color_blind;
    /**
     * 是否任职 1.是2.否
     */
    private int is_job;
    /**
     * 任何职位
     */
    private String stu_job;
    /**
     * 创建时间
     */
    private Long create_time;
    /**
     * 姓名
     */
    private String name;
    /**
     * 高考年份
     */
    private String years;
    /**
     * 民族
     */
    private String nation;
    /**
     * 生源省份
     */
    private String stu_province;
    /**
     * 生源省份名称
     */
    private String stu_province_name;
    /**
     * 生源城市
     */
    private String stu_city;
    /**
     * 生源城市名称
     */
    private String stu_city_name;
    /**
     * 生源县
     */
    private String stu_area;
    /**
     * 生源县名称
     */
    private String stu_area_name;
    /**
     * 意愿报考地区
     */
    private String target_area;
    /**
     * 健康状况
     */
    private String health;
    /**
     * 左眼视力
     */
    private String left_eye;
    /**
     * 右眼视力
     */
    private String right_eye;
    /**
     * 头像
     */
    private String photo;
    /**
     * 母亲的工作
     */
    private String mother_job;
    /**
     * 父亲的工作
     */
    private String father_job;
    /**
     * qq号
     */
    private String qq;
    /**
     * 最近是否有加分项 1有  2无
     */
    private int is_extra_score;
    /**
     * 加分分值
     */
    private int extra_score;
    /**
     * 意向报考院校
     */
    private String target_college;
    /**
     * 意向报考专业
     */
    private String target_majors;
    /**
     * 留学意向
     */
    private String target_abroad;
    /**
     * 社会经历
     */
    private String activity;
    /**
     * 获奖经历
     */
    private String award;
    /**
     * 论文/专刊
     */
    private String dissertation;
    /**
     * 手机号
     */
    private String telphone;
    /**
     * 预估分
     */
    private int yugufen;
    /**
     * 高考分
     */
    private int gaokaofen;
    /**
     * 高中
     */
    private int highschool_id;
    /**
     * 昵称
     */
    private String nick_name;
    /**
     * 是否艺术生
     */
    private int is_art;
    /**
     * 是否考虑出国留学  0：否   1：是  （ 默认否）
     */
    private int is_plan_abroad;
    /**
     * 会员类型  1 普通用户	；2 VIP	；3 测试用户
     **/
    private int type;
    /**
     * 注册时间
     */
    private Long reg_time;

    private String province;
    private String province_name;
    private String photoRealPath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSex() {
        return sex;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public int getSubject() {
        return subject;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public int getSchool_id() {
        return school_id;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    public int getHight() {
        return hight;
    }

    public void setColor_blind(int color_blind) {
        this.color_blind = color_blind;
    }

    public int getColor_blind() {
        return color_blind;
    }

    public void setIs_job(int is_job) {
        this.is_job = is_job;
    }

    public int getIs_job() {
        return is_job;
    }

    public String getStu_job() {
        return stu_job;
    }

    public void setStu_job(String stu_job) {
        this.stu_job = stu_job;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getYears() {
        return years;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNation() {
        return nation;
    }

    public void setStu_province(String stu_province) {
        this.stu_province = stu_province;
    }

    public String getStu_province() {
        return stu_province;
    }

    public void setStu_city(String stu_city) {
        this.stu_city = stu_city;
    }

    public String getStu_city() {
        return stu_city;
    }

    public void setStu_area(String stu_area) {
        this.stu_area = stu_area;
    }

    public String getStu_area() {
        return stu_area;
    }

    public void setTarget_area(String target_area) {
        this.target_area = target_area;
    }

    public String getTarget_area() {
        return target_area;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getHealth() {
        return health;
    }

    public void setLeft_eye(String left_eye) {
        this.left_eye = left_eye;
    }

    public String getLeft_eye() {
        return left_eye;
    }

    public void setRight_eye(String right_eye) {
        this.right_eye = right_eye;
    }

    public String getRight_eye() {
        return right_eye;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPhotoRealPath() {
        return photoRealPath;
    }

    public String getMother_job() {
        return mother_job;
    }

    public void setMother_job(String mother_job) {
        this.mother_job = mother_job;
    }

    public String getFather_job() {
        return father_job;
    }

    public void setFather_job(String father_job) {
        this.father_job = father_job;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public int getIs_extra_score() {
        return is_extra_score;
    }

    public void setIs_extra_score(int is_extra_score) {
        this.is_extra_score = is_extra_score;
    }

    public int getExtra_score() {
        return extra_score;
    }

    public void setExtra_score(int extra_score) {
        this.extra_score = extra_score;
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

    public String getTarget_abroad() {
        return target_abroad;
    }

    public void setTarget_abroad(String target_abroad) {
        this.target_abroad = target_abroad;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getDissertation() {
        return dissertation;
    }

    public void setDissertation(String dissertation) {
        this.dissertation = dissertation;
    }

    public String getStu_area_name() {
        return stu_area_name;
    }

    public void setStu_area_name(String stu_area_name) {
        this.stu_area_name = stu_area_name;
    }

    public String getStu_city_name() {
        return stu_city_name;
    }

    public void setStu_city_name(String stu_city_name) {
        this.stu_city_name = stu_city_name;
    }

    public String getStu_province_name() {
        return stu_province_name;
    }

    public void setStu_province_name(String stu_province_name) {
        this.stu_province_name = stu_province_name;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public int getYugufen() {
        return yugufen;
    }

    public void setYugufen(int yugufen) {
        this.yugufen = yugufen;
    }

    public int getGaokaofen() {
        return gaokaofen;
    }

    public void setGaokaofen(int gaokaofen) {
        this.gaokaofen = gaokaofen;
    }

    public int getHighschool_id() {
        return highschool_id;
    }

    public void setHighschool_id(int highschool_id) {
        this.highschool_id = highschool_id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public int getIs_art() {
        return is_art;
    }

    public void setIs_art(int is_art) {
        this.is_art = is_art;
    }

    public int getIs_plan_abroad() {
        return is_plan_abroad;
    }

    public void setIs_plan_abroad(int is_plan_abroad) {
        this.is_plan_abroad = is_plan_abroad;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

}
