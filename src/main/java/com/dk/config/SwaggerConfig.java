package com.dk.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by dinesh_kumar on 12/12/15.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter implements ServletContextAware {
    private ServletContext servletContext;

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("test-api")
                .apiInfo(apiInfo())
                .select()
                .paths(testPaths())
                .build();
    }

    private Predicate<String> testPaths() {
        return regex("/service.*");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Test API")
                .description("Test API for desc")
                .termsOfServiceUrl("http://springfox.io")
                .contact("xyz@abc.com")
                .license("OPen licence")
                .licenseUrl("www.xyz.com")
                .version("1.0")
                .build();
    }

}

