/*
 * Powered By [liangfeng]
 * Web Site: http://www.liangfeng.com
 * 2017-03-07
 */

package com.liangfeng.myspringboot.core.dao.impl;

import com.liangfeng.myspringboot.common.framework.base.impl.BaseMyBatisDaoImpl;
import com.liangfeng.myspringboot.core.dao.AdminUserDao;
import com.liangfeng.myspringboot.core.model.pojo.AdminUser;
import com.liangfeng.myspringboot.core.model.query.AdminUserQuery;
import org.springframework.stereotype.Repository;

@Repository
public class AdminUserDaoImpl extends BaseMyBatisDaoImpl<AdminUser,AdminUserQuery,Long> implements AdminUserDao{
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "AdminUser";
	}
	

}
