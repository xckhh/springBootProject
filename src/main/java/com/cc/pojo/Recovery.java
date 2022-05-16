package com.cc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recovery {
    private int recovery_id;
    private int photo_id;
    private int album_id;
    private String photo_path;
}
