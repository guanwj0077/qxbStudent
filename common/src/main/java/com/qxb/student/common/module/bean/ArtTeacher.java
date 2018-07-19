package com.qxb.student.common.module.bean;

/**
 * 艺考个人老师
 *
 * @author
 */
public class ArtTeacher {

    /**
     * 艺考老师id
     */
    private int id;

    /**
     * 用户id
     **/
    private int user_id;

    /**
     * 账户id
     **/

    private int account_id;

    /**
     * 老师名称
     **/
    private String name;

    /**
     * 标签
     **/
    private String tag;

    /**
     * 老师头像
     **/
    private String pic;

    /**
     * 名师自诉 简介
     **/
    private String remark;

    /**
     * 省
     **/
    private String province_code;
    private String province_name;

    /**
     * 市
     **/
    private String city_code;
    private String city_name;

    /**
     * 区
     **/
    private String area_code;
    private String area_name;

    /**
     * 专业类别code
     **/
    private String category_code;

    /**
     * 创建时间
     **/
    private String create_time;

    /**
     * 排序
     **/
    private int order;

    /**
     * 状态 1开启 0 关闭
     **/
    private int status;

    /**
     * 是否热门名师  1热门 0不热门
     */
    private int is_hot;

    /**
     * 手机号码
     */
    private String telphone;

    /**
     * 收藏数量
     */
    private int praise;
    /**
     * 我是否已经点过赞了 >0，已点
     */
    private int is_praise;
    /**
     * 专业名称
     */
    private String category_name;
    /**
     * 搜索类型
     */
    private int type;
    /**
     * 老师头像Url
     */
    private String picRealPath;

    /**

     * 名师自述、机构描述Url
     */
    private String remark_url;
    /**
     * 是否收藏
     */
    private String is_collection;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProvince_code() {
        return province_code;
    }

    public void setProvince_code(String province_code) {
        this.province_code = province_code;
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

    public String getCategory_code() {
        return category_code;
    }

    public void setCategory_code(String category_code) {
        this.category_code = category_code;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getPicRealPath() {
        return picRealPath;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(int is_hot) {
        this.is_hot = is_hot;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public int getIs_praise() {
        return is_praise;
    }

    public void setIs_praise(int is_praise) {
        this.is_praise = is_praise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    public void setPicRealPath(String picRealPath) {
        this.picRealPath = picRealPath;
    }

    public String getRemark_url() {
        return remark_url;
    }

    public void setRemark_url(String remark_url) {
        this.remark_url = remark_url;
    }

    public String getIs_collection() {
        return is_collection;
    }

    public void setIs_collection(String is_collection) {
        this.is_collection = is_collection;
    }
}
