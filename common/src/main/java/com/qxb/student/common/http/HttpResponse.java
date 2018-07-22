package com.qxb.student.common.http;

import android.arch.lifecycle.MutableLiveData;

import com.qxb.student.common.module.bean.ApiModel;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * 执行网络请求
 * @author winky
 */
public class HttpResponse<T> implements Action {

    private Observable<ApiModel<T>> observable;
    private MutableLiveData<T> mutableLiveData;

    public HttpResponse(Observable<ApiModel<T>> observable, MutableLiveData<T> mutableLiveData) {
        this.observable = observable;
        this.mutableLiveData = mutableLiveData;
    }

    @Override
    public void run() {
        HttpUtils.getInstance().addDisposable(observable.subscribe(new PostApiConsumer<>(mutableLiveData)));
    }
}
