package com.qxb.student.common.module.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "tb_base_subject_category")
public class BaseSubjectCategory {
    /** id */
    @PrimaryKey
    private int id;

    /** 学科名称 */
    private String name;

    /** 学科编号 */
    private String code;

    /** 上级编号 */
    private String parent_code;

    /** 层级 */
    private int depth;

    private int isclose;
    /** 默认关闭节点 */

    private String state = "closed";
    private List<BaseSubjectCategory> children;

    /** 本科:1 专科:2*/
    private int type;
    /**非表字段   根据学科大类推荐自招院校-判断是否有相关院校**/
    private boolean have=true;

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
    /**
     * 获取学科名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置学科名称
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 获取学科编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置学科编号
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * 获取上级编号
     */
    public String getParent_code() {
        return parent_code;
    }

    /**
     * 设置上级编号
     */
    public void setParent_code(String parent_code) {
        this.parent_code = parent_code;
    }
    /**
     * 获取层级
     */
    public int getDepth() {
        return depth;
    }

    /**
     * 设置层级
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getIsclose() {
        return isclose;
    }

    public void setIsclose(int isclose) {
        this.isclose = isclose;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<BaseSubjectCategory> getChildren() {
        return children;
    }

    public void setChildren(List<BaseSubjectCategory> children) {
        this.children = children;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isHave() {
        return have;
    }

    public void setHave(boolean have) {
        this.have = have;
    }
}
