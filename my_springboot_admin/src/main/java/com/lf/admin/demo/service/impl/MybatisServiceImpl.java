package com.lf.admin.demo.service.impl;

import com.lf.admin.common.constant.DatabaseConstant;
import com.lf.admin.demo.dao.MybatisDao;
import com.lf.admin.demo.model.pojo.User;
import com.lf.admin.demo.service.MybatisService;
import com.lf.common.Exception.DaoException;
import com.lf.common.Exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Liangfeng
 * @version 1.0
 * @Title: MybatisServiceImpl.java
 * @Description:
 * @date 2017/4/30 0030 16:31
 */
@Service
public class MybatisServiceImpl implements MybatisService {

    @Autowired
    MybatisDao mybatisDao;

    @Transactional(transactionManager = DatabaseConstant.PRIMARY_TX_MANAGER)
    @Override
    public void insertForPrimary(User user) {
        mybatisDao.insertForPrimary(user);
        throw new ServiceException("insertForPrimary 发生异常");
    }

    @Transactional(transactionManager = DatabaseConstant.SECONDARY_TX_MANAGER)
    @Override
    public void insertForSecondary(User user) {
        mybatisDao.insertForSecondary(user);
        throw new ServiceException("insertForSecondary 发生异常");
    }
}
