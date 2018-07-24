package com.qxb.student.control;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;

import com.qxb.student.R;
import com.qxb.student.common.adapter.FragmentAdapter;
import com.qxb.student.common.module.SchoolRepository;
import com.qxb.student.common.module.bean.School;
import com.qxb.student.common.module.bean.SchoolNews;
import com.qxb.student.common.module.bean.SchoolVideo;
import com.qxb.student.common.view.Toolbar;
import com.qxb.student.databinding.FragmentSchoolBinding;
import com.qxb.student.ui.home.school.SchoolConductFragment;
import com.qxb.student.ui.home.school.SchoolDetailFragment;
import com.qxb.student.ui.home.school.SchoolIntroFragment;
import com.qxb.student.ui.home.school.SchoolRecruitMajorFragment;

import java.util.Arrays;
import java.util.List;

/**
 * 学校
 *
 * @author winky
 * @date 2018/7/20
 */
public class SchoolControl extends AndroidViewModel {

    public SchoolControl(@NonNull Application application) {
        super(application);
    }

    private SchoolDetailFragment fragment;
    private FragmentSchoolBinding binding;
    private SchoolRepository schoolRepository = new SchoolRepository();

    private String schoolId;
    private LiveData<List<SchoolNews>> schoolNewsLiveData;


    @Override
    protected void onCleared() {
        super.onCleared();
        binding.unbind();
        schoolRepository = null;
        fragment = null;
    }

    public void init(SchoolDetailFragment fragment, View view, String schoolId) {
        this.fragment = fragment;
        this.binding = DataBindingUtil.bind(view);
        this.schoolId = schoolId;
        final Toolbar toolbar = view.findViewById(R.id.toolbar);
        fragment.setSupportActionBar(toolbar);
        toolbar.setAppBarLayout(binding.appBarLayout);
        binding.viewPager.setAdapter(new FragmentAdapter(fragment.getChildFragmentManager(), Arrays.asList(
                new SchoolRecruitMajorFragment().setTitle(fragment.getString(R.string.school_major)),
                new SchoolIntroFragment().setTitle(fragment.getString(R.string.school_intro)),
                new SchoolConductFragment().setTitle(fragment.getString(R.string.school_conduct))
        )));
        binding.viewPager.addOnPageChangeListener(pageChangeListener);
        binding.radioGroup.setOnCheckedChangeListener(checkedChangeListener);
        binding.radioGroup.check(binding.radioGroup.getChildAt(0).getId());
        binding.viewPager.setCurrentItem(0);
        schoolRepository.getSchoolById(schoolId).observe(fragment, new Observer<School>() {
            @Override
            public void onChanged(@Nullable School school) {
                binding.setSchool(school);
                binding.includeHeader.setSchool(school);
                if (school != null) {
                    toolbar.setTitle(school.getSchool_name());
                }

            }
        });
        schoolRepository.getSchoolVideoList(schoolId, "3", "1").observe(fragment, new Observer<List<SchoolVideo>>() {
            @Override
            public void onChanged(@Nullable List<SchoolVideo> schoolVideos) {
                if (schoolVideos.size() > 0) {
                    binding.includeVideo.setVideo1(schoolVideos.get(0));
                    binding.includeVideo.setVideo2(schoolVideos.get(1));
                    binding.includeVideo.setVideoSize(schoolVideos.size());
                }
            }
        });
    }

    public LiveData<List<SchoolNews>> getSchoolNews(int page) {
        return schoolRepository.getSchoolNews(schoolId, "3", "", String.valueOf(page));
    }

    public String getSchoolId() {
        return schoolId;
    }

    private RadioGroup.OnCheckedChangeListener checkedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            int index = binding.radioGroup.indexOfChild(fragment.findViewById(i));
            if (binding.viewPager.getCurrentItem() != index) {
                binding.viewPager.setCurrentItem(index);
            }
        }
    };

    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            binding.radioGroup.check(binding.radioGroup.getChildAt(i).getId());
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
