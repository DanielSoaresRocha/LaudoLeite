package com.backend.laudoleite.config;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import static springfox.documentation.builders.PathSelectors.regex;
import java.util.ArrayList;



@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.backend.laudoleite.resources"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        return new ApiInfoBuilder().title("API REST LaudoLeite")
                .description("API REST para Controle de Laudos\n" +
                        "\n**Developers:**\n"
                        +"* Daniel Soares - https://github.com/DanielSoaresRocha\n" +
                        "* Weslley Leocadio - https://github.com/WesleyLeocadio\n" +
                        "* Pedro Fonseca - https://github.com/PedroFnsc"
                )
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("1.0.0")
                .build();

    }
}
