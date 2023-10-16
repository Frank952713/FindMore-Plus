package com.findmoreplus.domain.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 登录业务对象
 */
@Data
@ApiModel(description = "登录对象")
public class LoginBo {

    @NotBlank(message = "登录账号不能为空")
    @ApiModelProperty(value = "登录账号")
    private String loginName;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String passwd;

    @ApiModelProperty(hidden = true)
    private String ip;
    @ApiModelProperty(value = "微信unionId")
    private String unionId;
}

