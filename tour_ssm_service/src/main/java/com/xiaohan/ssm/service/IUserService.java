package com.xiaohan.ssm.service;

import com.xiaohan.ssm.domain.Role;
import com.xiaohan.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @description:
 * @author: 小韩同学
 * @date: 2020/10/12
 */
public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll(Integer page, Integer size) throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String userId) throws Exception;

    void addRoleToUser(String userId, String[] roleIds) throws Exception;
}
