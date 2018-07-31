package com.qxb.student.common.http;

import android.support.annotation.NonNull;

import com.qxb.student.common.module.bean.ApiModel;

/**
 * @author winky
 * @date 2018/7/31
 */
public interface ApiModelHandle<T> {

    void handle(@NonNull ApiModel<T> apiModel);
}
