package org.huyg.springboot_demo.config;

import java.util.Date;

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

/** * SwaggerConfig */
@Configuration
@EnableSwagger2
@SuppressWarnings("deprecation")
public class Swagger2Config {

	 @Bean
	    public Docket createRestApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(apiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("org.huyg.springboot_demo.controller"))
	                .paths(PathSelectors.any())
	                .build();
	    }

	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("SpringBoot Swagger2 RESTful APIs")
	                .description(new Date().toString())
	                .contact(new Contact("胡永鋼", "https://crackhu.github.io/", "296717367qq.com"))
	                .version("1.0")
	                .build();
	    }
}