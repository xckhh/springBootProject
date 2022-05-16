package com.cc.controller;

import com.cc.pojo.Photo;
import com.cc.pojo.vo.ResultVo;
import com.cc.service.Impl.RecoveryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Api(tags = "回收站模块")
@RestController
@RequestMapping("/recovery")
public class RecoveryController {
    @Autowired
    private RecoveryServiceImpl recoveryServiceImpl;
    @ApiOperation("获取数据")
    @GetMapping("/getPhotoList")
    public ResultVo getPhotoList(){
        return recoveryServiceImpl.getPhotoList();
    }

    @ApiOperation("新增")
    @PostMapping("/addPhoto")
    public ResultVo addPhoto(@RequestBody Photo photo){
        return recoveryServiceImpl.addPhoto(photo);
    }
    @ApiOperation("回收照片")
    @PostMapping("/recoveryPhoto")
    public ResultVo recoveryPhoto(@RequestBody Photo photo){
        return recoveryServiceImpl.recoveryPhoto(photo);
    }
}
