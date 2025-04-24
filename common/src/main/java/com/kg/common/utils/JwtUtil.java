package com.kg.common.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;


import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

/**
 * @author ggstudy11
 * @date Created in 2025/4/24 15:48
 * @description jwt工具类
 */
@Slf4j
@Data
public class JwtUtil {

    /**
     * 签名算法类型
     */
    public enum AlgorithmType {
        HS256,
        RS256
    }

    private static final String secret = "V1XzOqZqg97hNBxqgJHRkIjXe3mFv2VG";

    /* 过期时间一个月 */
    private static final Long expiration = (long)30 * 24 * 3600;

    private static final AlgorithmType algorithm = AlgorithmType.HS256;

    /**
     * 生成令牌
     */
    public static String generateToken(Map<String, Object> claims, String subject) {
        final Date now = new Date();
        final Date expireDate = new Date(now.getTime() + expiration * 1000);

        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expireDate);
        builder.signWith(getHs256SecretKey(), SignatureAlgorithm.HS256);
        return builder.compact();
    }

    /**
     * 解析令牌
     */
    public static Claims parseToken(String token) {
        try {
            JwtParserBuilder parserBuilder = Jwts.parserBuilder();
            parserBuilder.setSigningKey(getHs256SecretKey());
            return parserBuilder.build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new JwtException("令牌解析错误");
        }
    }

    /**
     * 刷新令牌
     */
    public static String refreshToken(String token) {
        Claims claims = parseToken(token);
        claims.setIssuedAt(new Date());
        claims.setExpiration(new Date(System.currentTimeMillis() + expiration * 1000));
        return generateToken(claims, claims.getSubject());
    }

    /**
     * 验证令牌是否有效
     */
    public static boolean validateToken(String token) {
        try {
            parseToken(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    private static SecretKey getHs256SecretKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }
}
