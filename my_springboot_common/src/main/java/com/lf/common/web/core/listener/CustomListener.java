
package com.lf.common.web.core.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * @Title: CustomListener.java
 * @Description: 
 * @author Liangfeng
 * @date 2017/4/28 0028 上午 10:01
 * @version 1.0
 */
public class CustomListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed");
	}

}
