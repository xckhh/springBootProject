package com.cc.service.Impl;

import com.cc.dao.ConditionDao;
import com.cc.pojo.Conditions;
import com.cc.pojo.vo.ResultVo;
import com.cc.pojo.Meta;
import com.cc.service.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConditionServiceImpl implements ConditionService {
    @Autowired
    private ConditionDao conditionDao;

    // 获取全部信息
    public ResultVo getPersonal(String id) {
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        Conditions personal = conditionDao.getPersonal(id);
        if (personal != null) {
            meta.setStatus(200);
            meta.setMsg("数据获取成功!");
            resultVo.setData(personal);
        } else {
            meta.setStatus(400);
            meta.setMsg("数据获取失败!");
        }
        resultVo.setMeta(meta);
        return resultVo;
    }

    // 修改个人简介
    public ResultVo updateCondition(Conditions conditions) {
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        if (conditionDao.updateCondition(conditions) != 0) {
            meta.setStatus(200);
            meta.setMsg("修改成功!");
        } else {
            meta.setStatus(400);
            meta.setMsg("修改失败!");
        }
        resultVo.setMeta(meta);
        return resultVo;
    }

    // 修改爱好
    public ResultVo updateHobby(String id, String hobby) {
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        if (conditionDao.updateHobby(id, hobby) != 0) {
            meta.setStatus(200);
            meta.setMsg("修改成功!");
        } else {
            meta.setStatus(400);
            meta.setMsg("修改失败!");
        }
        resultVo.setMeta(meta);
        return resultVo;
    }
}
