package com.qxb.student.common.module;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.qxb.student.common.Config;
import com.qxb.student.common.http.task.ApiModelHandle;
import com.qxb.student.common.http.task.ClientTask;
import com.qxb.student.common.http.task.HttpTask;
import com.qxb.student.common.module.api.BaseNewsApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.Bankao;
import com.qxb.student.common.module.bean.BaseNews;
import com.qxb.student.common.module.bean.BaseNewsComment;
import com.qxb.student.common.module.bean.SchoolDetail;
import com.qxb.student.common.utils.UserCache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author winky
 * @date 2018/7/27
 */
public class NewsRepository extends BaseRepository {

    private MutableLiveData<ApiModel<List<Bankao>>> bankaoLiveData = new MutableLiveData<>();
    private MutableLiveData<BaseNews> newsLiveData = new MutableLiveData<>();
    private MutableLiveData<ApiModel<List<BaseNewsComment>>> commentListLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> dianzanLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> quxiaoLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> commentLiveData = new MutableLiveData<>();
    private MutableLiveData<SchoolDetail> connectInfoLiveData = new MutableLiveData<>();

    public LiveData<ApiModel<List<Bankao>>> getBankaoList(String keyWord, final String channel, int page) {
        Map<String, String> params = new ConcurrentHashMap<>();
        params.put("keyword", keyWord);
        params.put("channel", channel);
        params.put("page", String.valueOf(page));
        params.put("rows", String.valueOf(Config.PAGE_SIZE));
        params.put("province", UserCache.getInstance().getProvince());
        params.put("stu_id", UserCache.getInstance().getUserId());
        new HttpTask<List<Bankao>>()
                .call(httpUtils.create(BaseNewsApi.class).baseNewslist(params))
                .page(page)
                .localLive(new ClientTask<List<Bankao>>() {
                    @Override
                    public List<Bankao> reqInSQLite(int pageIndex) {
                        return roomUtils.bankaoDao().getBankaoCache(channel, (pageIndex - 1) * Config.PAGE_SIZE, pageIndex * Config.PAGE_SIZE);
                    }
                })
                .apiModel(new ApiModelHandle<List<Bankao>>() {
                    @Override
                    public void handle(@NonNull ApiModel<List<Bankao>> apiModel, int pageIndex) {
                        bankaoLiveData.postValue(apiModel);
                        //如果重新刷新则清掉之前的，重新缓存
                        if (pageIndex == 1) {
                            roomUtils.bankaoDao().deleteAll();
                            roomUtils.bankaoDao().insert(apiModel.getData());
                        }
                    }
                })
                .start();
        return bankaoLiveData;
    }

    public LiveData<ApiModel<List<BaseNewsComment>>> getBaseNewsCommentList(String id, int page, String rows) {
        new HttpTask<List<BaseNewsComment>>()
                .call(httpUtils.create(BaseNewsApi.class).getBaseNewsCommentList(id, UserCache.getInstance().getUserId(), String.valueOf(page), rows))
                .page(page)
                .apiModel(new ApiModelHandle<List<BaseNewsComment>>() {
                    @Override
                    public void handle(@NonNull ApiModel<List<BaseNewsComment>> apiModel, int pageIndex) {
                        commentListLiveData.postValue(apiModel);
                    }
                }).start();
        return commentListLiveData;
    }

    public MutableLiveData<BaseNews> getBankaoDetail(String bankaoId) {
        new HttpTask<BaseNews>()
                .netLive(newsLiveData)
                .call(httpUtils.create(BaseNewsApi.class).baseNewsDetail(bankaoId, UserCache.getInstance().getUserId()))
                .start();
        return newsLiveData;
    }

    public LiveData<Boolean> commentPraise(String newId, String commentId) {
        new HttpTask<String>()
                .call(httpUtils.create(BaseNewsApi.class).commentPraise(newId, UserCache.getInstance().getUserId(), commentId))
                .apiModel(new ApiModelHandle<String>() {
                    @Override
                    public void handle(@NonNull ApiModel<String> apiModel, int pageIndex) {
                        dianzanLiveData.postValue(apiModel.getCode() == Config.HTTP_SUCCESS);
                    }
                }).start();
        return dianzanLiveData;
    }

    public LiveData<Boolean> cancelCommentPraise(String newId, String commentId) {
        new HttpTask<String>()
                .call(httpUtils.create(BaseNewsApi.class).cancelCommentPraise(newId, UserCache.getInstance().getUserId(), commentId))
                .apiModel(new ApiModelHandle<String>() {
                    @Override
                    public void handle(@NonNull ApiModel<String> apiModel, int pageIndex) {
                        quxiaoLiveData.postValue(apiModel.getCode() == Config.HTTP_SUCCESS);
                    }
                }).start();
        return quxiaoLiveData;
    }

    public LiveData<Boolean> submitNewsReview(String newsId, String content) {
        new HttpTask<String>()
                .call(httpUtils.create(BaseNewsApi.class).baseNewsReview(newsId, UserCache.getInstance().getUserId(), content))
                .apiModel(new ApiModelHandle<String>() {
                    @Override
                    public void handle(@NonNull ApiModel<String> apiModel, int pageIndex) {
                        commentLiveData.postValue(apiModel.getCode() == Config.HTTP_SUCCESS);
                    }
                }).start();
        return commentLiveData;
    }

    public LiveData<SchoolDetail> connectSchool(Map<String, String> hashMap) {
        new HttpTask<SchoolDetail>()
                .call(httpUtils.create(BaseNewsApi.class).connectSchool(hashMap))
                .netLive(connectInfoLiveData)
                .start();
        return connectInfoLiveData;
    }

}
