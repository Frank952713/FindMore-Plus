package com.findmoreplus.domain.bean;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author DAHUANG
 * @description 用户
 * @date 7/10/2021 18:45
 */
@Alias("user")
@Data
@AllArgsConstructor
@TableName(value = "t_user",autoResultMap = true)
public class User implements Serializable {
    private static final long serialVersionUID=8452144756218456L;
    public static final String BASE_NAME="findmore";
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

    /**
     * 注册所用的构造方法
     * @param count
     * @param password
     * @param phone
     */
    public User(Integer count, String password, String phone ){
        this.count = count;
        this.password = password;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", count=" + count +
                ", major='" + major + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", collage='" + collage + '\'' +
                ", pet=" + pet +
                ", pars=" + pars +
                ", headPortrait='" + headPortrait + '\'' +
                ", level=" + level +
                '}';
    }

    public User() {
    }

    public User(String username, Integer count, String major, String gender, String password, String phone, String email, String collage) {
        this.username = username;
        this.count = count;
        this.major = major;
        this.gender = gender;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.collage = collage;
    }

}

