package com.qxb.student.common.module.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.qxb.student.common.module.bean.User;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * 操作用户信息
 *
 * @author winky
 * @date 2018/7/21
 */
@Dao
public interface UserDao {
    /**
     * 插入用户资料
     *
     * @param user 用户
     */
    @Insert(onConflict = REPLACE)
    void insert(User user);

    /**
     * 本地用户信息
     *
     * @param accountId 账户id
     * @return
     */
    @Query("SELECT * FROM User WHERE id=:accountId")
    User queryById(String accountId);

    /**
     * 本地用户信息
     *
     * @param phone 账户收集号
     * @return
     */
    @Query("SELECT * FROM User WHERE telphone=:phone")
    User queryByPhone(String phone);

    /**
     * 本地用户信息
     *
     * @return User
     */
    @Query("select * from User")
    User query();
}
