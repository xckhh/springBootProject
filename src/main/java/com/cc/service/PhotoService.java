package com.cc.service;

import com.cc.pojo.Photo;
import com.cc.pojo.vo.ResultVo;
import org.springframework.web.multipart.MultipartFile;

public interface PhotoService {
    void insertPhoto(Photo photo, MultipartFile[] files);
    ResultVo getPhotoList(String album_id);
    ResultVo deletePhoto(int photo_id);
}
