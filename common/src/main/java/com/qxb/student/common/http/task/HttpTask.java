package com.qxb.student.common.http.task;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.utils.ExecutorUtils;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * @author winky
 * @date 2018/7/31
 */
public class HttpTask<T> implements Runnable {

    private MutableLiveData<T> netLiveData;
    private ClientTask<T> clientTask;
    private Call<ApiModel<T>> call;
    private DataHandle<T> handle;
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
        try {
            if (clientTask != null) {
                T data = clientTask.reqInSQLite();
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
            ApiModel<T> apiModel = call.execute().body();
            alreadyReq = true;
            if ((apiModel != null ? apiModel.getCode() : 0) == Config.HTTP_SUCCESS) {
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
