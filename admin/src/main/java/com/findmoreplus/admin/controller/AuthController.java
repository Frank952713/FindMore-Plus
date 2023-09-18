package com.findmoreplus.admin.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.findmoreplus.admin.domain.bean.User;
import com.findmoreplus.admin.domain.bo.LoginBo;
import com.findmoreplus.admin.domain.bo.UpdatePassWordBo;
import com.findmoreplus.admin.service.AuthService;
import com.findmoreplus.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api("用户账号授权登录")
@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @ApiModelProperty(value = "用户账号登录")
    @PostMapping("/login")
    public Result<User> login(@Validated LoginBo loginBo) throws IllegalAccessException {
        User userInfo = authService.login(loginBo);
        return Result.ok(userInfo);
    }

    @ApiOperation(value = "用户账号退出登录")
    @PostMapping("/logout")
    public Result<String> logout() {
        StpUtil.getSession().logout();
        return Result.ok("logout success");
    }

    @ApiOperation(value = "修改账号密码")
    @PostMapping("/updatePassWord")
    public Result<String> updatePassWord(@Validated UpdatePassWordBo bo) {
        authService.updatePassAccountWord(bo);
        return Result.ok("修改密码成功!");
    }
}
