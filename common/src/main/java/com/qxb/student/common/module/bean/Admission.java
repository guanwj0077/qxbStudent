package com.qxb.student.common.module.bean;

import com.qxb.student.common.view.abslist.bean.ExpandableEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author winky
 * @date 2018/7/25
 */
public class Admission {

    /**
     * 批次id
     */
    private int batch;
    /**
     * 批次
     */
    private String batchName;
    /**
     * 分数线
     */
    private List<ScoreLine> scoreLineList;
    /**
     * 专业
     */
    private List<ExpandableEntity<MajorParent, List<MajorChild>>> majorBatList = new ArrayList<>();

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public List<ScoreLine> getScoreLineList() {
        return scoreLineList;
    }

    public void setScoreLineList(List<ScoreLine> scoreLineList) {
        this.scoreLineList = scoreLineList;
    }

    public List<ExpandableEntity<MajorParent, List<MajorChild>>> getMajorBatList() {
        return majorBatList;
    }

    public void addExpandableEntity(ExpandableEntity<MajorParent, List<MajorChild>> entity) {
        this.majorBatList.add(entity);
    }
}
