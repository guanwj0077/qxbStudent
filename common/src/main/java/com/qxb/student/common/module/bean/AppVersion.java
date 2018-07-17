package com.qxb.student.common.module.bean;

public class AppVersion {
    private String tips;
    private String update_url;
    private String version_name;
    private int version_code;
    private int type;
    private int is_force_update;
    private int is_back_download;

    public String getVersion_name() {
        return version_name;
    }

    public void setVersion_name(String version_name) {
        this.version_name = version_name;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getUpdate_url() {
        return update_url;
    }

    public void setUpdate_url(String update_url) {
        this.update_url = update_url;
    }

    public int getVersion_code() {
        return version_code;
    }

    public void setVersion_code(int version_code) {
        this.version_code = version_code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIs_force_update() {
        return is_force_update;
    }

    public void setIs_force_update(int is_force_update) {
        this.is_force_update = is_force_update;
    }

    public int getIs_back_download() {
        return is_back_download;
    }

    public void setIs_back_download(int is_back_download) {
        this.is_back_download = is_back_download;
    }

}
