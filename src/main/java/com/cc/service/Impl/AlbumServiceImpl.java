package com.cc.service.Impl;

import com.cc.dao.AlbumDao;
import com.cc.pojo.Album;
import com.cc.pojo.Meta;
import com.cc.pojo.vo.ResultVo;
import com.cc.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;

    // 创建相册
    public ResultVo createdAlbum(Album album) {
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        if (albumDao.insertAlbum(album) == 1) {
            meta.setMsg("相册创建成功!");
            meta.setStatus(200);
        } else {
            meta.setMsg("相册创建失败!");
            meta.setStatus(400);
        }
        resultVo.setMeta(meta);
        return resultVo;
    }

    // 获取相册集合
    public ResultVo getAlbumList(String id) {
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        List<Album> albums = albumDao.getAlbumList(id);
        if (albums != null) {
            meta.setStatus(200);
            meta.setMsg("相册集合获取成功!");
            resultVo.setData(albums);
        } else {
            meta.setStatus(400);
            meta.setMsg("相册集合获取失败!");
        }
        resultVo.setMeta(meta);
        return resultVo;
    }

    // 获取相册id
    public String getAlbumId(String id){
        List<Integer> albumId = albumDao.getAlbumId(id);
        String album_id=null;
        for (Integer integer : albumId) {
            album_id=integer+"";
            break;
        }
        return album_id;
    }
}
