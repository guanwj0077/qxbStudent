package com.qxb.student.ui.UserCorrelation;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.CheckedTextView;

import com.qxb.student.R;
import com.qxb.student.common.Constant;
import com.qxb.student.common.basics.AbsExpandFragment;
import com.qxb.student.common.listener.MultiClickUtil;
import com.qxb.student.common.module.bean.Enum.MajorType;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.module.bean.attr.NavAttr;
import com.qxb.student.common.utils.NavigationUtils;
import com.qxb.student.common.view.ClearEditText;

/**
 * A simple {@link Fragment} subclass.
 *
 * @author zjk
 */
public class TwoPolishingFragment extends AbsExpandFragment {
    private ClearEditText ed_fs;
    private CheckedTextView check_tv1, check_tv2, check_tv3, check_tv4;
    private User user;
    @Override
    public int bindLayout() {
        return R.layout.fragment_two_polishing;
    }

    @Override
    public void init(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //user= UserCache.getInstance().getUser();

        ed_fs = findViewById(R.id.ed_fs);
        check_tv1 = findViewById(R.id.check_tv1);
        check_tv2 = findViewById(R.id.check_tv2);
        check_tv3 = findViewById(R.id.check_tv3);
        check_tv4 = findViewById(R.id.check_tv4);
        check_tv1.setOnClickListener(mOnClickListener);
        check_tv2.setOnClickListener(mOnClickListener);
        check_tv3.setOnClickListener(mOnClickListener);
        check_tv4.setOnClickListener(mOnClickListener);
        findViewById(R.id.btn_result).setOnClickListener(mOnClickListener);
        //initCheckView();
    }

    private void initCheckView() {
        if (user.getYugufen() != 0) {
            ed_fs.setText(String.valueOf(user.getYugufen()));
            ed_fs.setFocusable(false);
            ed_fs.setFocusableInTouchMode(false);
            }
        SparseArray<CheckedTextView> viewList=new SparseArray<>();
        if (TextUtils.isEmpty(user.getSubject())){
         switch (user.getSubject()){
             case Constant.WEN_KE:
                 resetChecked();
                 check_tv1.setChecked(true);
                 break;
             case Constant.LIKE:
                 resetChecked();
                 check_tv2.setChecked(true);
                 break;
             case Constant.YISHU_WENKE:
                 resetChecked();
                 check_tv3.setChecked(true);
                 break;
             case Constant.YISHU_LIKE:
                 resetChecked();
                 check_tv4.setChecked(true);
                 break;
                 default:
                     break;
                     }
            resetClickable();
        }else{
            check_tv1.setChecked(true);
        }
        for (MajorType majorType : MajorType.values()) {
            CheckedTextView checkedTextView = (CheckedTextView) findViewById(majorType.getId());
            if (checkedTextView != null) {
                checkedTextView.setText(majorType.getKey());
                viewList.append(majorType.getId(), checkedTextView);
            }
        }


    }


    private void resetChecked() {
        for (MajorType majorType : MajorType.values()) {
            ((CheckedTextView) findViewById(majorType.getId())).setChecked(false);
        }

    }

    private void resetClickable() {
        for (MajorType majorType : MajorType.values()) {
            ((CheckedTextView) findViewById(majorType.getId())).setClickable(false);
        }
        }

    private void sendCheck(View view){
            resetChecked();
            ((CheckedTextView) view).setChecked(true);
        }


    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (MultiClickUtil.isFastClick()) {
                switch (view.getId()) {
                    case R.id.btn_result:
                        NavigationUtils.getInstance().toNavigation(getActivity(),new NavAttr.Builder().graphRes(R.navigation.nav_three_polishing).build());
                        break;
                    case R.id.check_tv1:
                        sendCheck(view);
                        break;
                    case R.id.check_tv2:
                        sendCheck(view);
                        break;
                    case R.id.check_tv3:
                        sendCheck(view);
                        break;
                    case R.id.check_tv4:
                        sendCheck(view);
                        break;
                    default:
                        break;
                }
            }
        }
    };
}
