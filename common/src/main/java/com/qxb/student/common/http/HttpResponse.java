package com.qxb.student.common.http;

/**
 * 接口返回处理
 * @author winky
 */
public interface HttpResponse<T> {

    /**
     * 接口返回成功
     * @param result 成功数据
     */
    void success(T result);
    /**
     * 接口返回失败
     * @param throwable 失败异常
     */
    void failed(Throwable throwable);
}
