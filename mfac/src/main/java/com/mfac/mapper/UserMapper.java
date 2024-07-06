package com.mfac.mapper;

import com.mfac.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    @Select("select * from user where account = #{account}")
    User selectByAccount(String account);
}
