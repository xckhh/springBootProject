/*
 * @FileDescription: 通过两个Date属性参数算出年龄
 * @Author: xckhh
 * @Date: 2022/5/3
 * @LastEditors: 2022/5/3
 * @LastEditTime: 2022/5/3
 */
package com.cc.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/*
    获取年龄工具类
    date1为当前日期
    date2为出生年月
*/
public class ObtainAge {
    public static int getAge(Date date1, Date date2) {
        // 先将Date转为String
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");  // 设置日期格式
        String str1 = simpleDateFormat.format(date1);  // 格式转换
        String str2 = simpleDateFormat.format(date2);
        // 将字符串分割成字符数据
        String[] a = str1.split("-"); // 当前
        String[] b = str2.split("-"); // 出生
        // 将年月日字符数组转成int类型 计算年龄
        LocalDate d1 = LocalDate.of(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(a[2]));
        LocalDate d2 = LocalDate.of(Integer.parseInt(b[0]), Integer.parseInt(b[1]), Integer.parseInt(b[2]));
        int age = d2.until(d1).getYears();
        return age;
    }
}
