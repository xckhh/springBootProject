package com.cc.dao;

import com.cc.pojo.Photo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
//@Repository
public interface PhotoDao {
    // 上传照片
    int insertPhoto(Photo photo);

    // 获取照片集合
    List<Photo> getPhotoList(@Param("album_id") String album_id);

    // 删除照片
    int deletePhoto(@Param("photo_id") int photo_id);
}
