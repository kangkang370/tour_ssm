package com.xiaohan.ssm.controller;

import com.xiaohan.ssm.domain.Permission;
import com.xiaohan.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description:
 * @Author: 小韩同学
 * @Date: 2020/10/14
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permissionList");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception {
        permissionService.save(permission);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView fidById(String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Permission permission = permissionService.findById(id);
        mv.addObject("permission",permission);
        mv.setViewName("permissionShow");
        return mv;
    }

    @RequestMapping("/deletePermission.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deletePermission(String id) throws Exception{
        permissionService.deleteById(id);
        return "redirect:findAll.do";
    }
}
