package com.qxb.student.common.module.bean.tab;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * @author winky
 * @date 2018/7/19
 */
@Entity(tableName = "Configure")
public class Configure {

    @PrimaryKey(autoGenerate = true)
    private int _id;


}
