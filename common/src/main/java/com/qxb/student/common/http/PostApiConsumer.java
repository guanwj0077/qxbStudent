package com.qxb.student.common.http;

import android.arch.lifecycle.MutableLiveData;

import com.qxb.student.common.module.bean.ApiModel;

import io.reactivex.functions.Consumer;

public class PostApiConsumer<T> implements Consumer<ApiModel<T>> {

    private MutableLiveData<T> mutableLiveData;

    public PostApiConsumer(MutableLiveData<T> mutableLiveData) {
        this.mutableLiveData = mutableLiveData;
    }

    @Override
    public void accept(ApiModel<T> apiModel) throws Exception {
        if (apiModel.getCode() == 1) {
            mutableLiveData.postValue(apiModel.getData());
        }
    }
}
