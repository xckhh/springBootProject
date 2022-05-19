package com.cc.dao;

import com.cc.pojo.Chat;
import com.cc.pojo.vo.ChatVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChatDao {
    // 获取两个用户之间的聊天记录
    List<Chat> getUserChat(@Param("username") String username,@Param("another_username") String another_username);
    // 聊天窗口关闭时 存储聊天记录
    int insertUserChat(@Param("charList") ChatVo[] chatList);
    // 获取我的未读消息
    List<Chat> getMyMsg(@Param("username") String username);
    // 标记为已读
    int updateIsRead(@Param("username") String username );
}
