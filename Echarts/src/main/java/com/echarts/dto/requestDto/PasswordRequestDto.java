package com.echarts.dto.requestDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author: bai
 * @date: 2022/5/23 20:44
 * @description:
 */
@ApiModel(value = "用户",description = "用户dto")

public class PasswordRequestDto implements Serializable {

    private static final long serialVersionUID = -5777813532773470194L;

    @ApiModelProperty(value = "旧密码", required = true, example = "1513")
    private String oldPassword;

    @ApiModelProperty(value = "新密码", required = true, example = "1513")
    private String newPassword;

    @ApiModelProperty(value = "确认密码", required = true, example = "1513")
    private String rePassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
