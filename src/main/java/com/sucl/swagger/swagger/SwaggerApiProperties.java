package com.sucl.swagger.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * swagger 属性
 */
@Data
@ConfigurationProperties("swagger.api")
public class SwaggerApiProperties {

    private String name;
    private String title;
    private String description;
    private String version;
    private String contactUser;
    private String contactUrl;
    private String contactEmail;
    private boolean enable;

}
