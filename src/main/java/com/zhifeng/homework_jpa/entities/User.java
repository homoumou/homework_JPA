package com.zhifeng.homework_jpa.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("User Entity")
@Setter
@Getter
public class User {

    @ApiModelProperty("user name")
    private String username;

    @ApiModelProperty("user password")
    private String password;
}
