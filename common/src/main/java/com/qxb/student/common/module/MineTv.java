package com.qxb.student.common.module;

import com.qxb.student.common.R;

/**
 * created on: 2018/7/18 14:30
 * description:
 * @author zjk9527
 */
public enum MineTv {

    CODE1(R.mipmap.scan_code, R.string.yqm, false, true),
    CODE2(R.mipmap.integral_icon, R.string.yhm, true, true),
    CODE3(R.mipmap.icon_wgzdxx, R.string.wdsc, false, true),
    CODE4(R.mipmap.icon_wdjdxx, R.string.bmddx, true, true),
    CODE5(R.mipmap.my_order, R.string.wddd, false, true),
    CODE6(R.mipmap.wdzy, R.string.wdzyb, true, true),
    CODE7(R.mipmap.icon_wdzxk, R.string.wdzxk, false, false),
    CODE8(R.mipmap.icon_rjgx, R.string.rjgx, false, false),
    CODE9(R.mipmap.icon_kefu, R.string.ywtzkf, false, true),
    CODE10(R.mipmap.icon_help, R.string.sybz, false, true),
    CODE11(R.mipmap.fankui1, R.string.bzyfk, false, true),
    CODE13(R.mipmap.icon_wode, R.string.gywm, false, true),
    CODE12(R.mipmap.icon_tjghy, R.string.yqhylkmd, true, true);


    /**
     * draw_id 图片资源
     */
    private int draw_id;
    /**
     * name item名字
     */
    private int name;
    /**
     * isView  是否显示加粗分割线
     */
    private boolean isView;
    /**
     * isShow 是否显示布局
     */
    private boolean isShow;

    MineTv(int draw_id, int name, boolean isView, boolean isShow) {
        this.draw_id = draw_id;
        this.name = name;
        this.isView = isView;
        this.isShow = isShow;
    }

    public int getName() {
        return name;
    }

    public boolean isView() {
        return isView;
    }


    public void setName(int name) {
        this.name = name;
    }

    public void setView(boolean view) {
        isView = view;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public int getDraw_id() {
        return draw_id;
    }

    public void setDraw_id(int draw_id) {
        this.draw_id = draw_id;
    }
}
