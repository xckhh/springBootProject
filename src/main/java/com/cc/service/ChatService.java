package com.cc.service;

import com.cc.pojo.Chat;
import com.cc.pojo.vo.ChatVo;
import com.cc.pojo.vo.ResultVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChatService {
    ResultVo getUserChat(String username, String another_username);
    ResultVo insertUserChat(ChatVo[] chatList);
    ResultVo getMyMsg(String username);
    ResultVo updateIsRead(String username );
}
