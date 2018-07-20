package com.qxb.student.common.module.bean;


/**
 * 学生考试分数实体类
 *
 * @author
 */
public class StuFileScore {


    private int id;
    /**
     * 学生档案基本信息ID
     */
    private int stu_file_id;
    /**
     * 学生id
     */
    private int stu_id;
    /**
     * 总分
     */
    private int total;
    /**
     * 语文
     */
    private int chinese;
    /**
     * 数学
     */
    private int math;
    /**
     * 英语
     */
    private int english;
    /**
     * 考试类型 1.模拟 2.高考
     */
    private int test_type;
    /**
     * 学科类型
     */
    private int subject_type;
    /**
     * 年级总人数
     */
    private int count_people;
    /**
     * 排名
     */
    private int rankings;
    /**
     * 政治
     */
    private int politics;
    /**
     * 历史
     */
    private int history;
    /**
     * 地理
     */
    private int geography;
    /**
     * 物理
     */
    private int physics;
    /**
     * 化学
     */
    private int chemistry;
    /**
     * 生物
     */
    private int biology;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStu_file_id(int stu_file_id) {
        this.stu_file_id = stu_file_id;
    }

    public int getStu_file_id() {
        return stu_file_id;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getChinese() {
        return chinese;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getMath() {
        return math;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getEnglish() {
        return english;
    }

    public void setTest_type(int test_type) {
        this.test_type = test_type;
    }

    public int getTest_type() {
        return test_type;
    }

    public void setSubject_type(int subject_type) {
        this.subject_type = subject_type;
    }

    public int getSubject_type() {
        return subject_type;
    }

    public void setCount_people(int count_people) {
        this.count_people = count_people;
    }

    public int getCount_people() {
        return count_people;
    }

    public void setRankings(int rankings) {
        this.rankings = rankings;
    }

    public int getRankings() {
        return rankings;
    }

    public void setPolitics(int politics) {
        this.politics = politics;
    }

    public int getPolitics() {
        return politics;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public int getHistory() {
        return history;
    }

    public void setGeography(int geography) {
        this.geography = geography;
    }

    public int getGeography() {
        return geography;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getPhysics() {
        return physics;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    public int getChemistry() {
        return chemistry;
    }

    public void setBiology(int biology) {
        this.biology = biology;
    }

    public int getBiology() {
        return biology;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

}
