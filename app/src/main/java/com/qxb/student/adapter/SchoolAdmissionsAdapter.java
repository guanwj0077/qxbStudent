package com.qxb.student.adapter;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.qxb.student.R;
import com.qxb.student.common.Constant;
import com.qxb.student.common.listener.OnPositionClickListener;
import com.qxb.student.common.module.bean.Admission;
import com.qxb.student.common.module.bean.MajorBat;
import com.qxb.student.common.module.bean.MajorChild;
import com.qxb.student.common.module.bean.MajorParent;
import com.qxb.student.common.module.bean.ScoreBat;
import com.qxb.student.common.module.bean.ScoreLine;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.utils.BindingUtils;
import com.qxb.student.common.utils.NavigationUtils;
import com.qxb.student.common.utils.UserCache;
import com.qxb.student.common.view.abslist.ExpandableListView;
import com.qxb.student.common.view.abslist.adapter.AbsAdapter;
import com.qxb.student.common.view.abslist.adapter.ExpandableAdapter;
import com.qxb.student.common.view.abslist.bean.ExpandableEntity;
import com.qxb.student.common.view.popup.ListPopupWindow;
import com.qxb.student.common.view.recycler.ViewHolder;
import com.qxb.student.common.view.recycler.adapter.NestingAdapter;
import com.qxb.student.control.SchoolControl;
import com.qxb.student.type.BenZhuanBatchType;
import com.qxb.student.ui.home.school.SchoolMajorDetailFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author winky
 * @date 2018/7/25
 */
public class SchoolAdmissionsAdapter extends NestingAdapter {
    private static final int SCORE_BAT = 0;
    private static final int SCORE_LINE = 1;
    private static final int MAJOR_TAG = 2;
    private static final int MAJOR = 3;
    private final SchoolControl schoolControl;
    private final Fragment fragment;
    private MutableLiveData<SparseArray<Admission>> admissionLiveData = new MutableLiveData<>();
    private ExpandableAdapter<MajorParent, List<MajorChild>> majorAdapter;
    private AbsAdapter<ScoreLine> scoreAdapter;
    private volatile ExpandableListView expandableListView;
    private ListPopupWindow<Admission> popupWindow;
    private volatile TextView textView;

    public SchoolAdmissionsAdapter(Fragment fragmentTemp, String schoolId, final int bat) {
        this.fragment = fragmentTemp;
        schoolControl = ViewModelProviders.of(Objects.requireNonNull(fragmentTemp.getActivity())).get(SchoolControl.class);
        addItemType(SCORE_BAT, R.layout.header_school_admissions_info);
        addItemType(SCORE_LINE, R.layout.item_school_score);
        addItemType(MAJOR_TAG, R.layout.view_module_tag);
        addItemType(MAJOR, R.layout.item_school_major);
        majorAdapter = new ExpandableAdapter<MajorParent, List<MajorChild>>(fragment.getContext(), R.layout.item_school_major_parent, R.layout.view_list) {

            @Override
            public void bindGroupView(View view, int position, boolean isExpanded, MajorParent item) {
                setVisibility(view, R.id.line1, position != 0);
                setText(view, R.id.text1, String.valueOf(position + 1));
                setText(view, R.id.text2, String.valueOf(item.getTotal()));
                setText(view, R.id.text3, item.getName());
                setArrowExpanded(view, R.id.image1, isExpanded);
            }

            @Override
            public void bindChildView(View view, List<MajorChild> item) {
                ListView listView = view.findViewById(R.id.listView);
                listView.setAdapter(new AbsAdapter<MajorChild>(fragment.getContext(), R.layout.item_school_major_child, item) {
                    @Override
                    protected void bindView(View view, int position, MajorChild item) {
                        setText(view, R.id.text1, item.getMajor_name());
                        String hint = item.getRecruit_num() > 0 ? String.valueOf(item.getRecruit_num()) : "-";
                        setText(view, R.id.text2, String.format(fragment.getString(R.string.combine_plan), item.getYear(), hint));
                        setText(view, R.id.text3, item.getSubject_name());
                        view.setOnClickListener(new OnPositionClickListener(position) {
                            @Override
                            public void onPositionClick(View view, int position) {
                                MajorChild majorChild = getItem(position);
                                NavigationUtils.getInstance().jump(fragment, R.id.nav_school_major, SchoolMajorDetailFragment.create(majorChild.getId()));
                            }
                        });
                    }
                });
            }
        };
        scoreAdapter = new AbsAdapter<ScoreLine>(fragment.getContext(), R.layout.item_school_score_line) {
            @Override
            protected void bindView(View view, int position, ScoreLine item) {
                view.setBackgroundResource(android.R.color.white);
                setText(view, R.id.text1, item.getYear() == 0 ? "-" : String.valueOf(item.getYear()));
                setText(view, R.id.text2, item.getScore_avg() == 0 ? "-" : String.valueOf(item.getScore_avg()));
                setText(view, R.id.text3, item.getScore_top() == 0 ? "-" : String.valueOf(item.getScore_top()));
                setText(view, R.id.text4, item.getScove_min() == 0 ? "-" : String.valueOf(item.getScove_min()));
                setText(view, R.id.text5, item.getControlline() == 0 ? "-" : String.valueOf(item.getControlline()));
            }
        };
        admissionLiveData.observe(fragment, new Observer<SparseArray<Admission>>() {
            @Override
            public void onChanged(@Nullable SparseArray<Admission> array) {
                if (textView == null || expandableListView == null) {
                    return;
                }
                if (array != null && array.size() > 0) {
                    refreshUI(bat != 0 ? array.get(bat) : array.valueAt(0));
                } else {
                    textView.setText(fragment.getString(R.string.hint_not_data));
                }
            }
        });
        schoolControl.getSchoolRecruitMajor(schoolId).observe(fragment, new Observer<List<MajorBat>>() {
            @Override
            public void onChanged(@Nullable List<MajorBat> majorBats) {
                if (majorBats != null) {
                    //专业数据组装并更新UI
                    SparseArray<Admission> admissionList = loadAdmissions();
                    for (MajorBat majorBat : majorBats) {
                        List<MajorParent> majorParentList = majorBat.getData();
                        if (majorParentList == null || majorParentList.size() == 0) {
                            continue;
                        }
                        Admission admission = loadAdmission(admissionList, majorBat.getBat());
                        admission.setBatch(majorBat.getBat());
                        admission.setBatchName(majorBat.getName());
                        for (MajorParent majorParent : majorParentList) {
                            admission.addExpandableEntity(new ExpandableEntity<MajorParent, List<MajorChild>>(majorParent, majorParent.getChildrens()));
                        }
                        admissionList.append(majorBat.getBat(), admission);
                    }
                    admissionLiveData.setValue(admissionList);
                }
            }
        });
        schoolControl.getSchoolScore(schoolId).observe(fragment, new Observer<List<ScoreBat>>() {
            @Override
            public void onChanged(@Nullable List<ScoreBat> scoreBats) {
                if (scoreBats != null) {
                    //分数线数据组装并更新UI
                    SparseArray<Admission> admissionList = loadAdmissions();
                    for (ScoreBat scoreBat : scoreBats) {
                        List<ScoreLine> scoreLineList = scoreBat.getData();
                        if (scoreLineList == null || scoreLineList.size() == 0) {
                            continue;
                        }
                        Admission admission = loadAdmission(admissionList, scoreBat.getBat());
                        admission.setBatch(scoreBat.getBat());
                        admission.setBatchName(scoreBat.getName());
                        admission.setScoreLineList(scoreLineList);
                        admissionList.append(admission.getBatch(), admission);
                    }
                    admissionLiveData.setValue(admissionList);
                }
            }
        });
        popupWindow = new ListPopupWindow<>(fragment.getContext());
    }

    private void refreshUI(Admission admission) {
        List<ScoreLine> scoreLineList = admission.getScoreLineList();

        int scoreSize = scoreLineList != null ? scoreLineList.size() : 0;
        int majorSize = admission.getMajorBatList().size();
        scoreAdapter.clear();
        majorAdapter.clear();
        if (scoreSize > 0) {
            scoreAdapter.addCollection(scoreLineList);
        }
        if (majorSize > 0) {
            majorAdapter.setData(admission.getMajorBatList());
            expandableListView.expandGroup(0);
        }
        scoreAdapter.notifyDataSetChanged();
        majorAdapter.notifyDataSetChanged();
        //数据加载完成后，不再执行以下逻辑
        if (admissionLiveData != null) {
            schoolControl.dissWaitingDialog();
            if (scoreSize > 0 && majorSize > 0) {
                SparseArray<Admission> array = admissionLiveData.getValue();
                List<Admission> admissionList = new ArrayList<>(array.size());
                for (int i = 0; i < array.size(); i++) {
                    admissionList.add(array.valueAt(i));
                }
                admissionLiveData.removeObservers(fragment);
                admissionLiveData = null;
                popupWindow.setAdapter(new AbsAdapter<Admission>(fragment.getContext(), R.layout.view_text, admissionList) {
                    @Override
                    protected void bindView(View view, int position, Admission item) {
                        setText(view, R.id.text1, BenZhuanBatchType.getNameByBat(item.getBatch()));
                        view.setOnClickListener(new OnPositionClickListener(position) {
                            @Override
                            public void onPositionClick(View view, int position) {
                                popupWindow.dismiss();
                                refreshUI(getItem(position));
                            }
                        });
                    }
                });

                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        BindingUtils.setTextDrawable(textView, R.mipmap.down);
                    }
                });
            }
        }
        textView.setText(BenZhuanBatchType.getNameByBat(admission.getBatch()));
    }

    private SparseArray<Admission> loadAdmissions() {
        if (admissionLiveData == null) {
            admissionLiveData = new MutableLiveData<>();
        }
        return admissionLiveData.getValue() == null ? new SparseArray<Admission>(5) : admissionLiveData.getValue();
    }

    private Admission loadAdmission(SparseArray<Admission> admissionList, int bat) {
        Admission admission = admissionList.get(bat);
        if (admission == null) {
            admission = new Admission();
        }
        return admission;
    }

    @Override
    protected void convert(final ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case SCORE_BAT:
                holder.setOnClickListener(R.id.text2, clickListener);
                textView = holder.getView(R.id.text2);
                textView.setOnClickListener(clickListener);
                User user = UserCache.getInstance().getUser();
                if (user == null) {
                    holder.setText(R.id.text3, Constant.DEFAULT_PROVINCE + ":" + Constant.LIKE);
                } else {
                    holder.setText(R.id.text3, user.getProvince_name() + ":" + user.getSubject());
                }
                break;
            case SCORE_LINE:
                ListView listView = holder.getView(R.id.listView);
                listView.setBackgroundResource(R.color.colorDivider);
                listView.setAdapter(scoreAdapter);
                listView.setEmptyView(holder.getView(R.id.empty_text1));
                listView.setDividerHeight(0);
                listView.setBackgroundResource(R.color.colorDivider);
                listView.setPadding(0, 0, 0, 20);
                break;
            case MAJOR_TAG:
                holder.setImageResource(R.id.tag_image, R.mipmap.zhaoshengjihua);
                holder.setText(R.id.tag_text, fragment.getString(R.string.hint_school_recruit));
                break;
            case MAJOR:
                expandableListView = holder.getView(R.id.expandableListView);
                expandableListView.setAdapter(majorAdapter);
                expandableListView.setEmptyView(holder.getView(R.id.empty_text1));
                break;
            default:
                break;
        }
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            if (popupWindow != null) {
                if (popupWindow.isShowing()) {
                    BindingUtils.setTextDrawable(textView, R.mipmap.down);
                } else {
                    BindingUtils.setTextDrawable(textView, R.mipmap.up);
                }
                popupWindow.showAsDropDown(textView);
            }
        }
    };
}
