package com.qxb.student.common.module.bean;

import java.util.List;
import java.util.Map;

/**
 * 大学在招专业实体类
 *
 * @author
 */
public class CollegeMajorRecruit {

    /**
     * 学校ID
     **/
    private int school_id;
    /**
     * 学校名称
     **/
    private String school_name;
    /**
     * 专业ID
     **/
    private int major_id;
    /**
     * 专业名称
     **/
    private String major_name;
    /**
     * 平均分
     **/
    private int score;
    /**
     * 省份
     **/
    private String province;
    /**
     * 省份名称
     **/
    private String province_name;
    /**
     * 专业类别（本专）
     **/
    private int major_type;
    /**
     * 科目类别（文理）
     **/
    private int subject_type;
    /**
     * 招生人数
     **/
    private int recruit_num;
    /**
     * 专业 批次
     **/
    private int batch;
    /**
     * 年份
     **/
    private int year;
    /**
     * 须知
     **/
    private String notice;
    /**
     * 学科大类  编码
     **/
    private String category_code;
    /**
     * 学科大类
     **/
    private String subject_name;
    /**
     * 学科门类
     **/
    private String psubject_name;
    /**
     * 职业性格匹配状态  0：未匹配  1：非常合适  2：无明显特征
     **/
    private int match_state;
    /**
     * 性格编码
     **/
    private String nature_code;
    /**
     * 本校相似专业
     **/
    private List<CollegeMajorRecruitProfess> similar_list;
    /**
     * 视频地址
     **/
    private String video_url;
    /**
     * 收藏状态  0：未收藏   1：收藏
     **/
    private int collection_state;
    /**
     * 封面
     **/
    private String front_img;
    /**
     * 专业描述
     */
    private String remark;
    /**
     * 批次
     **/
    private int bat;
    /**
     * 关联程度
     **/
    private int degree;
    /**
     * 学校所在的省份
     **/
    private String school_province;
    /**
     * 学校所在的省份名称
     **/
    private String school_province_name;
    /**
     * 是否标准专业
     **/
    private int is_rule;
    /**
     * 在招学校数量
     **/
    private int school_num;
    /**
     * 最低分数
     */
    private int score_min;


    /**
     * 非表字段
     **/
    //学校logo
    private String logo;
    //学校所在市名称
    private String school_city_name;
    //某年某学校批次招生总数量
    private int total_num;
    /**
     * 专业code
     */
    private String major_code;

    public String getMajor_code() {
        return major_code;
    }

    public void setMajor_code(String major_code) {
        this.major_code = major_code;
    }

    public int getScore_min() {
        return score_min;
    }

    public void setScore_min(int score_min) {
        this.score_min = score_min;
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

    public int getMajor_id() {
        return major_id;
    }

    public void setMajor_id(int major_id) {
        this.major_id = major_id;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getMajor_type() {
        return major_type;
    }

    public void setMajor_type(int major_type) {
        this.major_type = major_type;
    }

    public int getSubject_type() {
        return subject_type;
    }

    public void setSubject_type(int subject_type) {
        this.subject_type = subject_type;
    }

    public int getRecruit_num() {
        return recruit_num;
    }

    public void setRecruit_num(int recruit_num) {
        this.recruit_num = recruit_num;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getPsubject_name() {
        return psubject_name;
    }

    public void setPsubject_name(String psubject_name) {
        this.psubject_name = psubject_name;
    }

    public int getMatch_state() {
        return match_state;
    }

    public void setMatch_state(int match_state) {
        this.match_state = match_state;
    }

    public String getNature_code() {
        return nature_code;
    }

    public void setNature_code(String nature_code) {
        this.nature_code = nature_code;
    }

    public List<CollegeMajorRecruitProfess> getSimilar_list() {
        return similar_list;
    }

    public void setSimilar_list(List<CollegeMajorRecruitProfess> similar_list) {
        this.similar_list = similar_list;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public int getCollection_state() {
        return collection_state;
    }

    public void setCollection_state(int collection_state) {
        this.collection_state = collection_state;
    }

    public String getFront_img() {
        return front_img;
    }

    public void setFront_img(String front_img) {
        this.front_img = front_img;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCategory_code() {
        return category_code;
    }

    public void setCategory_code(String category_code) {
        this.category_code = category_code;
    }

    public int getBat() {
        return bat;
    }

    public void setBat(int bat) {
        this.bat = bat;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public String getSchool_province_name() {
        return school_province_name;
    }

    public void setSchool_province_name(String school_province_name) {
        this.school_province_name = school_province_name;
    }

    public String getSchool_province() {
        return school_province;
    }

    public void setSchool_province(String school_province) {
        this.school_province = school_province;
    }

    public int getIs_rule() {
        return is_rule;
    }

    public void setIs_rule(int is_rule) {
        this.is_rule = is_rule;
    }

    public int getSchool_num() {
        return school_num;
    }

    public void setSchool_num(int school_num) {
        this.school_num = school_num;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSchool_city_name() {
        return school_city_name;
    }

    public void setSchool_city_name(String school_city_name) {
        this.school_city_name = school_city_name;
    }

    public int getTotal_num() {
        return total_num;
    }

    public void setTotal_num(int total_num) {
        this.total_num = total_num;
    }


}
