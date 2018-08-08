package com.qxb.student.common.module.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * @author winky
 * @date 2018/7/24
 */
@Entity(tableName = "SchoolDetail")
public class SchoolDetail {

    private String address;
    private String area;
    private int attns;
    private int balance;
    private String city;
    private String code;
    private String coverRealPath;
    private int danzhao;
    private int degree;
    private String fees_bonuses;
    private String front_cover;
    private String graduates_employment;
    private int has_jz;
    @PrimaryKey
    private int id;
    private boolean is_att;
    private int is_dz;
    private int is_join_metting;
    private boolean is_reg;
    private int level;
    private String logo;
    private String logoRealPath;
    private int order;
    private String province;
    private String province_name;
    private int recruit_type;
    private int regis;
    private String remark;
    private int rownum;
    private String school_name;
    private String school_rank;
    private String share_url;
    private int status;
    private int stipend;
    private String tag;
    private int total;
    private int type;
    private String videoImageRealPath;
    private int web_level;
    private int web_rank;
    private String video_url;

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getAttns() {
        return attns;
    }

    public void setAttns(int attns) {
        this.attns = attns;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCoverRealPath() {
        return coverRealPath;
    }

    public void setCoverRealPath(String coverRealPath) {
        this.coverRealPath = coverRealPath;
    }

    public int getDanzhao() {
        return danzhao;
    }

    public void setDanzhao(int danzhao) {
        this.danzhao = danzhao;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public String getFees_bonuses() {
        return fees_bonuses;
    }

    public void setFees_bonuses(String fees_bonuses) {
        this.fees_bonuses = fees_bonuses;
    }

    public String getFront_cover() {
        return front_cover;
    }

    public void setFront_cover(String front_cover) {
        this.front_cover = front_cover;
    }

    public String getGraduates_employment() {
        return graduates_employment;
    }

    public void setGraduates_employment(String graduates_employment) {
        this.graduates_employment = graduates_employment;
    }

    public int getHas_jz() {
        return has_jz;
    }

    public void setHas_jz(int has_jz) {
        this.has_jz = has_jz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIs_att() {
        return is_att;
    }

    public void setIs_att(boolean is_att) {
        this.is_att = is_att;
    }

    public int getIs_dz() {
        return is_dz;
    }

    public void setIs_dz(int is_dz) {
        this.is_dz = is_dz;
    }

    public int getIs_join_metting() {
        return is_join_metting;
    }

    public void setIs_join_metting(int is_join_metting) {
        this.is_join_metting = is_join_metting;
    }

    public boolean isIs_reg() {
        return is_reg;
    }

    public void setIs_reg(boolean is_reg) {
        this.is_reg = is_reg;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public void setLogoRealPath(String logoRealPath) {
        this.logoRealPath = logoRealPath;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
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

    public int getRecruit_type() {
        return recruit_type;
    }

    public void setRecruit_type(int recruit_type) {
        this.recruit_type = recruit_type;
    }

    public int getRegis() {
        return regis;
    }

    public void setRegis(int regis) {
        this.regis = regis;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getRownum() {
        return rownum;
    }

    public void setRownum(int rownum) {
        this.rownum = rownum;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getSchool_rank() {
        return school_rank;
    }

    public void setSchool_rank(String school_rank) {
        this.school_rank = school_rank;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStipend() {
        return stipend;
    }

    public void setStipend(int stipend) {
        this.stipend = stipend;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getVideoImageRealPath() {
        return videoImageRealPath;
    }

    public void setVideoImageRealPath(String videoImageRealPath) {
        this.videoImageRealPath = videoImageRealPath;
    }

    public int getWeb_level() {
        return web_level;
    }

    public void setWeb_level(int web_level) {
        this.web_level = web_level;
    }

    public int getWeb_rank() {
        return web_rank;
    }

    public void setWeb_rank(int web_rank) {
        this.web_rank = web_rank;
    }
}
