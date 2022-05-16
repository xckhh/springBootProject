package com.cc.service.Impl;

import com.cc.dao.AccontDao;
import com.cc.pojo.Accont;
import com.cc.pojo.vo.ResultVo;
import com.cc.pojo.Meta;
import com.cc.service.AccontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccontServiceImpl implements AccontService {
    @Autowired
    private AccontDao accontDao;


    // 查询账号信息
    public ResultVo getAccont(String id) {
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        Accont accont = accontDao.getAccont(id);
        if (accont != null) {
            meta.setMsg("账号信息获取成功!");
            meta.setStatus(200);
            resultVo.setData(accont);
        } else {
            meta.setMsg("账号信息获取失败!");
            meta.setStatus(400);
        }
        resultVo.setMeta(meta);
        return resultVo;
    }

    // 修改昵称
    public ResultVo updateNickname(Accont accont) {
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        if (accontDao.updateAccontInfo(accont) == 1) {
            meta.setStatus(200);
            meta.setMsg("昵称修改成功!");
        } else {
            meta.setStatus(400);
            meta.setMsg("昵称修改失败!");
        }
        resultVo.setMeta(meta);
        return resultVo;
    }
}
