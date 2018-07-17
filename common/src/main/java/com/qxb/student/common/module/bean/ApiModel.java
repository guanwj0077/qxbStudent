package com.qxb.student.common.module.bean;

public class ApiModel<T> {

    private int code;
    private int total;
    private String msg;
    private T data;
    private int socailMsg;

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

}
