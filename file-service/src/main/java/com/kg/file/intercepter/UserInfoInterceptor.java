package com.kg.file.intercepter;

import com.kg.common.UserContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author ggstudy11
 * @date Created in 2025/4/26 12:51
 * @description 用户信息拦截器
 */
public class UserInfoInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        String userInfo = request.getHeader("user-info");
        if (userInfo != null) {
            UserContext.setUser(Integer.valueOf(userInfo));
        }
        return true;
    }

    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, Exception ex) throws Exception {
        UserContext.removeUser();
    }
}