package com.book.dto.requestDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author: bai
 * @date: 2022/5/23 20:44
 * @description:
 */
@ApiModel(value = "注册",description = "用户注册dto")
public class RegistRequestDto implements Serializable {

    private static final long serialVersionUID = 6124069851392868773L;

    @ApiModelProperty(value = "用户名", required = true, example = "lisi")
    private String username;

    @ApiModelProperty(value = "密码", required = true, example = "1513")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegistRequestDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
