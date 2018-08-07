package com.qxb.student.ui.UserCorrelation;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.qxb.student.R;
import com.qxb.student.common.Constant;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.listener.MultiClickUtil;
import com.qxb.student.common.module.bean.Enum.YearType;
import com.qxb.student.common.module.bean.User;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * @author Administrator
 */
public class ThreePolishingFragment extends AbsExpandFragment {
    private RadioGroup rg;
    private RadioButton girl;
    private RadioButton boy;
    private CheckedTextView check_tv1, check_tv2, check_tv3, check_tv4;
    private int curYear = Calendar.getInstance().get(Calendar.YEAR);
    private User mUser;
    @Override
    public int bindLayout() {
        return R.layout.fragment_three_polishing;
    }

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        check_tv1 = findViewById(R.id.check_tv1);
        check_tv2 = findViewById(R.id.check_tv2);
        check_tv3 = findViewById(R.id.check_tv3);
        check_tv4 = findViewById(R.id.check_tv4);
        check_tv1.setOnClickListener(mOnClickListener);
        check_tv2.setOnClickListener(mOnClickListener);
        check_tv3.setOnClickListener(mOnClickListener);
        check_tv4.setOnClickListener(mOnClickListener);
        findViewById(R.id.btn_result).setOnClickListener(mOnClickListener);
        initCheckView();
    }

    private void initCheckView() {
        SparseArray<CheckedTextView> viewList=new SparseArray<>();
        int year=mUser.getYears();
        if (year!=0){
            if (year==curYear){
                resetChecked();
                check_tv1.setChecked(true);
            }else if (year==curYear+ Constant.ONE){
                resetChecked();
                check_tv2.setChecked(true);
            }else if (year==curYear+Constant.TWO){
                resetChecked();
                check_tv3.setChecked(true);
            }else  if (year==curYear+Constant.THREE){
                resetChecked();
                check_tv4.setChecked(true);
            }
            resetClickable();
        }else{
            check_tv1.setChecked(true);
        }
        if(!TextUtils.isEmpty(mUser.getSex())){
            if(Constant.MAN.equals(mUser.getSex())){
                rg.check(R.id.boy);
            }else{
                rg.check(R.id.girl);
            }
            //  disableRadioGroup(rg);
        }else{
            rg.check(R.id.girl);
        }
    }

    private View.OnClickListener mOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (MultiClickUtil.isFastClick()){
                switch (view.getId()){
                    case R.id.check_tv1:
                        sendCkeck(view);
                        break;
                    case R.id.check_tv2:
                        sendCkeck(view);
                        break;
                    case R.id.check_tv3:
                        sendCkeck(view);
                        break;
                    case R.id.check_tv4:
                        sendCkeck(view);
                        break;
                        default:
                            break;

                }
            }
        }
    };
    private void sendCkeck(View view){
        resetChecked();
        ((CheckedTextView) view).setChecked(true);
    }
    private void resetChecked() {
        for (YearType yearType : YearType.values()) {
            ((CheckedTextView) findViewById(yearType.getId())).setChecked(false);
        }
    }
    private void resetClickable() {
        for (YearType yearType : YearType.values()) {
            ((CheckedTextView) findViewById(yearType.getId())).setClickable(false);
        }
    }
    public void disableRadioGroup(RadioGroup radioGroup) {
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            radioGroup.getChildAt(i).setEnabled(false);
        }
    }
}
