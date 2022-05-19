package com.cc.pojo.vo;

import com.cc.pojo.Chat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatVo {
    private String username;
    private String another_username;
    private String text;
    private String date;
    private int isRead;
}
