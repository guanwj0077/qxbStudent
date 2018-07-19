package com.qxb.student.common.module.bean;

import java.util.List;

/**
 * 艺考资讯banner
 *
 * @author
 */

public class ArtSchoolRecruitData {

    /**
     * 专业大类code
     */
    private String art_category_code;
    /**

     * 专业大类名称
     */
    private String art_category_name;
    /**
     * 历年分数线
     */
    private List<ArtSchoolScore> scoreList;
    /***
     * 招生专业
     */
    private List<ArtMajor> majorList;
    /**
     * 分数线条数
     */
    private int scoreListTotal;
    /**
     * 招生专业条数
     */
    private int majorListTotal;

    public String getArt_category_code() {
        return art_category_code;
    }

    public void setArt_category_code(String art_category_code) {
        this.art_category_code = art_category_code;
    }

    public String getArt_category_name() {
        return art_category_name;
    }

    public void setArt_category_name(String art_category_name) {
        this.art_category_name = art_category_name;
    }

    public List<ArtSchoolScore> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<ArtSchoolScore> scoreList) {
        this.scoreList = scoreList;
    }

    public List<ArtMajor> getMajorList() {
        return majorList;
    }

    public void setMajorList(List<ArtMajor> majorList) {
        this.majorList = majorList;
    }

    public int getScoreListTotal() {
        return scoreListTotal;
    }

    public void setScoreListTotal(int scoreListTotal) {
        this.scoreListTotal = scoreListTotal;
    }

    public int getMajorListTotal() {
        return majorListTotal;
    }

    public void setMajorListTotal(int majorListTotal) {
        this.majorListTotal = majorListTotal;
    }

}
