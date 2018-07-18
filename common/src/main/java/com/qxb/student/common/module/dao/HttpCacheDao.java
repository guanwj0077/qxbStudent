package com.qxb.student.common.module.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.qxb.student.common.module.bean.tab.HttpCache;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * @author winky
 * @date 2018/7/18
 */
@Dao
public interface HttpCacheDao {

    /**
     * 记录缓存模型
     *
     * @param httpCache {@link com.qxb.student.common.module.bean.tab.HttpCache}
     */
    @Insert(onConflict = REPLACE)
    void insert(HttpCache httpCache);

    /**
     * 查询缓存
     *
     * @param entity entity
     * @return httpCache
     */
    @Query("SELECT * FROM HttpCache WHERE  entity = :entity")
    HttpCache queryByEntity(String entity);

    /**
     * 删除
     *
     * @param httpCache httpCache
     */
    @Delete
    void delete(HttpCache httpCache);
}
