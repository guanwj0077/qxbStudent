package com.qxb.student.control;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.qxb.student.common.module.NewsRepository;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.Bankao;
import com.qxb.student.common.module.bean.BaseNews;
import com.qxb.student.common.module.bean.BaseNewsComment;

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

    public LiveData<ApiModel<List<Bankao>>> getBankaoListByType(String channel, int page) {
        return newsRepository.getBankaoList("", channel, page);
    }

    public LiveData<ApiModel<List<Bankao>>> getBankaoListByKeyWord(String keyWord, int page) {
        return newsRepository.getBankaoList(keyWord, "", page);
    }

    public LiveData<BaseNews> getBankaoDetail(String bankaoId) {
        return newsRepository.getBankaoDetail(bankaoId);
    }

    public LiveData<ApiModel<List<BaseNewsComment>>> getBaseNewsCommentList(String id) {
        return newsRepository.getBaseNewsCommentList(id, 1, "10");
    }
}
