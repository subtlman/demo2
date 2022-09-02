//package com.example.demo.atools.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import static com.example.demo.atools.AtoolsConfig.*;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @Author: subtlman_ljx
// * @Date: 2020/09/09/9:22
// * @Description: Swagger配置信息
// */
//@Configuration
//@EnableSwagger2
////@Profile({"dev","test"})
//public class SwaggerConfig {
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .pathMapping("/")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(packageName))
//                .paths(PathSelectors.any())
//                .build().apiInfo(new ApiInfoBuilder()
//                        .title(titleName)
//                        .description(descriptionName)
//                        .version("1.0")
//                        .build());
//    }
//}
