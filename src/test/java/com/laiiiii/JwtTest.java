package com.laiiiii;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    /**
     * 生成JWT令牌: Jwts.builder()
     */
    @Test
    public void testGenerateJwt(){

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", 1);
        dataMap.put("username", "laiiiii");
        String jwt =Jwts.builder().signWith(SignatureAlgorithm.HS256,"laiiiii")     // 指定签名算法
                .addClaims(dataMap)     // 添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))  // 设置令牌过期时间
                .compact();     // 生成令牌
        System.out.println(jwt);
    }

    /**
     * 解析JWT令牌: Jwts.parser()
     */
    @Test
    public void testParseJwt(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJsYWlpaWlpIiwiZXhwIjoxNzY1ODk3MzM2fQ.A-49O_ABS04zegPOULtL-Fo-76XxiiLvVHKVXwzZamQ";
        Claims claims =Jwts.parser()
                .setSigningKey("laiiiii")       // 指定密钥
                .parseClaimsJws(token)          // 解析令牌
                .getBody();                     // 获取自定义信息
        System.out.println(claims);
    }

}
