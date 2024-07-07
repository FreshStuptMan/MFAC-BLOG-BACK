package com.mfac.service;

import com.mfac.pojo.entity.User;
import com.mfac.pojo.vo.UserDetailVO;

public interface UserService {

    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    User selectByAccount(String account);

    /**
     * 获取用户信息
     * @return
     */
    UserDetailVO detail();

    /**
     * 修改密码
     * @param user
     * @return
     */
    Integer changePassword(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    Integer update(User user);
}
