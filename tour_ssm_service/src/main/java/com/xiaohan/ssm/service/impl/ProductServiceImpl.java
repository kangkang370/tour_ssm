package com.xiaohan.ssm.service.impl;

import com.xiaohan.ssm.dao.IProductDao;
import com.xiaohan.ssm.domain.Product;
import com.xiaohan.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: 小韩同学
 * @date: 2020/10/10
 */
@Service
@Transactional // 事物的注解一定不能忘了，添加的时候会用到
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    @Override
    public void delete(String productId) throws Exception{
        productDao.delete(productId);
    }
}
