package com.boot3.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SpringDocUtils;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;


@Configuration
public class SwaggerConfig {


    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("v1.0")
                .pathsToMatch("/**")
                .addOpenApiCustomiser(customGlobalOpenApiHeader())
                .build();
    }


    @Bean
    public OpenAPI springShopOpenAPI() {
        Server local = new Server();
        local.setDescription("local");
        local.setUrl("http://localhost:9999/");

//    	Server awsDev = new Server();
//    	awsDev.setDescription("AWS Developer server");
//    	awsDev.setUrl("https://localhost:7777");

//		List<Server> servers = List.of(local, awsDev);

        return new OpenAPI()
                .addServersItem(local)
                //.servers(servers)
                .info(new Info().title("OpenAPI")
                        .description("Springboot OpenAPI")
                        .version("v1.0"));
    }

    @Bean
    public OpenApiCustomiser customOpenApiTime() {
        return openApi -> SpringDocUtils.getConfig().replaceWithClass(Instant.class, Long.class);
    }

    @Bean
    public OpenApiCustomiser customGlobalOpenApiHeader() {

        Parameter testId = new Parameter()
                .name("testId")
                .in("header")
                .description("테스트 ID")
                .required(true)
                .schema(new StringSchema()._default("swagger_id"));

        return openApi -> openApi.getPaths().values().forEach(
                operation -> operation
                        .addParametersItem(testId)
        );
    }

}
