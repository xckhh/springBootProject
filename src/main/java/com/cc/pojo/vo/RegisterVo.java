package com.cc.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterVo {
    private String id;
    private String username;
    private String password;
    private String phone;
    private String name;  //名字
    private String gender; // 性别
    private int age;
    private Date birthday;
    private String region; // 地区
}
