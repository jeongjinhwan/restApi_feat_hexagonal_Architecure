package com.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {

    @Value("${springdoc.bearer.name}")
    public String bearerName;
    @Value("${springdoc.bearer.scheme}")
    public String bearerScheme;
    @Value("${springdoc.bearer.bearerFormat}")
    public String bearerFormat;

    @Value("${springdoc.info.title}")
    public String title;
    @Value("${springdoc.info.version}")
    public String version;
    @Value("${springdoc.info.description}")
    public String description;

    @Value("${springdoc.license.name}")
    public String licenseName;
    @Value("${springdoc.license.url}")
    public String licenseUrl;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(getInfo())
                .addSecurityItem(addBearerRequest())
                .components(comBearerAuth());
    }

    /**
     * JWT BEARER 추가.
     * 
     * @return
     */
    private Components comBearerAuth() {
        return new Components().addSecuritySchemes(
                bearerName,
                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme(bearerScheme).bearerFormat(bearerFormat));
    }

    /**
     * SecurityRequirement 추가.
     * 
     * @return
     */
    private SecurityRequirement addBearerRequest() {
        return new SecurityRequirement().addList(bearerName);
    }

    /**
     * API 정보.
     * 
     * @return
     */
    private Info getInfo() {
        return new Info().title(title).version(version).description(description).license(getLicense());
    }

    /**
     * 라이센스 정보.
     * 
     * @return
     */
    private License getLicense() {
        return new License().name(licenseName).url(licenseUrl);
    }

}
