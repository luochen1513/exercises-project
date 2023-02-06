package com.echarts.dto.responseDto;

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

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String userName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "LoginResponseDto{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
