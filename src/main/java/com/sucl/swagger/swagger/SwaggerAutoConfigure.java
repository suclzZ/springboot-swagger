package com.sucl.swagger.swagger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "swagger.api.enable",havingValue = "true",matchIfMissing = true)
@ConditionalOnClass(Controller.class)
@ConditionalOnMissingBean(Docket.class)
@EnableConfigurationProperties(SwaggerApiProperties.class)
public class SwaggerAutoConfigure {
    private final SwaggerApiProperties properties;

    public SwaggerAutoConfigure(SwaggerApiProperties properties){
        this.properties = properties;
    }

    @Bean
    public Docket autoEnableSwagger() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> globalParams = new ArrayList<>();
//        tokenPar.name("Authorization").description("认证")
//                .modelRef(new ModelRef("string")).parameterType("header").required(false).build();
//
//        globalParams.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
//                .enable(properties.isEnable())
                .groupName(properties.getName())
                .apiInfo(specialApiInfo())
                .select()
                .build()
                .globalOperationParameters(globalParams);
    }

    /**
     * 设置api的参数
     *
     * @return api参数信息
     */
    private ApiInfo specialApiInfo() {
        Contact contact = new Contact(properties.getContactUser(),
                properties.getContactUrl(),
                properties.getContactEmail());
        return new ApiInfoBuilder()
                .title(properties.getTitle())
                .description(properties.getDescription())
                .contact(contact)
                .version(properties.getVersion())
                .build();
    }

}
