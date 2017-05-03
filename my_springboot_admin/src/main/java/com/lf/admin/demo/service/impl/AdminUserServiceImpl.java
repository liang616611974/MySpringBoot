/*
 * Powered By [liangfeng]
 * Web Site: http://www.liangfeng.com
 * 2017-03-07
 */

package com.lf.admin.demo.service.impl;


import com.lf.admin.demo.service.AdminUserService;
import com.lf.common.framework.base.BaseDao;
import com.lf.common.framework.base.impl.BaseServiceImpl;
import com.lf.core.dao.AdminUserDao;
import com.lf.core.model.pojo.AdminUser;
import com.lf.core.model.query.AdminUserQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
public class AdminUserServiceImpl extends BaseServiceImpl<AdminUser,AdminUserQuery,Long> implements AdminUserService{

	private static final Logger logger = LoggerFactory.getLogger(AdminUserService.class);
	
	@Autowired
	private AdminUserDao adminUserDao;
	
	@Override
	public BaseDao<AdminUser,AdminUserQuery,Long> getBaseDao() {
		return this.adminUserDao;
	}




	
}
