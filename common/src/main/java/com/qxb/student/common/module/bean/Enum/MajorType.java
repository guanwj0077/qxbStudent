package com.qxb.student.common.module.bean.Enum;

import android.service.autofill.ImageTransformation;
import android.support.annotation.IdRes;

import com.qxb.student.common.Constant;
import com.qxb.student.common.R;

/**
 * created on: 2018/2/22 15:50
 * description:
 * @author Administrator
 */

public enum MajorType {

    /**
     *
     */
    MAJOR1(Constant.WEN_KE, R.id.check_tv1),
    /**
     *
     */
    MAJOR2(Constant.LIKE, R.id.check_tv2),
    /**
     *
     */
    MAJOR3(Constant.YISHU_WENKE, R.id.check_tv3),
    MAJOR4(Constant.YISHU_LIKE, R.id.check_tv4);



    /**
     * key
     * */
    private String  key;
    /**
     * id
     * */
    private int id;

    private MajorType(String key, @IdRes int id) {
        this.key = key;
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public int getId() {
        return id;
    }

    public static MajorType getByKey(String key) {
        for (MajorType type : MajorType.values()) {
            if (type.getKey() == key) {
                return type;
            }
        }
        return null;
    }



}
