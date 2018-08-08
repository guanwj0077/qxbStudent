package com.qxb.student.common.http.task;

import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;

import com.qxb.student.common.Config;
import com.qxb.student.common.http.HttpCache;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.utils.ExecutorUtils;
import com.qxb.student.common.utils.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import okio.Buffer;
import retrofit2.Call;
import retrofit2.Response;

import static com.qxb.student.common.http.HttpCache.RECEIVED_MILLIS;

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

    /**
     * 如果是分页接口
     */
    private int pageIndex;

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

    public HttpTask<T> page(int page) {
        this.pageIndex = page;
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

    @Override
    public final void run() {
        try {
//            //如果没有观察者监听数据，说明页面已经关闭则不需要请求
//            if (netLiveData != null && !netLiveData.hasObservers()) {
//                return;
//            }

            //如果数据有本地存储则先检查本地数据
            if (clientTask != null && pageIndex == 1) {
                T data = clientTask.reqInSQLite(pageIndex);
                //判断泛型类型是集合还是单个对象，如果有数据则直接post给liveData
                ApiModel<T> apiModel = new ApiModel<>();
                apiModel.setCode(Config.HTTP_SUCCESS);
                apiModel.setData(data);
                if (data != null) {
                    if (data instanceof List) {
                        if (((List) data).size() > 0) {
                            transmitData(apiModel);
                            return;
                        }
                    } else {
                        transmitData(apiModel);
                        return;
                    }
                }
            }
            if (call == null) {
                return;
            }
            //执行网络请求
            Response<ApiModel<T>> response = call.execute();
            ApiModel<T> apiModel = response.body();
            if ((apiModel != null ? apiModel.getCode() : 0) == Config.HTTP_SUCCESS) {
                transmitData(apiModel);
                //如果是缓存数据则根据写入响应头的真实接收数据时间判断数据是否过期
                String receivedTime = response.headers().get(RECEIVED_MILLIS);
                if (!TextUtils.isEmpty(receivedTime)) {
                    long time;
                    try {
                        time = Long.parseLong(receivedTime);
                    } catch (Exception ex) {
                        time = 0;
                    }
                    //检查缓存到期
                    if (time == 0 || (apiModel.getCacheTime() + time) >= System.currentTimeMillis()) {
                        HttpCache.getInstance().remove(call.request());
                    }
                }
            }
            if (Logger.isDebug) {
                Logger logger = Logger.getInstance();
                logger.d("HttpRequest:" + call.request().url().toString());
                Buffer buffer = new Buffer();
                Objects.requireNonNull(call.request().body()).writeTo(buffer);
                String params = buffer.readUtf8();
                logger.d("params:" + params);
                if (apiModel != null) {
                    logger.d("HttpResponse:" + apiModel.toString());
                }
            }
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }

    private void transmitData(ApiModel<T> apiModel) {
        //如果页面需要apiModel
        if (apiModelHandle != null) {
            //将页码返回给调用者
            apiModelHandle.handle(apiModel, pageIndex);
        } else {
            netLiveData.postValue(apiModel.getData());
            if (handle != null) {
                handle.handle(apiModel.getData());
            }
        }
    }

}
