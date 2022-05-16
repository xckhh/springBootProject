package com.cc.dao;

import com.cc.pojo.User;
import com.cc.pojo.vo.RegisterVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
//@Repository
public interface UserDao {
    // 登录 String username String password
    User login(@Param("username") String username,@Param("password") String password);

    // 注册
    int register(RegisterVo registerVo);

    // 修改用户信息
    int updateUserInfo(User user);

    // ID获取用户信息
    User getUserById(@Param("id") String id);

    // 获取所有用户信息
    List<User> getUserList();

    // 验证用户名是否存在
    List<User> isUsername(@Param("username") String username);
}
