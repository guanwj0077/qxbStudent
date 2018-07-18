package com.qxb.student.common.module;

import com.qxb.student.common.R;

/**
 * created on: 2018/7/18 14:30
 * description:
 * @author zjk9527
 */
public enum MineTv {

    CODE1(R.mipmap.scan_code, "邀请码", false, true),
    CODE2(R.mipmap.integral_icon, "优惠码", true, true),
    CODE3(R.mipmap.icon_wgzdxx, "我的收藏", false, true),
    CODE4(R.mipmap.icon_wdjdxx, "报名的大学", true, true),
    CODE5(R.mipmap.my_order, "我的订单", false, true),
    CODE6(R.mipmap.wdzy, "我的志愿表", true, true),
    CODE7(R.mipmap.icon_wdzxk, "我的助学卡", false, false),
    CODE8(R.mipmap.icon_rjgx, "软件更新", false, false),
    CODE9(R.mipmap.icon_kefu, "有问题找客服", false, true),
    CODE10(R.mipmap.icon_help, "使用帮助", false, true),
    CODE11(R.mipmap.fankui1, "帮助与反馈", false, true),
    CODE13(R.mipmap.icon_wode, "关于我们", false, true),
    CODE12(R.mipmap.icon_tjghy, "邀请好友，立刻免单", true, true);


    /**
     * draw_id 图片资源
     */
    private int draw_id;
    /**
     * name item名字
     */
    private String name;
    /**
     * isView  是否显示加粗分割线
     */
    private boolean isView;
    /**
     * isShow 是否显示布局
     */
    private boolean isShow;

    MineTv(int draw_id, String name, boolean isView, boolean isShow) {
        this.draw_id = draw_id;
        this.name = name;
        this.isView = isView;
        this.isShow = isShow;
    }

    public String getName() {
        return name;
    }

    public boolean isView() {
        return isView;
    }


    public void setName(String name) {
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
