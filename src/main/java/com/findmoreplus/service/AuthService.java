package com.findmoreplus.service;


import com.findmoreplus.domain.bean.User;
import com.findmoreplus.domain.bo.LoginBo;
import com.findmoreplus.domain.bo.UpdatePassWordBo;
import com.findmoreplus.domain.bo.AddOrUpdateUserBo;

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

    void updateUser(AddOrUpdateUserBo bo);
}
