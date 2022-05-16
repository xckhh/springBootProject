package com.cc.service.Impl;

import com.cc.dao.AccontDao;
import com.cc.dao.ConditionDao;
import com.cc.dao.UserDao;
import com.cc.pojo.Accont;
import com.cc.pojo.Meta;
import com.cc.pojo.User;
import com.cc.pojo.vo.*;
import com.cc.service.UserService;
import com.cc.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private AccontDao accontDao;
    @Autowired
    private ConditionDao conditionDao;
    // 登录
    public ResultVo login(String username, String password) {
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        // 登录先将密码加密再比对
        password = MD5Util.getMD5(password);
        User user = userDao.login(username,password);
        if (user != null) {
            meta.setMsg("登录成功!");
            meta.setStatus(200);
            // 修改登录时间
            Accont accont = new Accont();
            accont.setLogin_time(new Date());
            accont.setId(user.getId());
            accontDao.updateAccontInfo(accont);
            // 封装token
            HashMap<String, String> map = new HashMap<>();
            map.put("id", user.getUsername());
            map.put("pwd", user.getPassword());
            user.setToken(JWTUtils.getToken(map));
            resultVo.setData(user);
        } else {
            meta.setMsg("用户名或密码错误!");
            meta.setStatus(400);
        }
        resultVo.setMeta(meta);
        return resultVo;
    }

    // 注册
    public ResultVo register(RegisterVo registerVo) {
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        // 雪花算法获取id
        IdWorker worker = new IdWorker(1, 1, 1);
        registerVo.setId(String.valueOf(worker.nextId()));
        // 创建时间 将昵称设置为用户名
        Accont accont = new Accont(0, registerVo.getUsername(), new Date(), new Date(), IP.getOutIPV4(), null, registerVo.getId());
        // 密码加密
        String md5 = MD5Util.getMD5(registerVo.getPassword());
        registerVo.setPassword(md5);
        // 通过birthday计算年龄
        int age = ObtainAge.getAge(new Date(), registerVo.getBirthday());
        registerVo.setAge(age);
        // 将信息写入用户表
        if (userDao.register(registerVo) == 1) {
            // 将信息写入账号表
            if (accontDao.accontInsert(accont) == 1) {
                // 将信息写入condition表
                if (conditionDao.insertId(registerVo.getId()) == 1) {
                    meta.setStatus(200);
                    meta.setMsg("注册成功!");
                }
            }
        } else {
            meta.setStatus(400);
            meta.setMsg("注册失败!");
        }
        resultVo.setMeta(meta);
        return resultVo;
    }

    // 修改用户信息
    public ResultVo updateUserInfo(User user) {
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        if (userDao.updateUserInfo(user) != 0) {
            meta.setMsg("修改成功!");
            meta.setStatus(200);
        } else {
            meta.setMsg("修改失败!");
            meta.setStatus(400);
        }
        resultVo.setData(userDao.getUserById(user.getId()));
        resultVo.setMeta(meta);
        return resultVo;
    }

    // 更新头像
    public ResultVo updatePhoto(String id, String photo){
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        User user = new User();
        user.setId(id);
        user.setPhoto(photo);
        if (userDao.updateUserInfo(user)!=1){
            meta.setMsg("头像上传失败!");
            meta.setStatus(400);
        }else{
            meta.setMsg("头像上传成功!");
            meta.setStatus(200);
            resultVo.setData(userDao.getUserById(id));
        }
        resultVo.setMeta(meta);
        return resultVo;
    }

    // 通过id查询用户信息
    public ResultVo getUserById(String id){
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        User user = userDao.getUserById(id);
        if (user!=null){
            meta.setStatus(200);
            meta.setMsg("用户数据获取成功!");
            resultVo.setData(user);
        }else{
            meta.setStatus(400);
            meta.setMsg("用户数据获取失败!");
        }
        resultVo.setMeta(meta);
        return resultVo;
    }

    // 获取用户集合
    public ResultVo getUserList() {
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        List<User> userList = userDao.getUserList();
        if (userList.size()>0){
            meta.setStatus(200);
            meta.setMsg("用户数据获取成功!");
            resultVo.setData(userList);
        }else{
            meta.setStatus(400);
            meta.setMsg("用户数据获取失败!");
        }
        resultVo.setMeta(meta);
        return resultVo;
    }

    @Override
    public ResultVo isUsername(String username) {
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        List<User> userList = userDao.isUsername(username);
        if (userList.size()>0){
            meta.setStatus(500);
            meta.setMsg("用户名已存在!");
        }else{
            meta.setStatus(200);
            meta.setMsg("用户名可用!");
        }
        resultVo.setMeta(meta);
        return resultVo;
    }
}
