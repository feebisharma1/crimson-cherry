package com.allstate.crimsoncherry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("public-api")
                .apiInfo(apiInfo())
                .select().paths(regex("/api/.*")).build();
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Allstate Crimson Cherry Movie Review Database")
                .description("The Crimson Cherry Movie Review Database is the premier database for movie reviewers " +
                        "that have no idea what they are talking about.  Anyone can write anything they like, so " +
                        "you know you are getting the best information possible.  Join in and let us know what you " +
                        "think of your favorite movie!"
                )
                .termsOfServiceUrl("http://allstate.com")
                .version("1.0")
                .build();
    }
}
