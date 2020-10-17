package com.xiaohan.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.xiaohan.ssm.domain.SysLog;
import com.xiaohan.ssm.service.IsysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description:
 * @Author: 小韩同学
 * @Date: 2020/10/15
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private IsysLogService sysLogService;

    /*@RequestMapping("/findAll.do")--未分页
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogs = sysLogService.findAll();
        mv.addObject("sysLogs",sysLogs);
        mv.setViewName("sysLogList");
        return mv;

    }*/

    @RequestMapping("/findAll.do")// 分页显示
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "10") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogs = sysLogService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(sysLogs);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("sysLogList");
        return mv;

    }
}
