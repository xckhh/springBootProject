package com.cc.controller;

import com.cc.pojo.Meta;
import com.cc.pojo.User;
import com.cc.pojo.vo.*;
import com.cc.service.Impl.UserServiceImpl;
import com.cc.utils.Image;
import com.cc.utils.Rules;
import com.cc.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@Api(tags = "用户模块")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @ApiOperation("登录")
    @RequestMapping(value = "/login/{username}/{password}",method = RequestMethod.GET)
    public ResultVo login(@PathVariable("username") String username,@PathVariable("password") String password) {
        return userServiceImpl.login(username,password);
    }

    @ApiOperation("注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResultVo register(@RequestBody RegisterVo registerVo) {
        return userServiceImpl.register(registerVo);
    }

    @ApiOperation("修改用户信息")
    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public ResultVo updateUserInfo(@RequestBody User user) {
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        if (StringUtil.isEmpty(user.getEmail()) && StringUtil.isEmpty(user.getWeight()) && StringUtil.isEmpty(user.getHeight()) && StringUtil.isEmpty(user.getPhone())) {
            meta.setMsg("未做出修改!");
            meta.setStatus(500);
            resultVo.setMeta(meta);
        } else {
            resultVo = userServiceImpl.updateUserInfo(user);
        }
        if (!StringUtil.isEmpty(user.getPhone())) {
            if (!Rules.isMobile(user.getPhone())) {
                meta.setMsg("手机格式错误，请输入正确的手机格式!");
                meta.setStatus(500);
                resultVo.setMeta(meta);
            }
        }
        if (!StringUtil.isEmpty(user.getEmail())) {
            if (!Rules.isEmail(user.getEmail())) {
                meta.setMsg("邮箱格式错误，请输入正确的邮箱格式!");
                meta.setStatus(500);
                resultVo.setMeta(meta);
            }
        }
        return resultVo;
    }

    @ApiOperation("上传头像")
    @RequestMapping("/updatePhoto")
    public ResultVo updatePhoto(@RequestParam("id") String id, @RequestParam("file") MultipartFile[] file){
        // 存储头像，返回头像的新名称
        String imgName = Image.uploadImages(file[0]);
        if (imgName!=""){
            return userServiceImpl.updatePhoto(id,imgName);
        }
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        meta.setMsg("图片上传失败!");
        meta.setStatus(400);
        resultVo.setMeta(meta);
        return resultVo;
    }

    @ApiOperation("通过id查询用户")
    @RequestMapping(value = "/getUserById/{id}",method = RequestMethod.GET)
    public ResultVo getUserById(@PathVariable("id") String id){
        return userServiceImpl.getUserById(id);
    }

    @ApiOperation("获取用户集合")
    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    public ResultVo getUserList(){
        return userServiceImpl.getUserList();
    }

    @ApiOperation("验证用户名是否可用")
    @RequestMapping(value = "/isUsername/{username}",method = RequestMethod.GET)
    public ResultVo isUsername(@PathVariable("username") String username){
        return userServiceImpl.isUsername(username);
    }
}
