package com.cc.dao;

import com.cc.pojo.Photo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecoveryDao {
    // 获取回收站数据
    List<Photo> getPhotoList();
    // 新增删除的照片
    int addPhoto(Photo photo);
    // 回收照片
    int recoveryPhoto(@Param("photo_id") int photo_id);
}
