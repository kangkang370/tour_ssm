package com.xiaohan.ssm.dao;

import com.xiaohan.ssm.domain.Member;
import com.xiaohan.ssm.domain.Orders;
import com.xiaohan.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @description:
 * @author: 小韩同学
 * @date: 2020/10/11
 */
public interface IOrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.xiaohan.ssm.dao.IProductDao.findById")),

    })
    public List<Orders> findAll() throws Exception;

    // 多表操作
    @Select("select * from orders where id = #{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.xiaohan.ssm.dao.IProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class, one = @One(select = "com.xiaohan.ssm.dao.IMemberDao.findById")),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class, many = @Many(select = "com.xiaohan.ssm.dao.ITravellerDao.findByOrdersId"))

    })
    Orders findById(String ordersId) throws Exception;

    @Delete("delete from orders where id = #{orderId}")
    void delete(String orderId);

    @Delete("delete from order_traveller where orderId = #{orderId}")
    void deleteOrderTraveller(String orderId);
}
