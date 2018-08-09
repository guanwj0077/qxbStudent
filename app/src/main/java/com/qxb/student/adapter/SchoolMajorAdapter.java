package com.qxb.student.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.qxb.student.R;
import com.qxb.student.common.listener.MultiClickUtil;
import com.qxb.student.common.listener.OnPositionClickListener;
import com.qxb.student.common.module.bean.CollegeMajorRecruit;
import com.qxb.student.common.module.bean.CollegeMajorRecruitProfess;
import com.qxb.student.common.view.abslist.adapter.AbsAdapter;
import com.qxb.student.common.view.recycler.ViewHolder;
import com.qxb.student.common.view.recycler.adapter.NestingAdapter;
import com.qxb.student.control.SchoolMajorControl;
import com.qxb.student.ui.home.school.SchoolMajorDetailFragment;

import java.util.Arrays;
import java.util.List;

/**
 * @author winky
 * @date 2018/8/9
 */
public class SchoolMajorAdapter extends NestingAdapter {

    private static final int MAJOR_INFO = 0;
    private static final int MAJOR_SCORE = 1;
    private static final int MAJOR_DESC = 2;
    private static final int MAJOR_SIMILAR = 3;

    private final SchoolMajorDetailFragment fragment;
    private final CollegeMajorRecruit collegeMajor;
    private final SchoolMajorControl majorControl;

    private AbsAdapter<String> infoAdapter;
    private AbsAdapter<CollegeMajorRecruitProfess> professAdapter;

    public SchoolMajorAdapter(@NonNull SchoolMajorDetailFragment fragment, CollegeMajorRecruit collegeMajor, SchoolMajorControl majorControl) {
        this.fragment = fragment;
        this.collegeMajor = collegeMajor;
        this.majorControl = majorControl;
        addItemType(MAJOR_INFO, R.layout.item_school_major_info);
        addItemType(MAJOR_SCORE, R.layout.item_school_major_score);
        addItemType(MAJOR_DESC, R.layout.item_school_major_desc);
        addItemType(MAJOR_SIMILAR, R.layout.item_school_major_similar);
        initAdapter();
    }

    private void initAdapter() {
        String recruit = collegeMajor.getRecruit_num() > 0 ? String.format(getStr(R.string.school_major_recruit_num), collegeMajor.getRecruit_num()) : getStr(R.string.school_major_no_recruit);
        List<String> stringList = Arrays.asList(
                String.format(getStr(R.string.school_major_name), collegeMajor.getMajor_name()),
                String.format(getStr(R.string.school_major_grade), getStr(collegeMajor.getMajor_type() == 1 ? R.string.ben_ke : R.string.zhuan_ke)),
                String.format(getStr(R.string.school_major_parent), collegeMajor.getSubject_name()),
                String.format(getStr(R.string.school_major_recruit), recruit)
        );
        infoAdapter = new AbsAdapter<String>(fragment.getContext(), R.layout.item_text_common, stringList) {
            @Override
            protected void bindView(View view, int position, String item) {
                setText(view, R.id.text1, item);
            }
        };
        professAdapter = new AbsAdapter<CollegeMajorRecruitProfess>(fragment.getContext(), R.layout.item_text_arrow_right, collegeMajor.getSimilar_list()) {
            @Override
            protected void bindView(View view, int position, CollegeMajorRecruitProfess item) {
                setText(view, R.id.text1, item.getProfessName());
                setOnClickListener(view, new OnPositionClickListener(position) {
                    @Override
                    public void onPositionClick(View view, int position) {
                        if (!MultiClickUtil.isFastClick()) {
                            return;
                        }
                        fragment.showWaitingDialog();
                        CollegeMajorRecruitProfess item = getItem(position);
                        majorControl.getSchoolProfessNew(item.getId());
                    }
                });
            }
        };
    }

    private String getStr(@StringRes int resId) {
        return fragment.getString(resId);
    }

    @Override
    protected void convert(ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case MAJOR_INFO: {
                holder.setImageResource(R.id.tag_image, R.mipmap.pre_edu_base_info);
                holder.setText(R.id.tag_text, getStr(R.string.hint_school_major_info));
                ListView listView = holder.getView(R.id.listView);
                listView.setDividerHeight(0);
                listView.setAdapter(infoAdapter);
            }
            break;
            case MAJOR_SCORE:
                holder.setImageResource(R.id.tag_image, R.mipmap.zylqfs);
                holder.setText(R.id.tag_text, getStr(R.string.hint_school_major_score));

                break;
            case MAJOR_DESC: {
                holder.setImageResource(R.id.tag_image, R.mipmap.pre_edu_pro_info);
                holder.setText(R.id.tag_text, getStr(R.string.hint_school_major_desc));
                boolean noDesc = TextUtils.isEmpty(collegeMajor.getRemark()) || getStr(R.string.hint_not_data).equals(collegeMajor.getRemark());
                TextView text1 = holder.getView(R.id.text1);
                TextView emptyView = holder.getView(R.id.empty_text1);
                if (noDesc) {
                    text1.setVisibility(View.GONE);
                    emptyView.setVisibility(View.VISIBLE);
                } else {
                    emptyView.setVisibility(View.GONE);
                    text1.setGravity(Gravity.TOP | Gravity.START);
                    text1.setPadding(30, 20, 30, 20);
                    text1.setText(collegeMajor.getRemark());
                    text1.setVisibility(View.VISIBLE);
                }
            }
            break;
            case MAJOR_SIMILAR: {
                holder.setImageResource(R.id.tag_image, R.mipmap.pre_edu_pro_similar);
                holder.setText(R.id.tag_text, getStr(R.string.hint_school_major_similar));
                ListView listView = holder.getView(R.id.listView);
                listView.setAdapter(professAdapter);
                listView.setEmptyView(holder.getView(R.id.empty_text1));
            }
            break;
            default:
                break;
        }
    }
}
