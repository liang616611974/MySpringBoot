/*
 * Powered By [liangfeng]
 * Web Site: http://www.liangfeng.com
 * 2017-03-07
 */

package com.lf.core.dao.impl;

import com.lf.common.framework.base.impl.BaseMyBatisDaoImpl;
import com.lf.core.dao.AdminUserDao;
import com.lf.core.model.pojo.AdminUser;
import com.lf.core.model.query.AdminUserQuery;
import org.springframework.stereotype.Repository;

@Repository
public class AdminUserDaoImpl extends BaseMyBatisDaoImpl<AdminUser,AdminUserQuery,Long> implements AdminUserDao{
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "AdminUser";
	}
	

}
