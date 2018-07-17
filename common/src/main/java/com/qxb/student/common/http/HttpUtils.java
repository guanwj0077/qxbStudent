package com.qxb.student.common.http;

import com.qxb.student.common.utils.Singleton;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HttpUtils {

    private static final Singleton<HttpUtils> SINGLETON = new Singleton<HttpUtils>() {
        @Override
        protected HttpUtils create() {
            return new HttpUtils();
        }
    };

    public static HttpUtils getInstance() {
        return SINGLETON.get();
    }

    // okhttp 初始化   retrofit 初始化并设置相关适配器
    // 提供获取retrofit对象

    private static HttpConfigure httpConfigure;

    public void setHttpConfigure(HttpConfigure httpConfigure) {
        this.httpConfigure = httpConfigure;
    }

    public static <T> T create(Class<T> clazz) {
        return httpConfigure.getRetrofit().create(clazz);
    }

    public <T> void request(final Observable<T> observable, final HttpResponse<T> httpResponse) {
        observable.subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
//                        dialog.dismiss();
                    }
                })
                .subscribe(new Consumer<T>() {
                    @Override
                    public void accept(T t) throws Exception {
                        httpResponse.success(t);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        httpResponse.failed(throwable);
                        System.out.println("throwable:" + throwable.getMessage());
                        request(observable, httpResponse);
                    }
                });
    }

}
