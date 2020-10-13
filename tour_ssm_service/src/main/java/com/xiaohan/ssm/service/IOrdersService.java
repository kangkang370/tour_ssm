package com.xiaohan.ssm.service;

import com.xiaohan.ssm.domain.Orders;

import java.util.List;

/**
 * @description:
 * @author: 小韩同学
 * @date: 2020/10/11
 */
public interface IOrdersService {

    List<Orders> findAll(int page, int size) throws Exception;

    public Orders findById(String ordersId) throws Exception;
}
