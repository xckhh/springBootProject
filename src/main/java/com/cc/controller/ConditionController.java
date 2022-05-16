package com.cc.controller;

import com.cc.pojo.Conditions;
import com.cc.pojo.vo.ResultVo;
import com.cc.pojo.Meta;
import com.cc.service.Impl.ConditionServiceImpl;
import com.cc.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "条件模块")
@RestController
@RequestMapping("/condition")
public class ConditionController {
    @Autowired
    private ConditionServiceImpl conditionServiceImpl;

    @ApiOperation("获取全部信息")
    @RequestMapping(value = "/getPersonal/{id}",method = RequestMethod.GET)
    public ResultVo getPersonal(@PathVariable("id") String id) {
        return conditionServiceImpl.getPersonal(id);
    }

    @ApiOperation("修改个人简介")
    @RequestMapping(value = "/updateCondition",method = RequestMethod.POST)
    public ResultVo updateCondition(@RequestBody Conditions conditions) {
        ResultVo resultVo = new ResultVo();
        Meta meta = new Meta();
        if (StringUtil.isEmpty(conditions.getMonthly_income()) && StringUtil.isEmpty(conditions.getCar_number()) && StringUtil.isEmpty(conditions.getHouse_number()) && StringUtil.isEmpty(conditions.getWork_type()) && StringUtil.isEmpty(conditions.getMarital_status()) && StringUtil.isEmpty(conditions.getHobby()) && StringUtil.isEmpty(conditions.getRequirement()) && StringUtil.isEmpty(conditions.getPersonal_signature())) {
            meta.setMsg("未做出修改!");
            meta.setStatus(500);
            resultVo.setMeta(meta);
        } else {
            resultVo = conditionServiceImpl.updateCondition(conditions);
        }
        return resultVo;
    }

    @ApiOperation("修改兴趣爱好")
    @RequestMapping(value = "/updateHobby/{id}/{hobby}",method = RequestMethod.GET)
    public ResultVo updateHobby(@PathVariable("id") String id, @PathVariable("hobby") String hobby) {
        return conditionServiceImpl.updateHobby(id, hobby);
    }
}
