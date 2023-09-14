package com.findmoreplus.admin.domain.bo;

import cn.hutool.core.util.StrUtil;
import com.findmoreplus.common.exception.BusinessException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * Description:
 */
@Data
@ApiModel(description = "修改密码入参")
public class UpdatePassWordBo {

    //@NotBlank(message = "旧密码不能为空")
    @ApiModelProperty(value = "旧密码")
    private String oldPassWord;

    @Length(max = 16, min = 8, message = "密码规则为:大小写字母与数字的组合,长度8-16位")
    @NotBlank(message = "新密码不能为空")
    @ApiModelProperty(value = "新密码")
    private String newPassWord;

    //@Length(max = 16, min = 8, message = "密码规则为:大小写字母与数字的组合,长度8-16位")
    @Length(max = 16, min = 8, message = "请输入新密码(8~16位字母+数字的组合)")
    @NotBlank(message = "请却认新密码")
    @ApiModelProperty(value = "重复输入新密码")
    private String newPassWordAgain;
    @ApiModelProperty(value = "是否为小程序端 0:否 1:是")
    private Integer isSmallApp;
    /**
     * 校验旧密码
     * @author yangliixn
     */
    public void checkOldPwd(String accountPassWd) {
        if (StrUtil.isEmpty(oldPassWord)) {
            throw new BusinessException("旧密码不能为空");
        }
        //验证原密码是否正确
//        PasswdVo passwd = TenantUtil.getInitPasswd(oldPassWord);
//        if (!StrUtil.equals(accountPassWd,passwd.getEncryPasswd())) {
//            throw new BusinessException("旧密码错误");
//        }
    }
}
