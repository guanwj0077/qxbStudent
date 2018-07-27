package com.qxb.student.common.module;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.api.BaseNewsApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.Bankao;
import com.qxb.student.common.utils.ExecutorUtils;
import com.qxb.student.common.utils.UserCache;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import retrofit2.Call;

/**
 * @author winky
 * @date 2018/7/27
 */
public class NewsRepository extends BaseRepository {

    private MutableLiveData<List<Bankao>> bankaoLiveData = new MutableLiveData<>();

    public LiveData<List<Bankao>> getBankaoList(final String keyWord, final String channel, final String page) {
        ExecutorUtils.getInstance().addTask(new Runnable() {
            @Override
            public void run() {
                try {
                    boolean readCache = "1".equals(page) && !TextUtils.isEmpty(channel);
//                    if (readCache) {
//                        List<Bankao> bankaoList = roomUtils.bankaoDao().getBankaoCache(channel);
//                        bankaoLiveData.postValue(bankaoList);
//                        return;
//                    }
                    Map<String, String> params = new ConcurrentHashMap<>();
                    params.put("keyword", keyWord);
                    params.put("channel", channel);
                    params.put("page", page);
                    params.put("province", UserCache.getInstance().getProvince());
                    params.put("stu_id", UserCache.getInstance().getUserId());
                    Call<ApiModel<List<Bankao>>> call = httpUtils.create(BaseNewsApi.class).baseNewslist(params);
                    ApiModel<List<Bankao>> apiModel = call.execute().body();
                    if ((apiModel != null ? apiModel.getCode() : 0) == Config.HTTP_SUCCESS) {
                        bankaoLiveData.postValue(apiModel.getData());
                        if (readCache) {
                            roomUtils.bankaoDao().insert(apiModel.getData());
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return bankaoLiveData;
    }
}
