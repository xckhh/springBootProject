package com.cc.service;

import com.cc.pojo.User;
import com.cc.pojo.vo.ResultVo;
import com.cc.pojo.vo.RegisterVo;

public interface UserService {
    ResultVo login(String username,String password);
    ResultVo register(RegisterVo registerVo);
    ResultVo updateUserInfo(User user);
    ResultVo updatePhoto(String id, String photo);
    ResultVo getUserById(String id);
    ResultVo getUserList();
    ResultVo isUsername(String username);
}
