package com.mfac.service.impl;

import com.mfac.mapper.UserMapper;
import com.mfac.pojo.entity.User;
import com.mfac.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    @Override
    public User selectByAccount(String account) {
        return userMapper.selectByAccount(account);
    }
}
