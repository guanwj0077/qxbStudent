package com.qxb.student.ui.home.school.question;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewStub;

import com.qxb.student.R;
import com.qxb.student.common.basics.AbsRefreshFragment;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.CollegeQuestion;
import com.qxb.student.common.utils.NavigationUtils;
import com.qxb.student.common.view.recycler.ViewHolder;
import com.qxb.student.common.view.recycler.adapter.QuickAdapter;
import com.qxb.student.control.SchoolComQuestionControl;

import java.util.List;

/**
 * @author winky
 * @date 2018/8/10
 */
public class SchoolComQuestionListFragment extends AbsRefreshFragment<CollegeQuestion> {

    private static final String SCHOOL_ID = "school_id";
    private static final String SCHOOL_TYPE = "school_type";

    /**
     * 入参
     *
     * @param schoolId   学校id
     * @param schoolType 学校类型  1 为普通高校  2 为自主招生
     */
    public static Bundle create(String schoolId, String schoolType) {
        Bundle bundle = new Bundle();
        bundle.putString(SCHOOL_ID, schoolId);
        bundle.putString(SCHOOL_TYPE, schoolType);
        return bundle;
    }

    private String schoolId;
    private String schoolType;
    private SchoolComQuestionControl control;

    @Override
    public void init(@Nullable Bundle savedInstanceState) {
        schoolId = getArguments() != null ? getArguments().getString(SCHOOL_ID) : null;
        schoolType = getArguments() != null ? getArguments().getString(SCHOOL_TYPE) : null;
        if (TextUtils.isEmpty(schoolId) || TextUtils.isEmpty(schoolType)) {
            NavigationUtils.getInstance().goBack(getFragment());
            return;
        }
        setTitle(R.string.title_com_question);
        control = ViewModelProviders.of(this).get(SchoolComQuestionControl.class);
        control.getLiveData().observe(this, new Observer<ApiModel<List<CollegeQuestion>>>() {
            @Override
            public void onChanged(@Nullable ApiModel<List<CollegeQuestion>> apiModel) {
                if (apiModel != null) {
                    refreshData(apiModel.getData(), apiModel.getTotal());
                }
            }
        });
        autoRefresh();
    }

    @Override
    public void reqData(int pageIndex) {
        control.schoolQuestionList(schoolId, schoolType, pageIndex);
    }

    @Override
    public QuickAdapter<CollegeQuestion> initAdapter() {
        return new QuickAdapter<CollegeQuestion>(R.layout.item_school_com_question) {
            @Override
            protected void convert(ViewHolder holder, int position, CollegeQuestion item) {
                holder.setText(R.id.text1, String.valueOf(position + 1));
                holder.setText(R.id.text2, item.getTitle());
            }
        };
    }

    @Override
    public ViewStub setEmptyView(ViewStub viewStub) {
        return null;
    }
}
