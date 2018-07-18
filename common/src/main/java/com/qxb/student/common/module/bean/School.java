package com.qxb.student.common.module.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * 学校信息实体
 *
 * @author winky
 */
@Entity(tableName = "tb_school")
public class School {
    @Ignore
    public static final String TAG = "School";
    @PrimaryKey
    private int school_id;
    private String address;
    private int level;
    private String area;
    private int balance;
    private String characteristic;
    private String city;
    private String city_name;
    private String code;
    private String coverRealPath;
    private String fees_bonuses;
    private String front_cover;
    private String graduates_employment;
    private int id;
    private boolean is_att;
    private boolean is_reg;
    private int istop;
    private String logo;
    private String logoRealPath;
    private int order;
    private String province;
    private String province_name;
    private String remark;
    private String school_name;
    private int status;
    private int stipend;
    private String tag;
    private int total;
    private int type;
    private String urban_characteristics;
    private String weburl;
    private int bat;
    private int score_apposition;
    private int score_avg;
    private int attns;
    private int regis;
    private String sortLetter;
    private String video_url;
    /**
     * 学校是否开启单招
     */
    private int danzhao;
    /**
     * 学生是否已参加学校单招
     */
    private int is_dz;
    /**
     * 如果是school_baseinfo则为学校，如果是t_sys_group则为机构
     */
    private String connect_type;
    /**
     * 录像背景图片
     */
    private String videoImageRealPath;
    /**
     * 伴考背景图片
     */
    private String imageRealPath;
    /**
     * 院校是否入驻平台  0：未入驻
     */
    private int is_join_metting;

    private int receive_id;

    private int has_jz;
    private int rownum;
    private String school_rank;
    private String share_url;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public boolean isIs_att() {
        return is_att;
    }

    public void setIs_att(boolean is_att) {
        this.is_att = is_att;
    }

    public boolean isIs_reg() {
        return is_reg;
    }

    public void setIs_reg(boolean is_reg) {
        this.is_reg = is_reg;
    }

    public int getIstop() {
        return istop;
    }

    public void setIstop(int istop) {
        this.istop = istop;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
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

    public String getUrban_characteristics() {
        return urban_characteristics;
    }

    public void setUrban_characteristics(String urban_characteristics) {
        this.urban_characteristics = urban_characteristics;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    public int getBat() {
        return bat;
    }

    public void setBat(int bat) {
        this.bat = bat;
    }

    public int getScore_apposition() {
        return score_apposition;
    }

    public void setScore_apposition(int score_apposition) {
        this.score_apposition = score_apposition;
    }

    public int getScore_avg() {
        return score_avg;
    }

    public void setScore_avg(int score_avg) {
        this.score_avg = score_avg;
    }

    public int getAttns() {
        return attns;
    }

    public void setAttns(int attns) {
        this.attns = attns;
    }

    public int getRegis() {
        return regis;
    }

    public void setRegis(int regis) {
        this.regis = regis;
    }

    public String getSortLetter() {
        return sortLetter;
    }

    public void setSortLetter(String sortLetter) {
        this.sortLetter = sortLetter;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public int getDanzhao() {
        return danzhao;
    }

    public void setDanzhao(int danzhao) {
        this.danzhao = danzhao;
    }

    public int getIs_dz() {
        return is_dz;
    }

    public void setIs_dz(int is_dz) {
        this.is_dz = is_dz;
    }

    public String getConnect_type() {
        return connect_type;
    }

    public void setConnect_type(String connect_type) {
        this.connect_type = connect_type;
    }

    public String getVideoImageRealPath() {
        return videoImageRealPath;
    }

    public void setVideoImageRealPath(String videoImageRealPath) {
        this.videoImageRealPath = videoImageRealPath;
    }

    public String getImageRealPath() {
        return imageRealPath;
    }

    public void setImageRealPath(String imageRealPath) {
        this.imageRealPath = imageRealPath;
    }

    public int getIs_join_metting() {
        return is_join_metting;
    }

    public void setIs_join_metting(int is_join_metting) {
        this.is_join_metting = is_join_metting;
    }

    public int getReceive_id() {
        return receive_id;
    }

    public void setReceive_id(int receive_id) {
        this.receive_id = receive_id;
    }

    public int getHas_jz() {
        return has_jz;
    }

    public void setHas_jz(int has_jz) {
        this.has_jz = has_jz;
    }

    public int getRownum() {
        return rownum;
    }

    public void setRownum(int rownum) {
        this.rownum = rownum;
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
}
