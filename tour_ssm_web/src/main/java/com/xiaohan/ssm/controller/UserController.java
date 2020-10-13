package com.xiaohan.ssm.controller;

import com.xiaohan.ssm.domain.UserInfo;
import com.xiaohan.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    // 查询所有用户
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfos = userService.findAll();
        mv.addObject("userList", userInfos);
        mv.setViewName("user-list");
        return mv;
    }

    // 用户添加
    @RequestMapping("/save.do")
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
}