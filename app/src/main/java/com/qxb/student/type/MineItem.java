package com.qxb.student.type;

import com.qxb.student.common.R;

/**
 * created on: 2018/7/18 14:30
 * description:
 * @author zjk9527
 */
public enum MineItem {

    /**
     * 我的页面功能菜单
     */
    CODE1(R.mipmap.scan_code, R.string.yqm, false, true),
    CODE2(R.mipmap.integral_icon, R.string.yhm, true, true),
    CODE3(R.mipmap.icon_wgzdxx, R.string.wdsc, false, true),
    CODE4(R.mipmap.icon_wdjdxx, R.string.bmddx, true, true),
    CODE5(R.mipmap.my_order, R.string.wddd, false, true),
    CODE6(R.mipmap.wdzy, R.string.wdzyb, true, true),
    CODE7(R.mipmap.icon_wdzxk, R.string.wdzxk, false, true),
    CODE8(R.mipmap.icon_rjgx, R.string.rjgx, false, true),
    CODE9(R.mipmap.icon_kefu, R.string.ywtzkf, false, true),
    CODE10(R.mipmap.icon_help, R.string.sybz, false, true),
    CODE11(R.mipmap.fankui1, R.string.bzyfk, false, true),
    CODE13(R.mipmap.icon_wode, R.string.gywm, false, true),
    CODE12(R.mipmap.icon_tjghy, R.string.yqhylkmd, true, true);


    /**
     * draw_id 图片资源
     */
    private int drawId;
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

    MineItem(int drawId, int name, boolean isView, boolean isShow) {
        this.drawId = drawId;
        this.name = name;
        this.isView = isView;
        this.isShow = isShow;
    }

    public int getDrawId() {
        return drawId;
    }

    public int getName() {
        return name;
    }

    public boolean isView() {
        return isView;
    }

    public boolean isShow() {
        return isShow;
    }
}
