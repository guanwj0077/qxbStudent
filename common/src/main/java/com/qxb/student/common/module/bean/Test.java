package com.qxb.student.common.module.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "tb_test")  //表名，主键
public class Test {

    @PrimaryKey
    private int id;
    private String name;
    @Ignore //表示不插入数据库
    private String desc;
}
