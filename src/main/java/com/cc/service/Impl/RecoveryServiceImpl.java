package com.cc.service.Impl;

import com.cc.dao.PhotoDao;
import com.cc.dao.RecoveryDao;
import com.cc.pojo.Meta;
import com.cc.pojo.Photo;
import com.cc.pojo.vo.ResultVo;
import com.cc.service.RecoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecoveryServiceImpl implements RecoveryService {
    @Autowired
    private RecoveryDao recoveryDao;
    @Autowired
    private PhotoDao photoDao;
    // 获取回收站数据
    public ResultVo getPhotoList(){
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        List<Photo> photoList = recoveryDao.getPhotoList();
        if (photoList.size()>0){
            meta.setMsg("数据获取成功!");
            meta.setStatus(200);
            resultVo.setData(photoList);
        }else{
            meta.setMsg("暂无数据!");
            meta.setStatus(404);
        }
        resultVo.setMeta(meta);
        return resultVo;
    }
    // 新增照片
    public ResultVo addPhoto(Photo photo){
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        if (recoveryDao.addPhoto(photo)==1){
            meta.setMsg("照片添加成功!");
            meta.setStatus(200);
        }else{
            meta.setMsg("照片添加失败!");
            meta.setStatus(500);
        }
        resultVo.setMeta(meta);
        return resultVo;
    }
    // 回收照片
    public ResultVo recoveryPhoto(Photo photo){
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        if (recoveryDao.recoveryPhoto(photo.getPhoto_id())==1){
            meta.setMsg("照片回收成功!");
            meta.setStatus(200);
            // 将照片信息添加回照片表
            photoDao.insertPhoto(photo);
        }else{
            meta.setMsg("照片回收失败!");
            meta.setStatus(500);
        }
        resultVo.setMeta(meta);
        return resultVo;
    }
}
