package com.findmoreplus.common.exception;

import cn.hutool.core.util.StrUtil;

/**
 * <p>
 * 业务异常
 * 通常会将异常信息返回给前端，如：
 * 1、参数校验异常
 * 2、状态异常
 * </p>
 * @author 谭建亮
 * date 2022/7/20
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(CharSequence template, Object... params) {
        super(StrUtil.format(template, params));
    }
}
