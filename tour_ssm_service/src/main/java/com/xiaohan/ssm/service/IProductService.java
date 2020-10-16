package com.xiaohan.ssm.service;

import com.xiaohan.ssm.domain.Product;

import java.util.List;

/**
 * @description:
 * @author: 小韩同学
 * @date: 2020/10/10
 */
public interface IProductService {

    public List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;

    void delete(String productId) throws Exception;
}
