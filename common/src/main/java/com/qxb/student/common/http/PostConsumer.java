package com.qxb.student.common.http;

import android.arch.lifecycle.MutableLiveData;

import io.reactivex.functions.Consumer;

public class PostConsumer<T> implements Consumer<T> {

    private MutableLiveData<T> mutableLiveData;

    public PostConsumer(MutableLiveData<T> mutableLiveData) {
        this.mutableLiveData = mutableLiveData;
    }

    @Override
    public void accept(T t) {
        mutableLiveData.postValue(t);
    }
}
