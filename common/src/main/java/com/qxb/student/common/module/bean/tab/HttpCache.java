package com.qxb.student.common.module.bean.tab;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * 缓存记录
 *
 * @author winky
 * @date 2018/7/18
 */
@Entity(tableName = "HttpCache")
public class HttpCache {

    @PrimaryKey(autoGenerate = true)
    private int _id;
    /**
     * 缓存模型
     */
    private String entity;
    /**
     * 缓存截至时间
     */
    private long time;

    public HttpCache(String entity, long time) {
        this.entity = entity;
        this.time = time;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
