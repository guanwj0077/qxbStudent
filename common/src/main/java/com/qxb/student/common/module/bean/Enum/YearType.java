package com.qxb.student.common.module.bean.Enum;

import android.support.annotation.IdRes;

import com.qxb.student.common.R;

/**
 * @author: zjk9527
 * created on: 2018/7/20 17:25
 * description:
 */
public enum  YearType {
    /**
     *
     * */
    YEAR1(0, R.id.check_tv1),
    YEAR2(1,R.id.check_tv1),
    YEAR3(2, R.id.check_tv1),
    UNLIMITED(3, R.id.check_tv1);
    /**
     * key
     *
     * */
    private int key;
    /**
     * id
     *
     * */
    private int id;

    private YearType(int key, @IdRes int id) {
        this.key = key;
        this.id = id;
    }

    public int getKey() {
        return key;
    }

    public int getId() {
        return id;
    }

    public static YearType getByKey(int key) {
        for (YearType type : YearType.values()) {
            if (type.getKey() == key) {
                return type;
            }
        }
        return null;
    }

    public static String getTag(int year, int key) {
        for (YearType type : YearType.values()) {
            /*if (type.getKey() == 3) {
                return "其它";
            } else*/ if (type.getKey() == key) {
                return String.valueOf(year + key) + "年";
            }
        }
        return "";
    }
}
