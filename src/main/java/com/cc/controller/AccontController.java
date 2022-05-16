package com.cc.controller;

import com.cc.pojo.Accont;
import com.cc.pojo.vo.ResultVo;
import com.cc.service.Impl.AccontServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "账号模块")
@RestController
@RequestMapping("/accont")
public class AccontController {
    @Autowired
    private AccontServiceImpl accontServiceImpl;

    @ApiOperation("获取账号信息")
    @RequestMapping(value = "/getAccont/{id}",method = RequestMethod.GET)
    public ResultVo getAccont(@PathVariable("id") String id) {
        return accontServiceImpl.getAccont(id);
    }

    @ApiOperation("修改昵称")
    @RequestMapping(value = "/updateNickname/{id}/{nickname}",method = RequestMethod.GET)
    public ResultVo updateNickname(@PathVariable("id") String id, @PathVariable("nickname") String nickname) {
        Accont accont = new Accont();
        accont.setId(id);
        accont.setNickname(nickname);
        return accontServiceImpl.updateNickname(accont);
    }
}
