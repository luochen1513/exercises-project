package com.book.dto.requestDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author: bai
 * @date: 2022/5/23 20:44
 * @description:
 */
@ApiModel(value = "登录",description = "用户登录dto")
public class LoginRequestDto implements Serializable {

    private static final long serialVersionUID = 2259675252596867416L;

    @ApiModelProperty(value = "用户名", required = true, example = "lisi")
    private String username;

    @ApiModelProperty(value = "密码", required = true, example = "1513")
    private String password;

    @ApiModelProperty(value = "验证码是否需要校验", required = false, example = "false")
    private Boolean needVerify;

    @ApiModelProperty(value = "验证码", required = false)
    private String verifyCodeActual;

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

    public Boolean getNeedVerify() {
        return needVerify;
    }

    public void setNeedVerify(Boolean needVerify) {
        this.needVerify = needVerify;
    }

    public String getVerifyCodeActual() {
        return verifyCodeActual;
    }

    public void setVerifyCodeActual(String verifyCodeActual) {
        this.verifyCodeActual = verifyCodeActual;
    }

    @Override
    public String toString() {
        return "LoginRequestDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", needVerify=" + needVerify +
                ", verifyCodeActual='" + verifyCodeActual + '\'' +
                '}';
    }
}
