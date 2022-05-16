package com.cc.dao;

import com.cc.pojo.Accont;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

//@Mapper
//@Repository
public interface AccontDao {
    // 账号信息插入
    int accontInsert(Accont accont);

    // 查询账号信息
    Accont getAccont(@Param("id") String id);

    // 修改信息
    int updateAccontInfo(Accont accont);

}
