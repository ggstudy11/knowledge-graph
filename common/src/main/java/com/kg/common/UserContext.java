package com.kg.common;

/**
 * @author ggstudy11
 * @date Created in 2025/4/26 12:48
 * @description 保存用户信息上下文
 */
public class UserContext {
    private static final ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * @Description  存入用户id
     * @param userId
     * @return
     * @Author ggstudy11
     * @Date
     */
    public static void setUser(Long userId) {
        threadLocal.set(userId);
    }

    /**
     * @Description 取用户id
     * @param
     * @return
     * @Author ggstudy11
     * @Date
     */
    public static Long getUser() {
        return threadLocal.get();
    }

    /**
     * @Description 清空，解决内存问题
     * @param
     * @return
     * @Author ggstudy11
     * @Date
     */
    public static void removeUser() {
        threadLocal.remove();
    }
}
