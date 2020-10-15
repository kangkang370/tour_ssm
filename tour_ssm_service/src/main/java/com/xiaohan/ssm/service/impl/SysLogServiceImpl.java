package com.xiaohan.ssm.service.impl;

import com.xiaohan.ssm.dao.ISysLogDao;
import com.xiaohan.ssm.domain.SysLog;
import com.xiaohan.ssm.service.IsysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Author: 小韩同学
 * @Date: 2020/10/15
 */
@Service
@Transactional
public class SysLogServiceImpl implements IsysLogService {

    @Autowired
    private ISysLogDao sysLogDao;
    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }
}
