package com.qxb.student.common.module.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * 学校信息实体
 *
 * @author winky
 */
@Entity(tableName = "RecomSchool")
public class RecomSchool {

    @PrimaryKey
    private int id;
    private String logoRealPath;
    private String school_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogoRealPath() {
        return logoRealPath;
    }

    public void setLogoRealPath(String logoRealPath) {
        this.logoRealPath = logoRealPath;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }
}
