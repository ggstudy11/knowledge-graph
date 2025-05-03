package com.kg.file.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kg.common.BusinessException;
import com.kg.common.R;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ggstudy11
 * @date 2024/10/12 10:46
 * @description 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /* 业务异常处理 */
    @ExceptionHandler(BusinessException.class)
    public R<Object> handleBusinessException(BusinessException e) {
        log.error("业务异常：{}", e.getMessage());
        return R.fail(500, e.getMessage());
    }
}
