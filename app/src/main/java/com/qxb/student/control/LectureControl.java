package com.qxb.student.control;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.qxb.student.common.module.LectureRepository;
import com.qxb.student.common.module.bean.Lecture;
import com.qxb.student.common.utils.UserCache;
import com.qxb.student.databinding.ActivityListenToLectureBinding;
import com.qxb.student.ui.home.toLecture.ListenToLectureActivity;

/**
 * @author: zjk9527
 * created on: 2018/7/31 19:31
 * description:
 */
public class LectureControl extends AndroidViewModel {

    private ListenToLectureActivity mActivity;
    private ActivityListenToLectureBinding binding;
    private LectureRepository mRepository = new LectureRepository();

    private LiveData<Lecture>mLectureLiveData=new MutableLiveData<>();
    private LiveData<String>mData=new MutableLiveData<>();

    public LectureControl(@NonNull Application application) {
        super(application);
    }

    public void init(ListenToLectureActivity activity, View view) {
        String account_id = UserCache.getInstance().getAccountId();
        if (TextUtils.isEmpty(account_id)){
            return;
        }
        this.mActivity=activity;
        this.binding= DataBindingUtil.bind(view);
        mLectureLiveData=mRepository.getLectureData(account_id);
        mLectureLiveData.observe(mActivity, new Observer<Lecture>() {
            @Override
            public void onChanged(@Nullable Lecture lecture) {
                if (lecture!=null){

                }else{

                }
            }
        });

    }
    public LiveData<String>UsingHelp(){
        return mRepository.UsingHelp();
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        if (binding!=null){
            binding.unbind();
            binding=null;
        }
        mRepository=null;
        mActivity=null;
    }
}
