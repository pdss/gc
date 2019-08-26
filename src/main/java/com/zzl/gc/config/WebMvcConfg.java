package com.zzl.gc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author luotao
 * @Package com.zzl.gc.config
 * @date 2019/8/26 16:47
 * @describe 静态资源拦截器
 */
@Configuration
public class WebMvcConfg implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //和页面有关的静态目录都放在项目的static目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //上传的图片在D盘下的OTA目录下，访问路径如：http://localhost:8081/test/qzslogo.png
        //其中test表示访问的前缀。"file:D:/test/"是文件真实的存储路径
        registry.addResourceHandler("/test/**").addResourceLocations("file:D:/test/");
    }
}
