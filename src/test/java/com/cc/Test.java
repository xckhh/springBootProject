package com.cc;

import com.cc.dao.AccontDao;
import com.cc.dao.ConditionDao;
import com.cc.pojo.Result;
import com.cc.pojo.ResultCode;
import com.cc.pojo.User;
import com.cc.utils.Rules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

public class Test {
    @Autowired
    private ConditionDao dao;

    @org.junit.Test
    public void test() {
        Result.success();
//        System.out.println(ResultCode.RC100.getCode());
    }

}
