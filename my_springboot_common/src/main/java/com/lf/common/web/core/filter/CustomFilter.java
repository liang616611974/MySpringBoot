
package com.lf.common.web.core.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Title: CustomFilter.java
 * @Description:
 * @author Liangfeng
 * @date 2017/4/28 0028 上午 10:01
 * @version 1.0
 */
public class CustomFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init filter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("do filter");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("destroy filter");
	}

}
