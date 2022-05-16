/*
 * @FileDescription: 验证规则
 * @Author: xckhh
 * @Date: 2022/5/3
 * @LastEditors: 2022/5/3
 * @LastEditTime: 2022/5/3
 */
package com.cc.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rules {
    public static boolean isMobile(String phone) {
        String regex = "^1\\d{10}$";
        // 移动： 139 138 137 136 135 134 147 150 151 152 157 158 159 182 183 184
        // 187 188
        // 联通： 130 131 132 155 156 185 186 145
        // 电信： 133 153 180 181 189
        boolean flag = false;
        try {
            phone = phone.replaceAll(" ", "");
            if (StringUtil.isEmpty(phone)) {
                return flag;
            }
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(phone);
            flag = matcher.matches();
        } catch (Exception e) {
            return Boolean.FALSE;
        }
        return flag;
    }


    public static boolean isEmail(String email) {
        boolean tag = true;
        final String pattern1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        final Pattern pattern = Pattern.compile(pattern1);
        final Matcher mat = pattern.matcher(email);
        if (!mat.find()) {
            tag = false;
        }
        return tag;
    }
}
