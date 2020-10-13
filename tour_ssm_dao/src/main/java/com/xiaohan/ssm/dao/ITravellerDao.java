package com.xiaohan.ssm.dao;

import com.xiaohan.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description:
 * @author: 小韩同学
 * @date: 2020/10/11
 */
public interface ITravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{ordersId}) ")
    public List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
