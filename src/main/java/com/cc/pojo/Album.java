package com.cc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    private int album_id;
    private String album_name;
    private String album_description;
    private Date photo_time;
    private String jurisdiction;
    private String id;
    private String cover;
}
