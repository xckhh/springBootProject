package com.cc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    private int id;
    private String username;
    private String another_username;
    private String date;
    private String text;
    private String photo;
    private int isRead;
}
