package com.sucl.swagger.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author sucl
 * @since 2019/11/4
 */
@ApiModel(description = "用户")
@Data(staticConstructor = "of")
@Accessors(chain = true)
public class User implements Serializable {

    private Long userId;

    private String userName;

    private String userCaption;

    private Integer age;
}
