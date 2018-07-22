package com.qxb.student.common.http;

import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.support.annotation.NonNull;

import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.School;
import com.qxb.student.common.module.bean.tab.HttpCache;
import com.qxb.student.common.module.dao.HttpCacheDao;
import com.qxb.student.common.module.dao.RoomUtils;
import com.qxb.student.common.utils.Singleton;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
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
    //    // 提供获取retrofit对象

    private static HttpConfigure httpConfigure;

    public void setHttpConfigure(HttpConfigure httpConfigure) {
        HttpUtils.httpConfigure = httpConfigure;
    }

    /**
     * 数据库实例
     */
    protected static final RoomUtils roomUtils = RoomUtils.getInstance();
    /**
     * 缓存操作
     */
    private static final HttpCacheDao httpCacheDao = roomUtils.httpCacheDao();

    /**
     * 缓存rxjava链接,在页面关闭时切断
     */
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    /**
     * 当页面关闭切断仓库所有数据链接
     */
    public void onCleared() {
        compositeDisposable.clear();
    }

    /**
     * @param disposable rxjava链接
     */
    public void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    public <T> T create(Class<T> clazz) {
        return httpConfigure.getRetrofit().create(clazz);
    }

    /**
     * 数据处理
     *
     * @param <T>             数据模型
     * @param mutableLiveData liveData
     * @param obj             异步执行，查询本地库判断是否需要请求网络数据
     * @param observable      网络请求
     */
    public <T> void request(MutableLiveData<T> mutableLiveData, SubscribeObj<T> obj, Observable<ApiModel<T>> observable) {
        Disposable disposable = Observable.create(obj)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
//                .doOnNext(new PostConsumer<>(mutableLiveData))
                .doOnComplete(new HttpResponse<>(observable, mutableLiveData)).subscribe();
        addDisposable(disposable);
    }

    public <T> Observable<ApiModel<T>> convert(Observable<ApiModel<T>> observable) {
        return this.convert(observable, new Consumer<ApiModel<T>>() {
            @Override
            public void accept(ApiModel<T> apiModel) {

            }
        });
    }

    /**
     * 请求转换
     *
     * @param observable 网络请求
     * @param async      异步执行，处理本地数据
     * @param <T>        数据模型
     * @return observable
     */
    public <T> Observable<ApiModel<T>> convert(Observable<ApiModel<T>> observable, @NonNull Consumer<ApiModel<T>> async) {
        return observable
                .subscribeOn(Schedulers.io())
                .doOnNext(async)
                .observeOn(Schedulers.io());
    }

    /**
     * 检查数据缓存到期
     *
     * @param clazz 表实体
     * @return 是否需要请求新的数据
     */
    protected boolean checkCacheTime(@NonNull Class<?> clazz) {
        HttpCache httpCache = httpCacheDao.queryByEntity(clazz.getName());
        if (httpCache == null) {
            return true;
        }
        if (System.currentTimeMillis() >= httpCache.getTime()) {
            httpCacheDao.delete(httpCache);
            SupportSQLiteStatement statement = roomUtils.compileStatement("delete from " + clazz.getSimpleName());
            statement.execute();
            return true;
        } else {
            return false;
        }
    }

    /**
     * 添加缓存记录
     *
     * @param clazz 表实体
     */
    public void addCache(@NonNull Class<?> clazz, long cacheTime) {
        httpCacheDao.insert(new HttpCache(clazz.getName(), System.currentTimeMillis() + cacheTime));
    }
}
