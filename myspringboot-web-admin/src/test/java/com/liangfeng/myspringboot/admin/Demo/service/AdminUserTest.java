package com.liangfeng.myspringboot.admin.Demo.service;

import com.liangfeng.myspringboot.admin.demo.service.AdminUserService;
import com.liangfeng.myspringboot.common.framework.page.Page;
import com.liangfeng.myspringboot.core.model.pojo.AdminUser;
import com.liangfeng.myspringboot.core.model.query.AdminUserQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminUserTest{
	
	@Autowired
	private AdminUserService service;
	
	
    @Test
	public void testSave(){
		AdminUser adminUser = new AdminUser();
		adminUser.setId(1L);
	  	adminUser.setUsername(new String("1"));
	  	adminUser.setPassword(new String("1"));
	  	adminUser.setStatus(new Integer("1"));
	  	adminUser.setIdcard(new String("1"));
	  	adminUser.setMobile(new String("1"));
	  	adminUser.setEmail(new String("1"));
	  	adminUser.setCreateUser(1L);
	  	adminUser.setCreateTime(new Date());
	  	adminUser.setModifyUser(1L);
	  	adminUser.setModifyTime(new Date());
		service.save(adminUser);
	}
    
    @Test
	public void testModify(){
		AdminUser adminUser = new AdminUser();
		adminUser.setId(1L);
	  	adminUser.setUsername(new String("2"));
	  	adminUser.setPassword(new String("2"));
	  	adminUser.setStatus(new Integer("2"));
	  	adminUser.setIdcard(new String("2"));
	  	adminUser.setMobile(new String("2"));
	  	adminUser.setEmail(new String("2"));
	  	adminUser.setCreateUser(2L);
	  	adminUser.setCreateTime(new Date());
	  	adminUser.setModifyUser(2L);
	  	adminUser.setModifyTime(new Date());
		service.modify(adminUser);
	}
	
	@Test
	public void testRemove(){
		AdminUser adminUser = new AdminUser();
		adminUser.setId(1L);
		service.remove(adminUser.getId());
	}
	
	@Test
	public void testQuery(){
		List<AdminUser> adminUsers = service.query();
		for(AdminUser adminUser : adminUsers){
			System.out.println(adminUser);
		}
	}
	
	@Test
	public void testQueryByQuery(){
		AdminUserQuery adminUserQuery = new AdminUserQuery();
		adminUserQuery.setId(1L);
		List<AdminUser> adminUsers = service.query(adminUserQuery);
		for(AdminUser adminUser : adminUsers){
			System.out.println(adminUser);
		}
	}
	
	@Test
	public void testQueryPage(){
		AdminUserQuery adminUserQuery = new AdminUserQuery();
		adminUserQuery.setPageNumber(1);
		adminUserQuery.setPageSize(10);
		adminUserQuery.setPageWidth(10);
		Page<AdminUser> page = service.queryPage(adminUserQuery);
		List<AdminUser> adminUsers = page.getResult();
		for(AdminUser adminUser : adminUsers){
			System.out.println(adminUser);
		}
	}
	
	
}
