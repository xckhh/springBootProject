package com.cc.dao;

import com.cc.pojo.Conditions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

//@Mapper
//@Repository
public interface ConditionDao {
    // 注册的时候
    int insertId(@Param("id") String id);

    // 获取全部信息
    Conditions getPersonal(@Param("id") String id);

    // 修改个人简介
    int updateCondition(Conditions conditions);

    // 修改兴趣爱好
    int updateHobby(@Param("id") String id, @Param("hobby") String hobby);
}
