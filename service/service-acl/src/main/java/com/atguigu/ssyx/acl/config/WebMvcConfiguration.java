package com.atguigu.ssyx.acl.config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
@Configuration
@Slf4j
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //设置静态资源映射
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        log.info("111");
//        registry.addMapping("/**") // 允许跨域访问的路径
//                .allowedOrigins("*")// 允许跨域访问的源
//                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE") // 允许请求方法
//                .maxAge(86400) // 预检间隔时间
//                .allowedHeaders("*") // 允许头部设置
//                .allowCredentials(true); // 是否发送cookie
//    }
}
