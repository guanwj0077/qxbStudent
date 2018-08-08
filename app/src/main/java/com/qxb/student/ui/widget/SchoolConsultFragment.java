package com.qxb.student.ui.widget;

import android.app.Dialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.qxb.student.R;
import com.qxb.student.common.listener.MultiClickUtil;
import com.qxb.student.common.module.bean.RongyUser;
import com.qxb.student.common.utils.GlideUtils;
import com.qxb.student.common.utils.SysUtils;
import com.qxb.student.common.utils.dialog.DialogUtils;
import com.qxb.student.common.view.abslist.GridView;
import com.qxb.student.common.view.abslist.adapter.AbsAdapter;
import com.qxb.student.control.SchoolControl;
import com.qxb.student.helper.HintHelper;

import java.util.List;
import java.util.Objects;

/**
 * @author winky
 * @date 2018/8/8
 */
public class SchoolConsultFragment extends DialogFragment {

    public static SchoolConsultFragment create() {
        SchoolConsultFragment fragment = new SchoolConsultFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        schoolControl = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(SchoolControl.class);
        dialogUtils = new DialogUtils(getContext());
    }

    private SchoolControl schoolControl;
    private AbsAdapter<RongyUser> adapter;
    private DialogUtils dialogUtils;
    private GridView gridView;
    private LinearLayout layout1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_school_consult, container, false);
        gridView = view.findViewById(R.id.gridView);
        gridView.setEmptyView(view.findViewById(R.id.empty_text1));
        view.findViewById(R.id.text1).setOnClickListener(clickListener);
        view.findViewById(R.id.image1).setOnClickListener(clickListener);
        layout1 = view.findViewById(R.id.layout1);
        adapter = new AbsAdapter<RongyUser>(getContext(), R.layout.item_teacher_list) {
            @Override
            protected void bindView(View view, int position, RongyUser item) {
                GlideUtils.getInstance().LoadContextCircleBitmap(getContext(), item.getPicRealPath(), (ImageView) view.findViewById(R.id.image1));
                setText(view, R.id.text1, item.getName());
                setText(view, R.id.text2, item.getDepartment());
            }
        };
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                toRongIMChat(adapter.getItem(position));
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dialogUtils.show();
        schoolControl.teacherListBySchoolId().observe(this, new Observer<List<RongyUser>>() {
            @Override
            public void onChanged(@Nullable List<RongyUser> rongyUsers) {
                if (dialogUtils != null) {
                    dialogUtils.dismiss();
                }
                layout1.setVisibility(rongyUsers == null || rongyUsers.size() == 0 ? View.VISIBLE : View.GONE);
                if (rongyUsers != null) {
                    gridView.setAdapter(adapter);
                    adapter.clear();
                    adapter.addCollection(rongyUsers);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!MultiClickUtil.isFastClick()) {
                return;
            }
            switch (view.getId()) {
                case R.id.image1:
                    dismiss();
                    break;
                case R.id.text1:
                    //跳转常见问题
                    if (HintHelper.hasLogin(getContext())) {

                    }
                    break;
            }
        }
    };

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        if (window != null) {
            //设置窗体背景色透明
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            //设置宽高
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            DisplayMetrics displayMetrics = SysUtils.getInstance().getDisplayMetrics();
            layoutParams.width = (int) (0.8 * displayMetrics.widthPixels);
            layoutParams.height = (int) (0.6 * displayMetrics.heightPixels);
            //透明度
            layoutParams.dimAmount = 0.2f;
            //位置
            layoutParams.gravity = Gravity.CENTER;
            window.setAttributes(layoutParams);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(true);
        Objects.requireNonNull(dialog.getWindow()).setWindowAnimations(R.style.MyDialogStyleTop2);
        return dialog;
    }
}
