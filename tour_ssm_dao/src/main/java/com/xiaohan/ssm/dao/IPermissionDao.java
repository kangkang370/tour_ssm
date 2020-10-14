package com.xiaohan.ssm.dao;

import com.xiaohan.ssm.domain.Permission;
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

}
