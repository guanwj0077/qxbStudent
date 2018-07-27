package com.qxb.student.control;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.qxb.student.common.module.NewsRepository;
import com.qxb.student.common.module.bean.Bankao;

import java.util.List;

/**
 * 伴考
 *
 * @author winky
 * @date 2018/7/20
 */
public class BanKaoControl extends AndroidViewModel {


    private NewsRepository newsRepository = new NewsRepository();

    public BanKaoControl(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public LiveData<List<Bankao>> getBankaoListByType(String channel, String page) {
        return newsRepository.getBankaoList("", channel, page);
    }

    public LiveData<List<Bankao>> getBankaoListByKeyWord(String keyWord, String page) {
        return newsRepository.getBankaoList(keyWord, "", page);
    }
}
