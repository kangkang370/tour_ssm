package com.xiaohan.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.xiaohan.ssm.domain.Role;
import com.xiaohan.ssm.domain.UserInfo;
import com.xiaohan.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @description:
 * @author: 小韩同学
 * @date: 2020/10/13
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService userService;

    /*// 查询所有用户--未分页
    @RequestMapping("/findAll.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfos = userService.findAll();
        mv.addObject("userList", userInfos);
        mv.setViewName("user-list");
        return mv;
    }*/

    // 查询所有用户--分页显示
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true, defaultValue = "1")Integer page,@RequestParam(name = "size",required = true, defaultValue = "3") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfos = userService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(userInfos);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("userPageList");
        return mv;
    }

    // 用户添加
    @RequestMapping("/save.do")
    /*@PreAuthorize("authentication.principal.username == 'tom'")*/
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    // 查询指定id的用户
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user", userInfo);
        mv.setViewName("userShow1");
        return mv;
    }

    // 查询用户以及用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userId) throws Exception {
        ModelAndView mv = new ModelAndView();
        // 根据用户id查询用户
        UserInfo userInfo = userService.findById(userId);
        // 根据用户id查询可以添加的角色
        List<Role> roles = userService.findOtherRoles(userId);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",roles);
        mv.setViewName("userRoleAdd");
        return mv;
    }

    // 给用户添加角色
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId, @RequestParam(name = "ids",required = true) String[] roleIds) throws Exception{
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }
}