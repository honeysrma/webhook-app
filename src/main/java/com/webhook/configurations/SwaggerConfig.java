package com.webhook.configurations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.usertype.DynamicParameterizedType.ParameterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.webhook.constants.AppConstants;
import com.webhook.constants.UtilConstant;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Autowired	
	private Environment environment;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.webhook.controllers")) // Set your controller package
				.paths(PathSelectors.any()).build().apiInfo(apiInfo())
				.globalOperationParameters(globalOperationParameters());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Webhook API Documentation").description("Webhook")
				.version("1.0").build();
	}

	private List<Parameter> globalOperationParameters() {
		List<Parameter> parameters = new ArrayList<>();
		parameters.add(new ParameterBuilder().name(UtilConstant.AUTHORIZATION)
				.description("Token is required for each service").modelRef(new ModelRef("string")) // Define the header
				.defaultValue(environment.getProperty(AppConstants.DEFAULT_AUTHRIZATION_TOKEN, UtilConstant.EMPTY))																			// type
				.parameterType("header").required(false) // Set to true if the header is required
				.build());
		return parameters;
	}
}
