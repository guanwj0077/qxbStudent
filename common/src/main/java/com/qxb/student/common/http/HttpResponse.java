package com.qxb.student.common.http;

public interface HttpResponse<T> {

    void success(T result);

    void failed(Throwable throwable);
}
