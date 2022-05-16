package com.cc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Accont {
    private int accont_id;
    private String nickname;
    private Date register_time;
    private Date login_time;
    private String login_address;
    private String head_path;
    private String id;
}
