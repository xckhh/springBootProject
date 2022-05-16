/*
 * @FileDescription: 存储文件
 * @Author: xckhh
 * @Date: 2022/5/3
 * @LastEditors: 2022/5/3
 * @LastEditTime: 2022/5/3
 */
package com.cc.utils;

import com.cc.dao.PhotoDao;
import com.cc.pojo.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class Image {
    private String id;
    // 图片数组
    public static String uploadImages(MultipartFile file) {
        // 文件保存的路径
        String uploadDir = "D:\\桌面文件夹\\学习\\springBootProject\\src\\main\\resources\\static\\images";
        String saveFileName = null;
        if (file == null) {
            return null;
        }
//        for (MultipartFile file : files) {
            saveFileName = FileNameUtil.getUUIDFileName() + FileNameUtil.getFileType(file.getOriginalFilename());
            File uploadPath = new File(uploadDir);
            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            }
            File destFile = new File(uploadPath, saveFileName);
            try {
                file.transferTo(destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
//        }
        return saveFileName;
    }


    // 照片上传
    public static String uploadPhotos(Photo photo, MultipartFile[] files, PhotoDao photoDao) {
        // 文件保存的路径
        String uploadDir = "D:\\桌面文件夹\\学习\\springBootProject\\src\\main\\resources\\static\\images";
        String saveFileName = null;
        if (files == null) {
            return null;
        }
        for (MultipartFile file : files) {
            saveFileName = FileNameUtil.getUUIDFileName() + FileNameUtil.getFileType(file.getOriginalFilename());
            photo.setPhoto_path(saveFileName);
            photoDao.insertPhoto(photo);
            File uploadPath = new File(uploadDir);
            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            }
            File destFile = new File(uploadPath, saveFileName);
            try {
                file.transferTo(destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return saveFileName;
    }
}
