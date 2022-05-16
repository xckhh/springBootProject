package com.cc.service;

import com.cc.pojo.Photo;
import com.cc.pojo.vo.ResultVo;

public interface RecoveryService {
    ResultVo getPhotoList();
    ResultVo addPhoto(Photo photo);
    ResultVo recoveryPhoto(Photo photo);
}
