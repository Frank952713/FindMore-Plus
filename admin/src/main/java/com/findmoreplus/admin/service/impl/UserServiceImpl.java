package com.findmoreplus.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.findmoreplus.admin.domain.bean.User;
import com.findmoreplus.admin.mapper.UserMapper;
import com.findmoreplus.admin.service.UserService;

/**
 * @author WEIR
 * @description
 * @date 8/10/2021 - 21:03
 */
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

//    private final SqlSession openSession = SqlUtil.getOpeningSession();
//    private final this.baseMapper this.baseMapper = openSession.getMapper(this.baseMapper.class);

    @Override
    public Boolean checkUserCount(String count) {
        try {
            return this.baseMapper.checkCountExit(count);
        } catch (Exception e) {
            throw new RuntimeException("检验用户名失败！");
        }
    }

    @Override
    public User login(String phone, String password) {
        try {
            return this.baseMapper.selectInfoByPhone(phone, password);
        } catch (Exception e) {
            throw new RuntimeException("登录失败！");
        }
    }

    @Override
    public void register(User user) {
        user.setId(this.baseMapper.countAllUser());
        //设置用户默认名称
        user.setUsername(User.BASE_NAME + user.getId());
        try {
            this.baseMapper.addUser(user);
//            openSession.commit();
        } catch (Exception e) {
            throw new RuntimeException("注册失败!");
        }
    }

    @Override
    public User queryUserInfo(Integer id) {
        try {
            return this.baseMapper.selectInfoById(id);
        } catch (Exception e) {
            throw new RuntimeException("获取用户信息失败!");
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            this.baseMapper.addInfo(user);
//            openSession.commit();
        } catch (Exception e) {
            throw new RuntimeException("完善资料失败！");
        }
    }

    @Override
    public void addUserImg(Integer id, String pic) {
        try {
            this.baseMapper.addHeadPortrait(pic, id);
//            openSession.commit();
        } catch (Exception e) {
            throw new RuntimeException("添加头像失败！");
        }
    }

    @Override
    public User queryUserByName(String name) {
        return null;
    }

}
