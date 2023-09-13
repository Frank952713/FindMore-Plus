package com.findmoreplus.common.config;

import io.swagger.annotations.Api;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@EnableOpenApi
@Configuration
public class SwaggerConfig {

    @Value("${spring.profiles.active:''}")
    private String active;
    @Value("${spring.port}")
    private String port;
    @Value("${spring.servlet.content-path}")
    private String contextPath;

    @Bean
    @SneakyThrows
    public Docket shopManager() {
        Docket docket = new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .globalResponses(HttpMethod.GET, globalResponse())
                .globalResponses(HttpMethod.POST, globalResponse())
                .select()
                //扫描带有@Api注解的类
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //
                .paths(PathSelectors.any())
                .build();

        String ipAddress = InetAddress.getLocalHost().getHostAddress();
        // 控制台输出Swagger3接口文档地址
        log.info("Swagger3接口文档地址: http://{}:{}{}/swagger-ui.html", ipAddress, port, contextPath);
        // 控制台输出Knife4j增强接口文档地址
        log.info("Knife4j增强接口文档地址: http://{}:{}{}/doc.html", ipAddress, port, contextPath);
        return docket;
    }

    private ApiInfo apiInfo() {
        String title = "FindMore-Plus";
        String description = "API接口文档";
        String version = "1.0.0";
        String license = "";
        String termOfServiceUrl = "";
//new Contact("")
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .license(license)
                .termsOfServiceUrl(termOfServiceUrl)
                .build();
    }

    private List<Response> globalResponse() {
        ArrayList<Response> responseList = new ArrayList<>();
        responseList.add(new ResponseBuilder().code("401").description("未认证").build());
        responseList.add(new ResponseBuilder().code("403").description("请求被禁止").build());
        responseList.add(new ResponseBuilder().code("404").description("找不到资源").build());
        return responseList;
    }
}
