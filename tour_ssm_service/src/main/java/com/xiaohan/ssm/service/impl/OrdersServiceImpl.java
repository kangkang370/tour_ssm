package com.xiaohan.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.xiaohan.ssm.dao.IOrdersDao;
import com.xiaohan.ssm.domain.Orders;
import com.xiaohan.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.awt.datatransfer.DataTransferer;

import java.util.List;

/**
 * @description:
 * @author: 小韩同学
 * @date: 2020/10/11
 */
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page, int size) throws Exception {
        // 参数pageNum是页码值，参数pageSize表示的是每页显示的条数
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }
}
