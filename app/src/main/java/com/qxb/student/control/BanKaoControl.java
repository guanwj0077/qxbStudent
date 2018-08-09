package com.qxb.student.control;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
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
import com.qxb.student.common.view.dialog.ToastUtils;

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

    private MutableLiveData<ApiModel<List<Bankao>>> bankaoLiveData = new MutableLiveData<>();
    private MutableLiveData<BaseNews> newsLiveData = new MutableLiveData<>();
    private MutableLiveData<ApiModel<List<BaseNewsComment>>> commentListLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> dianzanLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> quxiaoLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> commentLiveData = new MutableLiveData<>();
    private MutableLiveData<SchoolDetail> connectInfoLiveData = new MutableLiveData<>();

    private NewsRepository newsRepository = new NewsRepository();
    private CollectionRepository collectionRepository = new CollectionRepository();

    public BanKaoControl(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        bankaoLiveData = null;
        newsLiveData = null;
        commentListLiveData = null;
        dianzanLiveData = null;
        quxiaoLiveData = null;
        commentLiveData = null;
        connectInfoLiveData = null;

        newsRepository = null;
        collectionRepository = null;
    }

    public MutableLiveData<ApiModel<List<Bankao>>> getBankaoLiveData() {
        return bankaoLiveData;
    }

    public MutableLiveData<ApiModel<List<BaseNewsComment>>> getCommentListLiveData() {
        return commentListLiveData;
    }

    public void getBankaoListByType(String channel, int page) {
        newsRepository.getBankaoList(bankaoLiveData, "", channel, page);
    }

    public void getBankaoListByKeyWord(String keyWord, int page) {
        newsRepository.getBankaoList(bankaoLiveData, keyWord, "", page);
    }

    public MutableLiveData<BaseNews> getBankaoDetail(String bankaoId) {
        newsRepository.getBankaoDetail(newsLiveData, bankaoId);
        return newsLiveData;
    }

    public MutableLiveData<ApiModel<List<BaseNewsComment>>> getBaseNewsCommentList(String id) {
        newsRepository.getBaseNewsCommentList(commentListLiveData, id, 1, "5");
        return commentListLiveData;
    }

    public void getBaseNewsCommentList(String id, int page) {
        newsRepository.getBaseNewsCommentList(commentListLiveData, id, page, "10");
    }

    public MutableLiveData<Boolean> commentPraise(String newId, String commentId) {
        newsRepository.commentPraise(dianzanLiveData, newId, commentId);
        return dianzanLiveData;
    }

    public MutableLiveData<Boolean> cancelCommentPraise(String newId, String commentId) {
        newsRepository.cancelCommentPraise(quxiaoLiveData, newId, commentId);
        return quxiaoLiveData;
    }

    public void collection(Fragment fragment, String newId) {
        final BaseNews baseNews = newsLiveData.getValue();
        if (baseNews == null) {
            return;
        }
        if (baseNews.getIs_collectioned() == 0) {
            collectionRepository.add(newId, "10", "").observe(fragment, new Observer<Boolean>() {
                @Override
                public void onChanged(@Nullable Boolean aBoolean) {
                    if (aBoolean) {
                        baseNews.setIs_collectioned(1);
                        newsLiveData.setValue(baseNews);
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
                        newsLiveData.setValue(baseNews);
                        ToastUtils.toast(R.string.hint_cancel);
                    }
                }
            });
        }
    }

    public MutableLiveData<Boolean> submitNewsReview(String newsId, String content) {
        newsRepository.submitNewsReview(commentLiveData, newsId, content);
        return commentLiveData;
    }

    /**
     * newsId       伴考id(必传)
     * type         1：伴考 2：系统通知 3：推送消息(必传)
     * tag          新老版本区分标志，新版本传参旧版本不传
     * msgId        推送消息id
     * receiverType 接收消息者类型，1.学生，2老师
     * receiverId   接收消息者id，学生对应user_id,	老师暂无
     */
    public MutableLiveData<SchoolDetail> connectSchool(String newsId) {
        Map<String, String> params = new HashMap<>();
        params.put("newsId", newsId);
        params.put("type", "1");
        params.put("tag", "1");
        newsRepository.connectSchool(connectInfoLiveData, params);
        return connectInfoLiveData;
    }

}
