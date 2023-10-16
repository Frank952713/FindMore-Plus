package com.findmoreplus.domain.bo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.findmoreplus.domain.bean.Participater;
import com.findmoreplus.domain.bean.UserPet;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.io.Serializable;

/**
 * 用户
 */

@Data
@ApiModel(description = "账号信息")
public class AddOrUpdateUserBo {

    /*
     *更新验证
     */
    public interface Update extends Default {
    }
    @NotNull(message = "用户名不能为空")
    @Length(max = 10,message = "用户名最多输入10个字")
    @ApiModelProperty(value = "用户名")
    //用户名
    String username;
    @NotNull(message = "账号id不能为空", groups = Update.class)
    @ApiModelProperty(value = "账号id")
    //用户id
    Integer id;
    @NotNull(message = "学号不能为空", groups = Update.class)
    @ApiModelProperty(value = "学号")
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

