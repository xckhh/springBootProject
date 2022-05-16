package com.cc.controller;

import com.cc.pojo.Photo;
import com.cc.pojo.vo.ResultVo;
import com.cc.service.Impl.PhotoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@Api(tags = "照片模块")
@RestController
@RequestMapping("/photo")
public class PhotoController {
    @Autowired
    private PhotoServiceImpl photoServiceImpl;

    @ApiOperation("上传照片集合")
    @RequestMapping(value = "/uploadPhotoList",method = RequestMethod.POST)
    public ResultVo uploadPhotoList(@RequestPart("photo") Photo photo, @RequestPart("file") MultipartFile[] files){
        photoServiceImpl.insertPhoto(photo,files);
        return null;
    }

    @ApiOperation("获取照片集合")
    @RequestMapping(value = "/getPhotoList/{album_id}",method = RequestMethod.GET)
    public ResultVo getPhotoList(@PathVariable("album_id") String album_id){
        return photoServiceImpl.getPhotoList(album_id);
    }

    @ApiOperation("删除照片")
    @DeleteMapping("/deletePhoto/{photo_id}")
    public ResultVo deletePhoto(@PathVariable("photo_id") int photo_id){
        return photoServiceImpl.deletePhoto(photo_id);
    }

}
