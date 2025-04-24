package com.kg.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ggstudy11
 * @date Created in 2025/4/24 14:23
 * @description 统一返回响应
 */
@Data
@AllArgsConstructor
public class R<T> {
    private Integer code;
    private String message;
    private T data;


    public static <T> R<T> success() {
        return new R<T>(200, "接口成功响应", null);
    }

    public static <T> R<T> success(T data) {
        return new R<T>(200, "接口成功响应", data);
    }

    public static <T> R<T> fail(int code, String message) {
        return new R<T>(code, message, null);
    }
}
