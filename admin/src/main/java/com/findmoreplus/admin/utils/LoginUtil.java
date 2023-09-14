package com.findmoreplus.admin.utils;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.findmoreplus.admin.domain.bean.User;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Slf4j
public class LoginUtil {

    /**
     * 刷新用户的登录会话域
     * @param id 需要刷新登录会话域的账号id
     * @param user 当前刷新用户的账号信息
     * @param dataScope 当前刷新用户的数据权限
     */
    public static void updateLoginSession(Long id, User user, Map<String, Integer> dataScope) throws IllegalAccessException {
        log.info("多线程刷新登录会话: {}",user);
        SaSession session = StpUtil.getSessionByLoginId(id);
        if (session==null){
            //当前用户登录会话域不存在
            return ;
        }
        //刷新登录账号名和登录号码
        for (Field field : user.getClass().getDeclaredFields()) {
            //允许访问私有字段
            field.setAccessible(true);
            // 将用户的数据放入上下文session中
            StpUtil.getSession().set(field.getName(), field.get(user));
        }
    }
}
