package com.xiaohan.ssm.dao;

import com.xiaohan.ssm.domain.Permission;
import com.xiaohan.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

/**
 * @description:
 * @author: 小韩同学
 * @date: 2020/10/13
 */
public interface IRoleDao {

    // 根据用户id查询出所有对应的角色
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id", javaType = java.util.List.class, many = @Many(select = "com.xiaohan.ssm.dao.IPermissionDao.findPermissionByRoleId"))

    })
    public List<Role> findRoleByUserId (String userId) throws Exception;

    // 查询所有角色
    @Select("select * from role")
    public List<Role> findAll() throws Exception;

    @Insert("insert into role(roleName, roleDesc) values(#{roleName}, #{roleDesc})")
    public void save(Role role) throws Exception;

    @Select("select * from role where id = #{roleId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.xiaohan.ssm.dao.IPermissionDao.findPermissionByRoleId")),

    })
    public Role findById(String roleId) throws Exception;

    @Delete("delete from users_role where roleId = #{roleId}")
    void deleteFromUser_RoleByRoleId(String roleId) throws Exception;

    @Delete("delete from role_permission where roleId = #{roleId}")
    void deleteFromRole_PermissionByRoleId(String roleId) throws Exception;

    @Delete("delete from role where id = #{roleId}")
    void deleteRoleById(String roleId) throws Exception;

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId}, #{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId) throws Exception;

    @Select("select * from permission where id not in(select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findRoleByIdAndAllPermission(String roleId) throws Exception;
}
