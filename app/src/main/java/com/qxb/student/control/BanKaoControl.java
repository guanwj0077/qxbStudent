package com.qxb.student.control;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.qxb.student.R;
import com.qxb.student.common.module.CollectionRepository;
import com.qxb.student.common.module.NewsRepository;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.Bankao;
import com.qxb.student.common.module.bean.BaseNews;
import com.qxb.student.common.module.bean.BaseNewsComment;
import com.qxb.student.common.module.bean.SchoolDetail;
import com.qxb.student.common.utils.dialog.ToastUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 伴考
 *
 * @author winky
 * @date 2018/7/20
 */
public class BanKaoControl extends AndroidViewModel {


    private NewsRepository newsRepository = new NewsRepository();
    private CollectionRepository collectionRepository = new CollectionRepository();

    private MutableLiveData<BaseNews> baseNewsLiveData;

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
        return baseNewsLiveData = newsRepository.getBankaoDetail(bankaoId);
    }

    public LiveData<ApiModel<List<BaseNewsComment>>> getBaseNewsCommentList(String id) {
        return newsRepository.getBaseNewsCommentList(id, 1, "10");
    }

    public LiveData<Boolean> commentPraise(String newId, String commentId) {
        return newsRepository.commentPraise(newId, commentId);
    }

    public LiveData<Boolean> cancelCommentPraise(String newId, String commentId) {
        return newsRepository.cancelCommentPraise(newId, commentId);
    }

    public void collection(Fragment fragment, String newId) {
        final BaseNews baseNews = baseNewsLiveData.getValue();
        if (baseNews == null) {
            return;
        }
        if (baseNews.getIs_collectioned() == 0) {
            collectionRepository.add(newId, "10", "").observe(fragment, new Observer<Boolean>() {
                @Override
                public void onChanged(@Nullable Boolean aBoolean) {
                    if (aBoolean) {
                        baseNews.setIs_collectioned(1);
                        baseNewsLiveData.setValue(baseNews);
                        ToastUtils.toast(R.string.hint_add_collection);
                    }
                }
            });
        } else {
            collectionRepository.cancel(newId, "10").observe(fragment, new Observer<Boolean>() {
                @Override
                public void onChanged(@Nullable Boolean aBoolean) {
                    if (aBoolean) {
                        baseNews.setIs_collectioned(0);
                        baseNewsLiveData.setValue(baseNews);
                        ToastUtils.toast(R.string.hint_cancel);
                    }
                }
            });
        }
    }

    public LiveData<Boolean> submitNewsReview(String newsId, String content) {
        return newsRepository.submitNewsReview(newsId, content);
    }

    /**
     * newsId       伴考id(必传)
     * type         1：伴考 2：系统通知 3：推送消息(必传)
     * tag          新老版本区分标志，新版本传参旧版本不传
     * msgId        推送消息id
     * receiverType 接收消息者类型，1.学生，2老师
     * receiverId   接收消息者id，学生对应user_id,	老师暂无
     *
     * @return
     */
    public LiveData<SchoolDetail> connectSchool(String newsId) {
        Map<String, String> params = new HashMap<>();
        params.put("newsId", newsId);
        params.put("type", "1");
        params.put("tag", "1");
        return newsRepository.connectSchool(params);
    }

}
