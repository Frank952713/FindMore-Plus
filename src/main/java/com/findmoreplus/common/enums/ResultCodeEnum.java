package com.findmoreplus.common.enums;

import lombok.Getter;

/**
 * <p>
 * 统一返回结果状态信息类
 * </p>
 * @date 2022/7/8
 */
@Getter
public enum ResultCodeEnum {
    /**
     * 操作成功
     */
    SUCCESS(0),
    /**
     * 操作失败
     */
    FAIL(1)
    ;

    private final Integer code;

    ResultCodeEnum(Integer code) {
        this.code = code;
    }
}
