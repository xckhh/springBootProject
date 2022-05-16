package com.cc.service;

import com.cc.pojo.Accont;
import com.cc.pojo.vo.ResultVo;

public interface AccontService {
    ResultVo getAccont(String id);
    ResultVo updateNickname(Accont accont);
}
