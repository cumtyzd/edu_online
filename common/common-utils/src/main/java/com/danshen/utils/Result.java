package com.danshen.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一结果处理类
 */
@Data
@ApiModel("统一结果处理类")
public class Result {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回信息")
    private String message;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    //私有构造方法
    private Result() {}

    /**
     * 成功
     * @return
     */
    public static Result ok() {
        Result result = new Result();
        result.setSuccess(true);
        result.setMessage("成功");
        result.setCode(ResultCode.SUCCESS);
        return result;
    }

    /**
     * 失败
     * @return
     */
    public static Result error() {
        Result result = new Result();
        result.setSuccess(false);
        result.setMessage("失败");
        result.setCode(ResultCode.FAILURE);
        return result;
    }

    public Result success(Boolean b) {
        this.setSuccess(b);
        return this;
    }

    public Result message(String string) {
        this.setMessage(string);
        return this;
    }

    public Result code(Integer integer) {
        this.setCode(integer);
        return this;
    }

    public Result data(String string,Object object) {
        this.getData().put(string,object);
        return this;
    }

    public Result data(Map<String,Object> map) {
        this.setData(map);
        return this;
    }
}
