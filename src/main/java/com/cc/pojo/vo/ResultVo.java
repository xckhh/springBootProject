package com.cc.pojo.vo;

import com.cc.pojo.Meta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class ResultVo<T> {
    private T data;
    private Meta meta;
}
