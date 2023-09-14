package com.findmoreplus.admin.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.findmoreplus.admin.domain.bean.User;
import com.findmoreplus.admin.domain.bo.LoginBo;
import com.findmoreplus.admin.domain.bo.UpdatePassWordBo;
import com.findmoreplus.admin.domain.bo.UpdateUserBo;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthService authService;

    @ApiModelProperty(value = "用户账号信息更新")
    @PostMapping("/updateUser")
    public Result<User> updateUser(@Validated UpdateUserBo bo) throws IllegalAccessException {
        authService.updateUser(bo);
        return Result.ok("修改用户信息成功");
    }

}
