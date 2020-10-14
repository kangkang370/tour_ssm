package com.xiaohan.ssm.service;

import com.xiaohan.ssm.domain.Permission;

import java.util.List;

/**
 * @Description:
 * @Author: 小韩同学
 * @Date: 2020/10/14
 */
public interface IPermissionService {

    public List<Permission> findAll() throws Exception;

    public void save(Permission permission) throws Exception;

    Permission findById(String id) throws Exception;

    void deleteById(String id) throws Exception;
}
