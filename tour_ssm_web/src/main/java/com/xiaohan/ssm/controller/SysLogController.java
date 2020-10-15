package com.xiaohan.ssm.controller;

import com.xiaohan.ssm.domain.SysLog;
import com.xiaohan.ssm.service.IsysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogs = sysLogService.findAll();
        mv.addObject("sysLogs",sysLogs);
        mv.setViewName("sysLogList");
        return mv;

    }
}
