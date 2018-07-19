package com.qxb.student.common.module;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.support.annotation.NonNull;

import com.qxb.student.common.module.bean.tab.HttpCache;
import com.qxb.student.common.module.dao.HttpCacheDao;
import com.qxb.student.common.module.dao.RoomUtils;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author winky
 * @date 2018/7/18
 */
public abstract class BaseRepository {

    /**
     * 数据库实例
     */
    protected volatile RoomUtils roomUtils = RoomUtils.getInstance();
    /**
     * 缓存rxjava链接,在页面关闭时切断
     */
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    /**
     * 当页面关闭切断仓库所有数据链接
     */
    public void onCleared() {
        compositeDisposable.clear();
        compositeDisposable = null;
    }

    private HttpCacheDao httpCacheDao = roomUtils.httpCacheDao();

    /**
     * @param disposable rxjava链接
     */
    public void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    /**
     * 检查数据缓存到期
     *
     * @param clazz 表实体
     * @return 是否需要请求新的数据
     */
    public boolean checkCacheTime(@NonNull Class<?> clazz) {
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
