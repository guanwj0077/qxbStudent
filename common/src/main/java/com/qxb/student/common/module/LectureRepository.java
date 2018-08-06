package com.qxb.student.common.module;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.qxb.student.common.http.task.HttpTask;
import com.qxb.student.common.module.api.SysLectureApi;
import com.qxb.student.common.module.bean.Lecture;

/**
 * @author: zjk9527
 * created on: 2018/8/1 9:13
 * description:
 */
public class LectureRepository extends BaseRepository {

    private MutableLiveData<Lecture> mLectureMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<String> mData = new MutableLiveData<>();

    public LiveData<Lecture> getLectureData(String account_id) {
        new HttpTask<Lecture>()
                .netLive(mLectureMutableLiveData)
                .call(httpUtils.create(SysLectureApi.class).lectureList(account_id))
                .start();
        return mLectureMutableLiveData;
    }
public LiveData<String>UsingHelp(){
        new HttpTask<String>().netLive(mData).call(httpUtils.create(SysLectureApi.class).useHelpVideo()).start();
        return mData;
}
    @Override
    public void onCleared() {
        mLectureMutableLiveData = null;
        mData = null;
    }
}
