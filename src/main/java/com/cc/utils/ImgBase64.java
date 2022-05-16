/*
 * @FileDescription: 将图片转换为base64格式
 * @Author: xckhh
 * @Date: 2022/5/3
 * @LastEditors: 2022/5/3
 * @LastEditTime: 2022/5/3
 */
package com.cc.utils;

import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImgBase64 {
    // 图片转换Base64
    public static String ImageToBase64(String imgPath) throws IOException {
        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        in = new FileInputStream(imgPath);
        data = new byte[in.available()];
        in.read(data);
        in.close();
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
}
