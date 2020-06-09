package com.iwec.restDocker.swagger;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket docket(ApiInfo apiInfo) {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(regex("/.*")).build();
	}

	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Student API").description("API for fetching student related information")
				.version("1.0.0").build();
	}

	@Bean
	public UiConfiguration uiConfiguration() {
		return UiConfigurationBuilder.builder().deepLinking(true).validatorUrl(null).build();
	}

}
