package com.cc.service.Impl;

import com.cc.dao.PhotoDao;
import com.cc.pojo.Meta;
import com.cc.pojo.Photo;
import com.cc.pojo.vo.ResultVo;
import com.cc.service.PhotoService;
import com.cc.utils.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoDao photoDao;
    // 上传图片
    public void insertPhoto(Photo photo, MultipartFile[] files){
        for (MultipartFile file : files) {
            String s = Image.uploadImages(file);
            photo.setPhoto_path(s);
            photoDao.insertPhoto(photo);
        }
    }

    // 获取照片集合
    public ResultVo getPhotoList(String album_id){
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        List<Photo> photoList = photoDao.getPhotoList(album_id);
        if (photoList.size()>0){
            meta.setMsg("照片数据获取成功!");
            meta.setStatus(200);
            resultVo.setData(photoList);
        }else{
            meta.setMsg("照片数据获取失败!");
            resultVo.setData(null);
            meta.setStatus(400);
        }
        resultVo.setMeta(meta);
        return resultVo;
    }

    // 删除照片
    public ResultVo deletePhoto(int photo_id){
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        if (photoDao.deletePhoto(photo_id)==1){
            meta.setMsg("照片删除成功!");
            meta.setStatus(200);
        }else{
            meta.setMsg("照片删除失败!");
            meta.setStatus(400);
        }
        resultVo.setMeta(meta);
        return resultVo;
    }
}
