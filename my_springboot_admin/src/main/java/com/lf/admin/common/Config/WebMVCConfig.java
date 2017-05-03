package com.lf.admin.common.Config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.lf.admin.common.web.mvc.interceptor.DemoInterceptor;
import com.lf.admin.common.web.mvc.interceptor.DemoInterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

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
     *  使用 fastJsonHttpMessageConvert
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        
        // 1.需要先定义一个 convert 转换消息的对象;
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        // 2.添加fastJson 的配置信息，比如：是否要格式化返回的json数据;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullStringAsEmpty);

        // 3.在convert中添加配置信息.
        fastConverter.setFastJsonConfig(fastJsonConfig);

        // 4.添加到转换器集合
        HttpMessageConverter<?> converter = fastConverter;
        converters.add(converter);
    }

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
