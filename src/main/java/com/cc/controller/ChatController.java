package com.cc.controller;
import com.cc.pojo.vo.ChatVo;
import com.cc.pojo.vo.ResultVo;
import com.cc.service.Impl.ChatServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Api(tags = "私聊模块")
@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatServiceImpl chatService;

    @ApiOperation("获取聊天数据")
    @RequestMapping(value = "/{username}/{another_username}",method = RequestMethod.GET)
    public ResultVo getUserChat(@PathVariable("username") String username,@PathVariable("another_username") String another_username){
        return chatService.getUserChat(username,another_username);
    }

    @ApiOperation("存储聊天记录")
    @RequestMapping(value = "/insertUserChat",method = RequestMethod.POST)
    public ResultVo insertUserChat(@RequestBody ChatVo[] chatList){
        return chatService.insertUserChat(chatList);
    }

    @ApiOperation("获取未读消息")
    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    public ResultVo getMyMsg(@PathVariable("username") String username){
        return chatService.getMyMsg(username);
    }

    @ApiOperation("修改isRead")
    @RequestMapping(value = "/update/{username}",method = RequestMethod.GET)
    public ResultVo updateIsRead(@PathVariable("username") String username){
        return chatService.updateIsRead(username);
    }
}
