package com.qxb.student.common.module.bean;


/**
 * 问专家-学生档案及学生分数
 *
 * @author
 */
public class ExpertStuInfo {


    private StudentFile stuFile;

    private StuFileScore stuScore;

    public StudentFile getStuFile() {
        return stuFile;
    }

    public void setStuFile(StudentFile stuFile) {
        this.stuFile = stuFile;
    }

    public StuFileScore getStuScore() {
        return stuScore;
    }

    public void setStuScore(StuFileScore stuScore) {
        this.stuScore = stuScore;
    }

}
