package com.findmoreplus.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.findmoreplus.domain.bean.User;
import com.findmoreplus.domain.bo.LoginBo;
import com.findmoreplus.domain.bo.UpdatePassWordBo;
import com.findmoreplus.domain.bo.AddOrUpdateUserBo;
import com.findmoreplus.mapper.UserMapper;
import com.findmoreplus.service.AuthService;
import com.findmoreplus.service.UserService;
import com.findmoreplus.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(LoginBo loginBo) throws IllegalAccessException {
        String loginName = loginBo.getLoginName();
        String passwd = loginBo.getPasswd();
        //获取当前账号信息
        User user = userMapper.queryUserByName(loginName);
        if (ObjectUtil.isNull(user) || !passwd.equals(user.getPassword())) {
            throw new BusinessException("账号或密码不正确");
        }
        StpUtil.login(user.getId());
        //遍历获取到的所有user属性
        for (Field field : user.getClass().getDeclaredFields()) {
            //允许访问私有字段
            field.setAccessible(true);
            // 将用户的数据放入上下文session中
            StpUtil.getSession().set(field.getName(), field.get(user));
        }
        return user;
    }

    @Override
    public void updatePassAccountWord(UpdatePassWordBo bo) {
        if (!bo.getNewPassWord().equals(bo.getNewPassWordAgain())) {
            throw new BusinessException("两次输入的密码不一致");
        }
        User user = userMapper.selectInfoById((Integer) StpUtil.getSession().get("id"));
        if (!user.getPassword().equals(bo.getNewPassWord())) {
            throw new BusinessException("密码错误");
        }
        //密码加密……
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setPassword(bo.getNewPassWord());
        userService.updateById(newUser);
    }

    @Override
    public void updateUser(AddOrUpdateUserBo bo) {
        User user = BeanUtil.copyProperties(bo, User.class);
        user.setId(StpUtil.getSession().getInt("id"));
        userService.updateById(user);
    }
}
