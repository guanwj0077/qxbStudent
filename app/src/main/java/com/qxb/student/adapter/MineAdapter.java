package com.qxb.student.adapter;


import android.support.v4.app.Fragment;

import com.qxb.student.R;
import com.qxb.student.common.module.bean.MineData;
import com.qxb.student.common.module.bean.ScoreInfo;
import com.qxb.student.common.view.recycler.ViewHolder;
import com.qxb.student.common.view.recycler.adapter.NestingAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class MineAdapter extends NestingAdapter {
    private static final int HEAD_VIEW = 1;
    private static final int BODY_VIEW = 2;
    private Fragment fragment;
    private ScoreInfo mScoreInfo;
    private List<MineData>mData=new ArrayList<>();
    public MineAdapter(Fragment fragment) {
        this.fragment = fragment;
        addItemType(HEAD_VIEW, R.layout.recyclerview_mine_headview);
        //addItemType(BODY_VIEW,);
    }

    @Override
    protected void convert(ViewHolder holder, int position) {


    }

}
