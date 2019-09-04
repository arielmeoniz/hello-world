package com.pablo.apirest01.config;

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

@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.pablo.apirest01.controller"))
				.paths(PathSelectors.regex("/.*"))
				.build().apiInfo(apiEndpointsInfo());
	}

	private ApiInfo apiEndpointsInfo() {
		return new ApiInfoBuilder().title("Spring boot api pablo")
				.description("Api de Pablo")
				.contact(new Contact("Pablo de Platanos","www.pablo.com","pabloy@live.com"))
				.license("Para todos")
				.licenseUrl("http://todos")
				.version("10")
				.build();
	}
	
}
