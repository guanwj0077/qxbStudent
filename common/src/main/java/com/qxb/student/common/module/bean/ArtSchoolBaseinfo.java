package com.qxb.student.common.module.bean;

/**
 * 艺术院校关联表
 *
 * @author
 */
public class ArtSchoolBaseinfo extends RecomSchool {

    private int id;

    /**
     * 学校id
     **/
    private int school_id;

    /**
     * --目标高校性质 1 艺术院校，2综合高校，3高职专科
     */
    private int school_nature;

    /**
     * 艺术标签
     **/
    private String art_tags;


    /**
     * 是否置顶
     **/
    private int is_top;

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public int getSchool_nature() {
        return school_nature;
    }

    public void setSchool_nature(int school_nature) {
        this.school_nature = school_nature;
    }

    public String getArt_tags() {
        return art_tags;
    }

    public void setArt_tags(String art_tags) {
        this.art_tags = art_tags;
    }

    public int getIs_top() {
        return is_top;
    }

    public void setIs_top(int is_top) {
        this.is_top = is_top;
    }

}
