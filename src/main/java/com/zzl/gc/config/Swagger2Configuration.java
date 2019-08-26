package com.zzl.gc.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author luotao
 * @Package com.zzl.gc.config
 * @date 2019/8/26 10:02
 * @describe swagger2配置文件
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    public Docket createRestfulApi(){
        /** 
         * @author luotao
         * @date 2019/8/26 11:29
         * @describe swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
         */
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zzl.gc.controller")) //暴露接口地址的包路径
                //.paths(Predicates.not(PathSelectors.regex("/error.*")))
                //.paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        /**
         * @author luotao
         * @date 2019/8/26 11:30
         * @describe 构建 api文档的详细信息函数,显示在主页。
         */
        return new ApiInfoBuilder()
                //页面标题
                .title("优等生源文档")
                //创建人
                .contact(new Contact("lt", "", "307958201@qq.com"))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }
}
