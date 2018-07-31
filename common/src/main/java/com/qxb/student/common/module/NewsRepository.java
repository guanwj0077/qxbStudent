package com.qxb.student.common.module;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.qxb.student.common.http.HttpTask;
import com.qxb.student.common.module.api.BaseNewsApi;
import com.qxb.student.common.module.bean.Bankao;
import com.qxb.student.common.module.bean.BaseNews;
import com.qxb.student.common.utils.UserCache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author winky
 * @date 2018/7/27
 */
public class NewsRepository extends BaseRepository {

    private MutableLiveData<List<Bankao>> bankaoLiveData = new MutableLiveData<>();
    private MutableLiveData<BaseNews> newsLiveData = new MutableLiveData<>();

    public LiveData<List<Bankao>> getBankaoList(String keyWord, String channel, String page) {
        Map<String, String> params = new ConcurrentHashMap<>();
        params.put("keyword", keyWord);
        params.put("channel", channel);
        params.put("page", page);
        params.put("province", UserCache.getInstance().getProvince());
        params.put("stu_id", UserCache.getInstance().getUserId());
        new HttpTask<List<Bankao>>()
                .netLive(bankaoLiveData)
                .call(httpUtils.create(BaseNewsApi.class).baseNewslist(params))
                .start();
        return bankaoLiveData;
    }

    public LiveData<BaseNews> getBankaoDetail(String bankaoId) {
        new HttpTask<BaseNews>()
                .netLive(newsLiveData)
                .call(httpUtils.create(BaseNewsApi.class).baseNewsDetail(bankaoId, UserCache.getInstance().getUserId()))
                .start();
        return newsLiveData;
    }
}
