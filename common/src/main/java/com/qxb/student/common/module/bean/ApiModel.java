package com.qxb.student.common.module.bean;

import com.qxb.student.common.utils.JsonUtils;

/**
 * 接口返回基础模型
 *
 * @author winky
 */
public class ApiModel<T> {

    private int code;
    private int total;
    private String msg;
    private T data;
    private int socailMsg;
    private long cacheTime;

    public ApiModel() {
    }

    public ApiModel(int code, int total, String msg, T data, int socailMsg, long cacheTime) {
        this.code = code;
        this.total = total;
        this.msg = msg;
        this.data = data;
        this.socailMsg = socailMsg;
        this.cacheTime = cacheTime;
    }

    public long getCacheTime() {
        return cacheTime;
    }

    public void setCacheTime(long cacheTime) {
        this.cacheTime = cacheTime;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getSocailMsg() {
        return socailMsg;
    }

    public void setSocailMsg(int socailMsg) {
        this.socailMsg = socailMsg;
    }

    @Override
    public String toString() {
        return JsonUtils.getInstance().toJson(this);
    }

    public static ApiModel parse(String json) {
        return JsonUtils.getInstance().toBean(json, ApiModel.class);
    }
}
