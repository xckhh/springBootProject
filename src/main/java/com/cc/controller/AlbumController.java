package com.cc.controller;

import com.cc.pojo.Album;
import com.cc.pojo.vo.ResultVo;
import com.cc.service.Impl.AlbumServiceImpl;
import com.cc.utils.Image;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@Api(tags = "相册模块")
@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumServiceImpl albumServiceImpl;

    @ApiOperation("创建相册")
    @RequestMapping(value = "/createdAlbum",method = RequestMethod.POST)
    public ResultVo createdAlbum(@RequestPart("album") Album album, @RequestPart("file") MultipartFile[] file) {
        // 存储图片，存储成功则返回图片名字
        String imageName = Image.uploadImages(file[0]);
        if (imageName != null) {
            album.setCover(imageName);
        }
        return albumServiceImpl.createdAlbum(album);
    }

    @ApiOperation("获取相册集合")
    @RequestMapping(value = "/getAlbumList/{id}",method = RequestMethod.GET)
    public ResultVo getAlbumList(@PathVariable("id") String id) {
        return albumServiceImpl.getAlbumList(id);
    }

    @ApiOperation("获取当前相册id")
    @RequestMapping(value = "/getAlbumId/{id}",method = RequestMethod.GET)
    public String getAlbumId(@PathVariable("id") String id){
        return albumServiceImpl.getAlbumId(id);
    }
}
