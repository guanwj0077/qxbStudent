package com.qxb.student.common.http.task;

import android.arch.lifecycle.MutableLiveData;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.utils.ExecutorUtils;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * http任务
 *
 * @author winky
 * @date 2018/7/31
 */
public class HttpTask<T> implements Runnable {

    /**
     * 返回给页面的数据监听
     */
    private MutableLiveData<T> netLiveData;
    /**
     * 查询本地数据，改部分异步执行
     */
    private ClientTask<T> clientTask;
    /**
     * 定义retrofit返回模型
     */
    private Call<ApiModel<T>> call;
    /**
     * 数据处理，此步骤包含netLiveData.postValue
     */
    private DataHandle<T> handle;
    /**
     * 数据处理，此步骤不包含netLiveData.postValue
     */
    private ApiModelHandle<T> apiModelHandle;

    private boolean alreadyReq;

    public HttpTask<T> netLive(MutableLiveData<T> netLiveData) {
        this.netLiveData = netLiveData;
        return this;
    }

    public HttpTask<T> localLive(ClientTask<T> clientTask) {
        this.clientTask = clientTask;
        return this;
    }

    public HttpTask<T> call(Call<ApiModel<T>> call) {
        this.call = call;
        return this;
    }

    public HttpTask<T> handle(DataHandle<T> handle) {
        this.handle = handle;
        this.apiModelHandle = null;
        return this;
    }

    public HttpTask<T> apiModel(ApiModelHandle<T> apiModelHandle) {
        this.handle = null;
        this.apiModelHandle = apiModelHandle;
        return this;
    }

    public void start() {
        ExecutorUtils.getInstance().addTask(this);
    }

    public void cancel() {
        ExecutorUtils.getInstance().remove(this);
    }

    public boolean isAlreadyReq() {
        return alreadyReq;
    }

    @Override
    public final void run() {
        //标记改任务已执行
        alreadyReq = true;
        try {
            //如果数据有本地存储则先检查本地数据
            if (clientTask != null) {
                T data = clientTask.reqInSQLite();
                //判断泛型类型是集合还是单个对象，如果有数据则直接post给liveData
                if (data != null) {
                    if (data instanceof List) {
                        if (((List) data).size() > 0) {
                            netLiveData.postValue(data);
                            return;
                        }
                    } else {
                        netLiveData.postValue(data);
                        return;
                    }
                }
            }
            //执行网络请求
            ApiModel<T> apiModel = call.execute().body();
            if ((apiModel != null ? apiModel.getCode() : 0) == Config.HTTP_SUCCESS) {
                //如果页面需要apiModel
                if (apiModelHandle != null) {
                    apiModelHandle.handle(apiModel);
                } else {
                    netLiveData.postValue(apiModel.getData());
                    if (handle != null) {
                        handle.handle(apiModel.getData());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
