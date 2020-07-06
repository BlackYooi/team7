package com.example.demo.Service;

import com.example.demo.Bean.Message;
import com.example.demo.Util.UUIDGenerator;
import com.example.demo.mapper.MessageMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 消息管理
 */
@Service
public class MessageService {

    @Autowired
    MessageMapper messageMapper;

    public int addMessage(Message message){
        message.setId(UUIDGenerator.get());
        return messageMapper.addMessage(message);
    }
}
