package com.lf.admin.common.Config;

import com.lf.admin.common.web.mvc.interceptor.DemoInterceptor;
import com.lf.admin.common.web.mvc.interceptor.DemoInterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <p>Title: WebMVCConfig<／p>
 * <p>Description: <／p>
 *
 * @author Liangfeng
 * @version 1.0
 * @date 2017-04-27 上午 11:23
 */
@Configuration
public class WebMVCConfig extends WebMvcConfigurerAdapter {


    /**
     * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 多个拦截器组成一个拦截器链

        // addPathPatterns 用于添加拦截规则

        // excludePathPatterns 用户排除拦截

        registry.addInterceptor(new DemoInterceptor()).addPathPatterns("/**");

        registry.addInterceptor(new DemoInterceptor2()).addPathPatterns("/**");

        super.addInterceptors(registry);

    }

    /**
     * 注册Cors跨域防御
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 限制了路径和域名的访问
        registry.addMapping("/api/**").allowedOrigins("http://localhost:8080");
        super.addCorsMappings(registry);
    }
}
