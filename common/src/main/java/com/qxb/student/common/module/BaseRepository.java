package com.qxb.student.common.module;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.support.annotation.NonNull;

import com.qxb.student.common.module.bean.tab.HttpCache;
import com.qxb.student.common.module.dao.HttpCacheDao;
import com.qxb.student.common.module.dao.RoomUtils;
import com.qxb.student.common.utils.ExecutorUtils;

/**
 * @author winky
 * @date 2018/7/18
 */
public class BaseRepository {

    final RoomUtils roomUtils = RoomUtils.getInstance();
    final ExecutorUtils executorUtils = ExecutorUtils.getInstance();
    private HttpCacheDao httpCacheDao = roomUtils.httpCacheDao();

    /**
     * 检查数据缓存到期
     *
     * @param clazz 表实体
     * @return 是否需要请求新的数据
     */
    boolean checkCacheTime(@NonNull Class<?> clazz) {
        HttpCache httpCache = httpCacheDao.queryByEntity(clazz.getName());
        if (httpCache == null || System.currentTimeMillis() >= httpCache.getTime()) {
            SupportSQLiteStatement statement = roomUtils.compileStatement("delete from " + clazz.getSimpleName());
            statement.execute();
            return true;
        } else {
            return false;
        }
    }

    /**
     * 添加到缓存
     *
     * @param clazz 表实体
     */
    void addCache(@NonNull Class<?> clazz, long cacheTime) {
        httpCacheDao.insert(new HttpCache(clazz.getName(), System.currentTimeMillis()+cacheTime));
    }
}
