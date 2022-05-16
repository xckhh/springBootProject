package com.cc.service;

import com.cc.pojo.Album;
import com.cc.pojo.vo.ResultVo;

public interface AlbumService {
    ResultVo createdAlbum(Album album);
    ResultVo getAlbumList(String id);
    String getAlbumId(String id);
}
