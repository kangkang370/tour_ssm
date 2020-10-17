package com.xiaohan.ssm.controller;

import com.xiaohan.ssm.domain.Permission;
import com.xiaohan.ssm.domain.Role;
import com.xiaohan.ssm.service.IRoleService;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

/**
 * @description:
 * @author: 小韩同学
 * @date: 2020/10/14
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("roleList");
        return mv;
    }

    @RequestMapping("/save.do")
    public String  save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById")
    public ModelAndView findBuId(@RequestParam(name = "id", required =  true) String roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(roleId);
        mv.addObject("role", role);
        mv.setViewName("roleShow");
        return mv;
    }

    @RequestMapping("/deleteRole.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteRole(@RequestParam(name = "id", required = true) String roleId) throws Exception{
        roleService.deleteRoleById(roleId);
        return "redirect:findAll.do";
    }

    // 根据roleId查询role，并查询可以添加的权限
    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true)String roleId) throws Exception{
        ModelAndView mv = new ModelAndView();
        // 根据roleId查询角色
        Role role = roleService.findById(roleId);
        // 根据角色id查询可以添加的权限
        List<Permission> otherPermissions = roleService.findOtherPermissions(roleId);
        mv.addObject("role", role);
        mv.addObject("permissionList", otherPermissions);
        mv.setViewName("rolePermissionAdd");
        return mv;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = true) String roleId, @RequestParam(name = "ids", required = true) String[] permissionIds) throws Exception {
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll.do";
    }


}
