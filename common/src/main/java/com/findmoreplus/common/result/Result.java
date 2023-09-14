package com.findmoreplus.common.result;

import com.findmoreplus.common.enums.ResultCodeEnum;
import com.findmoreplus.common.exception.BusinessException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 全局统一返回结果类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "全局统一返回结果")
public class Result<T> implements Serializable {

    /**
     * 返回码
     */
    @ApiModelProperty(value = "返回码")
    private Integer code;

    /**
     * 返回消息
     */
    @ApiModelProperty(value = "返回消息")
    private String message;

    /**
     * 链路码
     */
    private String trackCode;

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据")
    private T data;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public static <T> Result<T> ok(String message) {
        return build(null, message, ResultCodeEnum.SUCCESS);
    }

    public static <T> Result<T> ok(T data) {
        return build(data, "", ResultCodeEnum.SUCCESS);
    }

    public static <T> Result<T> ok() {
        return build(null, "", ResultCodeEnum.SUCCESS);
    }

    public static <T> Result<T> fail(String message) {
        return build(null, message, ResultCodeEnum.FAIL);
    }

    public static <T> Result<T> fail(T data) {
        return build(data, "", ResultCodeEnum.FAIL);
    }

    public static <T> Result<T> fail() {
        return build(null, "", ResultCodeEnum.FAIL);
    }

    /**
     * 重写Result的message字段
     *
     * @param msg 新的message
     */
    public Result<T> message(String msg) {
        this.setMessage(msg);
        return this;
    }

    /**
     * 重写Result的code字段
     *
     * @param code 新的code
     */
    public Result<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * 重写Result的data字段
     * @param data 新的data
     */
    public <T> Result<T> data(T data) {
        Result<T> result = (Result<T>)this;
        result.setData(data);
        return result;
    }

    public static <T> Result<T> build(T data, String message, ResultCodeEnum resultCodeEnum) {
        Result<T> result = new Result<>();
        if (null != data) {
            result.setData(data);
        }
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(message);
        return result;
    }

    /**
     * 判断是否成功
     */
    public boolean isOk() {
        return this.getCode().intValue() == ResultCodeEnum.SUCCESS.getCode().intValue();
    }

    /**
     * 判断是否成功
     * @author yanglixin
     */
    public void checkResult() {
        if (!this.isOk()) {
            throw new BusinessException("服务器繁忙请重试!");
        }
    }
    /**
     * 判断是否失败
     */
    public boolean isFail() {
        return (!isOk());
    }

    /**
     * 检验返回结果
     * @author yanglixin
     */
    public void checkErrMsg() {
        if (this.isFail()) {
            throw new BusinessException(this.getMessage());
        }
    }
}
