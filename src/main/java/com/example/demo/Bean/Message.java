package com.example.demo.Bean;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description: 消息对象
 */
@Component
public class Message {

    /**
     * 消息的主键
     */
    public String id;

    /**
     * 发送者的id
     */
    public String send_user;

    /**
     * 接受者的id
     */
    public String accept_user;

    /**
     * 消息内容
     */
    public String message;

    /**
     * 消息类型
     */
    public String type;

    /**
     * 发送时间
     */
    public Date date;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSend_user() {
        return send_user;
    }

    public void setSend_user(String send_user) {
        this.send_user = send_user;
    }

    public String getAccept_user() {
        return accept_user;
    }

    public void setAccept_user(String accept_user) {
        this.accept_user = accept_user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", send_user='" + send_user + '\'' +
                ", accept_user='" + accept_user + '\'' +
                ", message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                '}';
    }
}
