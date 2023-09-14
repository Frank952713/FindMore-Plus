package com.findmoreplus.admin.service;


import com.findmoreplus.admin.domain.bean.User;
import com.findmoreplus.admin.domain.bo.LoginBo;
import com.findmoreplus.admin.domain.bo.UpdatePassWordBo;
import java.util.Map;

public interface AuthService {
    /**
     * 企业登录
     *
     * @param loginBo 登录对象
     * @return
     */
    User login(LoginBo loginBo) throws IllegalAccessException;

    /**
     * 修改账号密码
     *
     * @param updatePassWordBo 修改密码对象
     */
    void updatePassAccountWord(UpdatePassWordBo updatePassWordBo);
}