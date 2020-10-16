package com.xiaohan.ssm.dao;

import com.xiaohan.ssm.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description:
 * @author: 小韩同学
 * @date: 2020/10/10
 */
public interface IProductDao {

    // 根据id查询产品
    @Select("select * from product where id = #{id}")
    public Product findById(String id) throws Exception;

    // 查询所有产品信息
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

    @Delete("delete from product where id = #{productId}")
    void delete(String productId);
}
