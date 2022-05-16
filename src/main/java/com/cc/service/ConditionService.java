package com.cc.service;

import com.cc.pojo.Conditions;
import com.cc.pojo.vo.ResultVo;

public interface ConditionService {
    ResultVo getPersonal(String id);
    ResultVo updateCondition(Conditions conditions);
    ResultVo updateHobby(String id, String hobby);
}
