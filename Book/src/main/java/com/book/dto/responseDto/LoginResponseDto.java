package com.book.dto.responseDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author: bai
 * @date: 2022/5/23 20:57
 * @description:
 */
@ApiModel(value = "登录",description = "用户登录dto")
public class LoginResponseDto implements Serializable {

    private static final long serialVersionUID = -5205628512118749168L;

    @ApiModelProperty(value = "主键userId")
    private Integer userId;

    @ApiModelProperty(value = "姓名")
    private String username;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
