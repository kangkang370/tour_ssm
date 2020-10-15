package com.xiaohan.ssm.service;

import com.xiaohan.ssm.domain.SysLog;

import java.util.List;

/**
 * @Description:
 * @Author: 小韩同学
 * @Date: 2020/10/15
 */
public interface IsysLogService {

    public void save(SysLog sysLog) throws Exception;

    public List<SysLog> findAll() throws Exception;
}
