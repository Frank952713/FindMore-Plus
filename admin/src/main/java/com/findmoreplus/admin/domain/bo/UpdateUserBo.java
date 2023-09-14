package com.findmoreplus.admin.domain.bo;
import com.baomidou.mybatisplus.annotation.TableName;
import com.findmoreplus.admin.domain.bean.Participater;
import com.findmoreplus.admin.domain.bean.UserPet;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author DAHUANG
 * @description 用户
 * @date 7/10/2021 18:45
 */

@Data
@ApiModel(description = "更新用户对象")
public class UpdateUserBo {

    //用户名
    String username;
    //用户id
    Integer id;
    //用户学号
    Integer count;
    //用户专业
    String major;
    //用户性别
    String gender;
    //用户密码
    String password;
    //用户手机电话
    String phone;
    //用户邮箱
    String email;
    //用户学院
    String collage;
    //用户昵称类
    UserPet pet;
    //参赛信息
    Participater pars;
    //头像
    String headPortrait;
    Integer level;

}

