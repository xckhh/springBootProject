package com.cc.utils;

public class StringUtil {
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotEmoty(String str) {
        if (str != null && "".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNumber(String str) {
        int i = 0;
        for (i = str.length(); --i >= 0; ) {
            int chr = str.charAt(i);
            if (chr < 48 || chr > 57) {
                return false;
            }
        }
        return true;
    }
}
