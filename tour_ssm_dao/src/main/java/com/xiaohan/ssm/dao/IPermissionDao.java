package com.xiaohan.ssm.dao;

import com.xiaohan.ssm.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description:
 * @author: 小韩同学
 * @date: 2020/10/13
 */
public interface IPermissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    public List<Permission> findPermissionByRoleId(String id) throws Exception;
    @Select("select * from permission")
    public List<Permission> findAll() throws Exception;

    @Insert("insert into permission(permissionName, url) values(#{permissionName}, #{url})")
    public void save(Permission permission);

    @Select("select * from permission where id = #{id}")
    public Permission findById(String id);

    @Delete("delete from permission where id = #{id}")
    public void deleteById(String id);

    @Delete("delete from role_permission where permissionId = #{id}")
    void deleteRole_PermissionById(String id);
}
