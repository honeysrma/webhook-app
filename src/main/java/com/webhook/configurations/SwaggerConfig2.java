package com.webhook.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig2 {
	
   // @Bean
//    public Docket docket() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .enable(true)
//                .apiInfo(new ApiInfoBuilder()
//                        .title("Swagger Super")
//                        .description("Swagger Description details")
//                        .version("1.0").build())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.webhook.controllers"))
//                .paths(PathSelectors.any()).build();
//    }
    
//    @Bean
//    public Docket docket() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .enable(true)
//                .apiInfo(new ApiInfoBuilder()
//                        .title("Swagger Super")
//                        .description("Swagger Description details")
//                        .version("1.0").build())
//                .select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                .paths(PathSelectors.any()).build();
//    }
    
    
    @Bean
    public Docket api() {
        return (new Docket(DocumentationType.SWAGGER_2))
        		.apiInfo(this.apiInfo())
        		.select()
        		.apis(RequestHandlerSelectors
        				.withMethodAnnotation(ApiOperation.class))
        		.paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return (new ApiInfoBuilder()).title("Swagger API").version("1.0").description("Swagger is Awesome").build();
    }
    
}