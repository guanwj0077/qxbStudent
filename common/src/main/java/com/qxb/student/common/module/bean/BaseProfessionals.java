package com.qxb.student.common.module.bean;


public class BaseProfessionals {

    /**
     * id
     */
    private int id;

    /**
     * 学科code
     */
    private String category_code;
    private String category_name;
    private String parent_code;

    private int schools;

    /**
     * 专业名称
     */
    private String name;

    private int type;

    /**
     * 专业简介
     */
    private String summary;

    /**
     * 就业排名
     */
    private String ranking;

    /**
     * 平均薪酬
     */
    private int wage;

    /**
     * 专业描述
     */
    private String remark;

    private Boolean checked;

    private String subjectName;

    private String psubjectName;
    /**
     * 收藏状态  0：未收藏   1：收藏
     **/
    private int collection_state;

    /**
     * 职业性格匹配状态  0：未匹配  1：非常合适  2：无明显特征
     **/
    private int match_state;
    /**
     * 性格编码
     **/
    private String nature_code;
    /**
     * 是否标准专业  1标准专业  2非标准专业
     **/
    private int is_rule;

    /**
     * 获取id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_code() {
        return category_code;
    }

    public void setCategory_code(String category_code) {
        this.category_code = category_code;
    }

    /**
     * 获取专业名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置专业名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取专业简介
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 设置专业简介
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 获取就业排名
     */
    public String getRanking() {
        return ranking;
    }

    /**
     * 设置就业排名
     */
    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    /**
     * 获取平均薪酬
     */
    public int getWage() {
        return wage;
    }

    /**
     * 设置平均薪酬
     */
    public void setWage(int wage) {
        this.wage = wage;
    }

    /**
     * 获取专业描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置专业描述
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getParent_code() {
        return parent_code;
    }

    public void setParent_code(String parent_code) {
        this.parent_code = parent_code;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSchools() {
        return schools;
    }

    public void setSchools(int schools) {
        this.schools = schools;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getPsubjectName() {
        return psubjectName;
    }

    public void setPsubjectName(String psubjectName) {
        this.psubjectName = psubjectName;
    }

    public int getCollection_state() {
        return collection_state;
    }

    public void setCollection_state(int collection_state) {
        this.collection_state = collection_state;
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

    public int getIs_rule() {
        return is_rule;
    }

    public void setIs_rule(int is_rule) {
        this.is_rule = is_rule;
    }

}
