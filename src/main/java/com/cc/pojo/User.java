package com.cc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String username;
    private String password;
    private String name;  //名字
    private int age;
    private String phone;
    private String gender; // 性别
    private Date birthday;
    private String region; // 地区
    private String email;
    private String height; // 身高
    private String weight; // 体重
    private String photo; // 头像
    private String token;

}
