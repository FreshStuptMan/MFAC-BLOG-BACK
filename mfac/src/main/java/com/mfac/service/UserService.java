package com.mfac.service;

import com.mfac.pojo.entity.User;

public interface UserService {

    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    User selectByAccount(String account);
}
