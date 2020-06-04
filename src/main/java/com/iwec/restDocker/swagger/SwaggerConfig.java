package com.iwec.restDocker.swagger;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(regex("/api/v1.*")).build();
	}

	/*
	 * 
	 * @Bean public Docket productApi() { return new
	 * Docket(DocumentationType.SWAGGER_2).select()
	 * .apis(RequestHandlerSelectors.basePackage("guru.springframework.controllers")
	 * ).paths(regex("/api/v1.*")) .build(); }
	 * 
	 * 
	 * @SuppressWarnings("deprecation") private ApiInfo metadata() { return new
	 * ApiInfoBuilder().title("Java Code Geeks").
	 * description("API reference guide for developers").termsOfServiceUrl(
	 * "https://www.javacodegeeks.com/").contact("Batra, Yatin").version("1.0").
	 * build(); }
	 */
}
