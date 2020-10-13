package com.xiaohan.ssm.dao;

import com.xiaohan.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Select;

/**
 * @description:
 * @author: 小韩同学
 * @date: 2020/10/12
 */
public interface IUserDao {
    @Select("select * from users where username=#{username}")
    public UserInfo findByUsername(String username) throws Exception;
}
