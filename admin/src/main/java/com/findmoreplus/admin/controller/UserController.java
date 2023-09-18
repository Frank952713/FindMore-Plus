package com.findmoreplus.admin.controller;

import com.findmoreplus.admin.domain.bean.User;
import com.findmoreplus.admin.domain.bo.AddOrUpdateUserBo;
import com.findmoreplus.admin.service.AuthService;
import com.findmoreplus.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
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
    public Result<User> updateUser(@Validated AddOrUpdateUserBo bo) throws IllegalAccessException {
        authService.updateUser(bo);
        return Result.ok("修改用户信息成功");
    }

}
