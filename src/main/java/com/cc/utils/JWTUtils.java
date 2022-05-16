/*
 * @FileDescription: 生成token，时效30分钟
 * @Author: xckhh
 * @Date: 2022/5/3
 * @LastEditors: 2022/5/3
 * @LastEditTime: 2022/5/3
 */
package com.cc.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {
    private static final String TOKEN = "cc@@#xckhh#*20210405*";
    public static String getToken(Map<String, String> map) {
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        //设置过期时间，默认30分钟
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE, 30);
        builder.withExpiresAt(instance.getTime());

        return builder.sign(Algorithm.HMAC256(TOKEN)).toString();
    }

    /**
     * 验证token
     *
     * @param token
     */
    public static void verify(String token) {
        JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
    }

    public static DecodedJWT getToken(String token) {
        return JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
    }
}
