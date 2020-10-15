package com.xiaohan.ssm.service.impl;

import com.xiaohan.ssm.dao.IRoleDao;
import com.xiaohan.ssm.domain.Permission;
import com.xiaohan.ssm.domain.Role;
import com.xiaohan.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: 小韩同学
 * @date: 2020/10/14
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(String roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public void deleteRoleById(String roleId) throws Exception {
        // 从user_role表中删除
        roleDao.deleteFromUser_RoleByRoleId(roleId);
        // 从role_permission表中删除
        roleDao.deleteFromRole_PermissionByRoleId(roleId);
        // 从role表中删除
        roleDao.deleteRoleById(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        for(String permissionId: permissionIds){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) throws Exception {
        return roleDao.findOtherPermissions(roleId);
    }
}
