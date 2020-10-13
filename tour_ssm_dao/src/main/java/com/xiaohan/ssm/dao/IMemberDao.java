package com.xiaohan.ssm.dao;

import com.xiaohan.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @description:
 * @author: 小韩同学
 * @date: 2020/10/11
 */
public interface IMemberDao {
    @Select("select * from member where id = #{id}")
    public Member findById(String id) throws Exception;
}
