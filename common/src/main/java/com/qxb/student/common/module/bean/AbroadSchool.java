package com.qxb.student.common.module.bean;

import java.util.List;

public class AbroadSchool {

    /**学校拓展信息id*/
    private int id;
    /**学校id*/
    private int school_id;
    /**世界排名*/
    private int world_rank;
    /**Times排名*/
    private int times_rank;
    /**所在国家编码*/
    private int country_code;
    /**学校所在地区文本*/
    private String school_address;
    /**学校性质*/
    private int property;
    /**is_authentic*/
    private int is_authentic;
    /**学校类型 */
    private int type;
    /**录取率*/
    private String adminssion_rate;
    /**建校时间*/
    private String founding_time;
    /**优势专业*/
    private String superiority_major;
    /**留学费用*/
    private int study_abroad_cost;
    /**教学语言*/
    private String teaching_language;
    /**教师数量*/
    private int teacher_count;
    /**师生比例*/
    private String stu_teacher_ratio;
    /**学生数量*/
    private int student_count;
    /**国际学生数量*/
    private int international_student_count;
    /**毕业率*/
    private String graduation_rate;
    /**生活费*/
    private int living_cost;
    /**住宿费*/
    private int accommodation_cost;
    /**学费*/
    private int tuition;
    /**语言要求*/
    private String language_demand;

    /** 学校名称 */
    private String school_name;
    /**英文名称*/
    private String english_name;
    /** 学校LOGO */
    private String logo;
    private String logoRealPath;
    /** 学校封面 */
    private String front_cover;
    private String coverRealPath;
    /**学校简介*/
    private String summary;
    /**申请要求*/
    private String apply_requirement;
    /**人文教学*/
    private String humanity_teaching;
    /**花费说明*/
    private String expense_explain;
    /**联系方式*/
    private String contact;
    /**学生是否关注留学院校*/
    private int student_has_att;
    /**学生是否申请报名留学院校*/
    private int student_has_apply;
    /**申请截止时间*/
    private List<AbroadSchoolApplyDeadline> apply_deadline;
    /**显示顺序*/
    private int order;
    /**状态*/
    private int status;
    /**国家名称*/
    private String country_name;
    /**客户端首页排名 */
    private String ad_rank;
    /**院校vip等级 */
    private int level;
    /**同一国家其他大学列表*/
    private List<AbroadSchool> other_school_list;
    /**是否有招生专业*/
    private int has_recruit_major;
    /**留学宝典id*/
    private int school_intro_id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public int getSchool_id() {
        return school_id;
    }

    public void setWorld_rank(int world_rank) {
        this.world_rank = world_rank;
    }

    public int getWorld_rank() {
        return world_rank;
    }

    public void setTimes_rank(int times_rank) {
        this.times_rank = times_rank;
    }

    public int getTimes_rank() {
        return times_rank;
    }

    public void setProperty(int property) {
        this.property = property;
    }

    public int getProperty() {
        return property;
    }

    public void setIs_authentic(int is_authentic) {
        this.is_authentic = is_authentic;
    }

    public int getIs_authentic() {
        return is_authentic;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public String getAdminssion_rate() {
        return adminssion_rate;
    }
    public void setAdminssion_rate(String adminssion_rate) {
        this.adminssion_rate = adminssion_rate;
    }
    public void setFounding_time(String founding_time) {
        this.founding_time = founding_time;
    }

    public String getFounding_time() {
        return founding_time;
    }

    public void setSchool_address(String school_address) {
        this.school_address = school_address;
    }

    public String getSchool_address() {
        return school_address;
    }

    public void setSuperiority_major(String superiority_major) {
        this.superiority_major = superiority_major;
    }

    public String getSuperiority_major() {
        return superiority_major;
    }

    public String getTeaching_language() {
        return teaching_language;
    }
    public void setTeaching_language(String teaching_language) {
        this.teaching_language = teaching_language;
    }
    public int getTeacher_count() {
        return teacher_count;
    }
    public void setTeacher_count(int teacher_count) {
        this.teacher_count = teacher_count;
    }
    public String getStu_teacher_ratio() {
        return stu_teacher_ratio;
    }
    public void setStu_teacher_ratio(String stu_teacher_ratio) {
        this.stu_teacher_ratio = stu_teacher_ratio;
    }
    public int getStudent_count() {
        return student_count;
    }
    public void setStudent_count(int student_count) {
        this.student_count = student_count;
    }
    public int getInternational_student_count() {
        return international_student_count;
    }
    public void setInternational_student_count(int international_student_count) {
        this.international_student_count = international_student_count;
    }
    public String getGraduation_rate() {
        return graduation_rate;
    }
    public void setGraduation_rate(String graduation_rate) {
        this.graduation_rate = graduation_rate;
    }
    public int getLiving_cost() {
        return living_cost;
    }
    public void setLiving_cost(int living_cost) {
        this.living_cost = living_cost;
    }
    public int getAccommodation_cost() {
        return accommodation_cost;
    }
    public void setAccommodation_cost(int accommodation_cost) {
        this.accommodation_cost = accommodation_cost;
    }
    public int getTuition() {
        return tuition;
    }
    public void setTuition(int tuition) {
        this.tuition = tuition;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getStudy_abroad_cost() {
        return study_abroad_cost;
    }
    public void setStudy_abroad_cost(int study_abroad_cost) {
        this.study_abroad_cost = study_abroad_cost;
    }

    /** 获取留学费用文本 */
    public String getStudy_abroad_cost_text(){
        int cost = 0;
        if(study_abroad_cost>0){
            cost = study_abroad_cost/10000;
            if(cost>0){
                return "￥"+cost+"万/年";
            }
        }else if(tuition > 0 || living_cost > 0 || accommodation_cost > 0){
            cost = (tuition + living_cost + accommodation_cost)/10000;
            if(cost>0){
                return "￥"+cost+"万/年";
            }
        }
        return "暂无";
    }

    public int getCountry_code() {
        return country_code;
    }
    public void setCountry_code(int country_code) {
        this.country_code = country_code;
    }
    public String getSchool_name() {
        return school_name;
    }
    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }
    public String getEnglish_name() {
        return english_name;
    }
    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
    }
    public String getLogo() {
        return logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }
    public String getLogoRealPath() {
        return logoRealPath;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getApply_requirement() {
        return apply_requirement;
    }
    public void setApply_requirement(String apply_requirement) {
        this.apply_requirement = apply_requirement;
    }
    public String getHumanity_teaching() {
        return humanity_teaching;
    }
    public void setHumanity_teaching(String humanity_teaching) {
        this.humanity_teaching = humanity_teaching;
    }
    public String getExpense_explain() {
        return expense_explain;
    }
    public void setExpense_explain(String expense_explain) {
        this.expense_explain = expense_explain;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getLanguage_demand() {
        return language_demand;
    }
    public void setLanguage_demand(String language_demand) {
        this.language_demand = language_demand;
    }
    public int getStudent_has_att() {
        return student_has_att;
    }
    public void setStudent_has_att(int student_has_att) {
        this.student_has_att = student_has_att;
    }
    public List<AbroadSchoolApplyDeadline> getApply_deadline() {
        return apply_deadline;
    }
    public void setApply_deadline(List<AbroadSchoolApplyDeadline> apply_deadline) {
        this.apply_deadline = apply_deadline;
    }
    public String getFront_cover() {
        return front_cover;
    }
    public void setFront_cover(String front_cover) {
        this.front_cover = front_cover;
    }
    public String getCoverRealPath() {
        return coverRealPath;
    }
    public int getOrder() {
        return order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getCountry_name() {
        return country_name;
    }
    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
    public String getAd_rank() {
        return ad_rank;
    }
    public void setAd_rank(String ad_rank) {
        this.ad_rank = ad_rank;
    }
    public List<AbroadSchool> getOther_school_list() {
        return other_school_list;
    }
    public void setOther_school_list(List<AbroadSchool> other_school_list) {
        this.other_school_list = other_school_list;
    }
    public int getStudent_has_apply() {
        return student_has_apply;
    }
    public void setStudent_has_apply(int student_has_apply) {
        this.student_has_apply = student_has_apply;
    }
    public int getHas_recruit_major() {
        return has_recruit_major;
    }
    public void setHas_recruit_major(int has_recruit_major) {
        this.has_recruit_major = has_recruit_major;
    }
    public int getSchool_intro_id() {
        return school_intro_id;
    }
    public void setSchool_intro_id(int school_intro_id) {
        this.school_intro_id = school_intro_id;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
}
