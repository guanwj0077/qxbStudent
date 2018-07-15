package com.qxb.student.common.module.bean;

public class AppSrc {

    private int os_type = 1;
    private int app_type = 1;
    private String ver_v;
    private String ver_s;
    private String chan;

    public AppSrc() {
        this.ver_v = "76";
        this.ver_s = "5.0";
        this.chan = "3";
    }

    public int getOs_type() {
        return os_type;
    }

    public void setOs_type(int os_type) {
        this.os_type = os_type;
    }

    public int getApp_type() {
        return app_type;
    }

    public void setApp_type(int app_type) {
        this.app_type = app_type;
    }

    public String getVer_v() {
        return ver_v;
    }

    public void setVer_v(String ver_v) {
        this.ver_v = ver_v;
    }

    public String getVer_s() {
        return ver_s;
    }

    public void setVer_s(String ver_s) {
        this.ver_s = ver_s;
    }

    public String getChan() {
        return chan;
    }

    public void setChan(String chan) {
        this.chan = chan;
    }
}
