package com.xiaohan.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.xiaohan.ssm.domain.Orders;
import com.xiaohan.ssm.service.IOrdersService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Name;
import java.util.List;

/**
 * @description:
 * @author: 小韩同学
 * @date: 2020/10/11
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    // 查询全部订单---未分页
    /*@RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll();
        mv.addObject("ordersList", ordersList);
        mv.setViewName("orders-list");
        return mv;

    }*/

    @RequestMapping("/findAll.do")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAll(@RequestParam(name = "page",required = true, defaultValue = "1")Integer page,@RequestParam(name = "size",required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page, size);
        // pageInfo实际上就是一个分页Bean
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;

    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true ) String ordersId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(ordersId);
        mv.addObject("orders", orders);
        mv.setViewName("orders-show");
        return mv;
    }

    @RequestMapping("/deleteOrder.do")
    public String  deleteOrder(@RequestParam(name = "id", required = true) String orderId) throws Exception {
        ordersService.delete(orderId);
        return "redirect:findAll.do";
    }

}
