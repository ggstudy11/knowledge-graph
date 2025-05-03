package com.kg.graph.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kg.common.BusinessException;
import com.kg.common.R;

import lombok.extern.slf4j.Slf4j;

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
