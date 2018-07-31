package com.qxb.student.common.module;

import com.qxb.student.common.http.HttpUtils;
import com.qxb.student.common.module.dao.RoomUtils;

/**
 * 用于切断订阅
 *
 * @author winky
 * @date 2018/7/18
 */
public abstract class BaseRepository {

    protected static final HttpUtils httpUtils = HttpUtils.getInstance();
    /**
     * 数据库实例
     */
    protected static final RoomUtils roomUtils = RoomUtils.getInstance();

    public void onCleared() {
    }
}
