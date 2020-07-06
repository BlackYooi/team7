package com.example.demo.mapper;

import com.example.demo.Bean.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 消息管理
 */
@Mapper
@Repository
public interface MessageMapper {

    /**
     * @name addMessage 向数据库添加消息，用于保存消息记录
     * @param message
     * @return int 0 false 1 true
     */
    int addMessage(@Param("message")Message message);

}
