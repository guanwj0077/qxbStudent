package com.qxb.student.common.http.task;

/**
 * @author winky
 * @date 2018/7/31
 */
public interface ClientTask<T> {

    T reqInSQLite(int pageIndex);
}
