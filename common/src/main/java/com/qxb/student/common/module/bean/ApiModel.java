package com.qxb.student.common.module.bean;

public class ApiModel<T> {

    private int CODE;
    private int total;
    private String msg;
    private T data;
    private int socailMsg;

    public int getCODE() {
        return CODE;
    }

    public void setCODE(int CODE) {
        this.CODE = CODE;
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
