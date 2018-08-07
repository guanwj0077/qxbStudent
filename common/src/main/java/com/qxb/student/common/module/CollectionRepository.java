package com.qxb.student.common.module;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.qxb.student.common.Config;
import com.qxb.student.common.http.task.ApiModelHandle;
import com.qxb.student.common.http.task.HttpTask;
import com.qxb.student.common.module.api.SysCollectionApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.SysCollection;
import com.qxb.student.common.utils.UserCache;

import java.util.List;

/**
 * 收藏相关
 * @author winky
 * @date 2018/8/6
 */
public class CollectionRepository extends BaseRepository {

    private MutableLiveData<ApiModel<List<SysCollection>>> collectionLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> addLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> cancelLiveData = new MutableLiveData<>();


    public LiveData<ApiModel<List<SysCollection>>> collectionList(String itemType, int page) {
        new HttpTask<List<SysCollection>>()
                .call(httpUtils.create(SysCollectionApi.class)
                        .collectionList(UserCache.getInstance().getUserId(), itemType, String.valueOf(page), String.valueOf(Config.PAGE_SIZE)))
                .apiModel(new ApiModelHandle<List<SysCollection>>() {
                    @Override
                    public void handle(@NonNull ApiModel<List<SysCollection>> apiModel, int pageIndex) {
                        if (apiModel.getCode() == Config.HTTP_SUCCESS) {
                            collectionLiveData.postValue(apiModel);
                        }
                    }
                })
                .start();
        return collectionLiveData;
    }

    /**
     * 收藏
     *
     * @param itemId   收藏对象id
     * @param itemType 1:专业 2：志愿 3：学校  6:自招院校 8 艺考资讯 9 艺考院校 10 伴考资讯 15：留学院校
     * @param itemName 收藏对象名称(非必传)
     */
    public LiveData<Boolean> add(String itemId, String itemType, String itemName) {
        new HttpTask<String>()
                .call(httpUtils.create(SysCollectionApi.class).collectionAdd(UserCache.getInstance().getUserId(), itemId, itemType, itemName))
                .apiModel(new ApiModelHandle<String>() {
                    @Override
                    public void handle(@NonNull ApiModel<String> apiModel, int pageIndex) {
                        addLiveData.postValue(apiModel.getCode() == Config.HTTP_SUCCESS);
                    }
                }).start();
        return addLiveData;
    }

    public LiveData<Boolean> cancel(String itemId, String itemType) {
        new HttpTask<String>()
                .call(httpUtils.create(SysCollectionApi.class).collectionCancel(UserCache.getInstance().getUserId(), itemId, itemType))
                .apiModel(new ApiModelHandle<String>() {
                    @Override
                    public void handle(@NonNull ApiModel<String> apiModel, int pageIndex) {
                        cancelLiveData.postValue(apiModel.getCode() == Config.HTTP_SUCCESS);
                    }
                }).start();
        return cancelLiveData;
    }
}
