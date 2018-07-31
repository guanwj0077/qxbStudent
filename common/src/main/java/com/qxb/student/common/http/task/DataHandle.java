package com.qxb.student.common.http.task;

import android.support.annotation.NonNull;

/**
 * @author winky
 * @date 2018/7/31
 */
public interface DataHandle<T> {

    void handle(@NonNull T data);
}
