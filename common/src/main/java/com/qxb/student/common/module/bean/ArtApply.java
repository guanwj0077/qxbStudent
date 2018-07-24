package com.qxb.student.common.module.bean;

/**
 * 艺考报名详情表
 *
 * @author
 */
public class ArtApply {
    private int id;
    /**
     * 学生id
     **/
    private int student_id;
    /**
     * 课程id
     **/
    private int course_id;
    /**
     * 类型 1:个人老师  2：机构
     **/
    private int type;
    /**
     * 类型id
     **/
    private int item_id;
    /**
     * 创建时间
     **/
    private long create_time;
    /**
     * 购买数量
     **/
    private int number;
    /**
     * 是否阅读
     */
    private int is_read;

    /**以下非表字段**/
    /**
     * 学生名称
     */
    private String student_name;
    /**
     * 学生手机号码
     */

    private String stu_telphone;
    /**
     * 学生省份
     */

    private String stu_province_name;
    /**
     * 学生城市
     */

    private String stu_city_name;
    /**
     * 学生区域
     */

    private String stu_area_name;
    /**
     * 老师名称
     */

    private String teacher_name;
    /**
     * 老师手机号码
     */

    private String tea_telphone;
    /**
     * 课程名称
     */
    private String course_name;
    /**
     * 课程价格
     */
    private double course_price;
    /**
     * 价格类型
     */
    private int pay_type;
    /**
     * 价格类型名称 1：课时 2：学期 3：套
     */
    private String pay_type_name;

    public int getIs_read() {
        return is_read;
    }

    public void setIs_read(int is_read) {
        this.is_read = is_read;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStu_telphone() {
        return stu_telphone;
    }

    public void setStu_telphone(String stu_telphone) {
        this.stu_telphone = stu_telphone;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTea_telphone() {
        return tea_telphone;
    }

    public void setTea_telphone(String tea_telphone) {
        this.tea_telphone = tea_telphone;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public double getCourse_price() {
        return course_price;
    }

    public void setCourse_price(double course_price) {
        this.course_price = course_price;
    }

    public int getPay_type() {
        return pay_type;
    }

    public void setPay_type(int pay_type) {
        this.pay_type = pay_type;
    }

    public String getPay_type_name() {

        return pay_type_name;
    }

    public String getStu_province_name() {
        return stu_province_name;
    }

    public void setStu_province_name(String stu_province_name) {
        this.stu_province_name = stu_province_name;
    }

    public String getStu_city_name() {
        return stu_city_name;
    }

    public void setStu_city_name(String stu_city_name) {
        this.stu_city_name = stu_city_name;
    }

    public String getStu_area_name() {
        return stu_area_name;
    }

    public void setStu_area_name(String stu_area_name) {
        this.stu_area_name = stu_area_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPay_type_name(String pay_type_name) {
        this.pay_type_name = pay_type_name;
    }
}
