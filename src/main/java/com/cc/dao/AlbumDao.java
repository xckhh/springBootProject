package com.cc.dao;

import com.cc.pojo.Album;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
//@Repository
public interface AlbumDao {
    // 创建相册
    int insertAlbum(Album album);

    // 查询相册信息
    List<Album> getAlbumList(@Param("id") String id);

    // 获取相册id
    List<Integer> getAlbumId(@Param("id") String id);
}
