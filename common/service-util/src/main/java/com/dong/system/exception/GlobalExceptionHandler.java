package com.dong.system.exception;

import com.baomidou.mybatisplus.extension.api.R;
import com.dong.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.image.RescaleOp;

/**
 * 全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    // 全局异常处理  ExceptionHandler异常处理器
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        // 打印异常信息
        e.printStackTrace();
        return Result.fail().message("执行了全局异常处理");
    }
    // 添加特定异常处理
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e){
        // 打印异常信息
        e.printStackTrace();
        return Result.fail().message("执行了特定异常处理");
    }
    // 自定义异常处理
    @ExceptionHandler(AllException.class)
    @ResponseBody
    public Result error(AllException e){
        // 打印异常信息
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMessage());
    }
}
