package com.xiaohan.ssm.service;

import com.xiaohan.ssm.domain.Permission;
import com.xiaohan.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: 小韩同学
 * @date: 2020/10/14
 */
public interface IRoleService {

    public List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId) throws Exception;

    void deleteRoleById(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;

    List<Permission> findOtherPermissions(String roleId) throws Exception;
}
