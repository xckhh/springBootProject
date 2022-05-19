package com.cc.service.Impl;

import com.cc.dao.ChatDao;
import com.cc.pojo.Chat;
import com.cc.pojo.Meta;
import com.cc.pojo.vo.ChatVo;
import com.cc.pojo.vo.ResultVo;
import com.cc.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatDao chatDao;

    @Override
    public ResultVo getMyMsg(String username) {
        ResultVo<List<Chat>> resultVo = new ResultVo<>();
        Meta meta = new Meta();
        List<Chat> myMsg = chatDao.getMyMsg(username);
        if (myMsg.size()>0){
            resultVo.setData(myMsg);
            meta.setStatus(200);
            meta.setMsg("聊天数据获取成功!");
        }else{
            meta.setStatus(500);
            meta.setMsg("聊天数据获取失败!");
        }
        resultVo.setMeta(meta);
        return resultVo;
    }

    @Override
    public ResultVo getUserChat(String username, String another_username) {
        ResultVo<List<Chat>> resultVo = new ResultVo<>();
        Meta meta = new Meta();
        List<Chat> userChat = chatDao.getUserChat(username, another_username);
        if (userChat.size()>0){
            resultVo.setData(userChat);
            meta.setStatus(200);
            meta.setMsg("聊天数据获取成功!");
        }else{
            meta.setStatus(500);
            meta.setMsg("聊天数据获取失败!");
        }
        resultVo.setMeta(meta);
        return resultVo;
    }

    @Override
    public ResultVo updateIsRead(String username) {
        ResultVo<Object> resultVo = new ResultVo<>();
        Meta meta = new Meta();
        if (chatDao.updateIsRead(username)>0){
            meta.setStatus(200);
            meta.setMsg("修改成功!");
        }else{
            meta.setStatus(500);
            meta.setMsg("修改失败!");
        }
        resultVo.setMeta(meta);
        return resultVo;
    }

    @Override
    public ResultVo insertUserChat(ChatVo[] chatList) {
        ResultVo<Object> vo = new ResultVo<>();
        Meta meta = new Meta();
        if (chatDao.insertUserChat(chatList)!=0){
            meta.setMsg("聊天记录存储成功!");
            meta.setStatus(200);
        }else{
            meta.setMsg("聊天记录存储失败!");
            meta.setStatus(500);
        }
        vo.setMeta(meta);
        return vo;
    }
}
