package com.dong.system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义全局异常处理类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllException extends RuntimeException{

    private Integer code;

    private String message;


}
