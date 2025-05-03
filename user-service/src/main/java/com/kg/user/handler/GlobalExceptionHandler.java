package com.kg.user.handler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import com.kg.common.BusinessException;
import com.kg.common.R;

/**
 * @author ggstudy11
 * @date Created in 4/16/2025 4:22 PM
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