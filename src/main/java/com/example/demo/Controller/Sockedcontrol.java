package com.example.demo.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Bean.Message;
import com.example.demo.Bean.User;
import com.example.demo.Util.UUIDGenerator;
import com.example.demo.Util.UtilMsg;
import com.example.demo.Util.UtilSession;
import com.example.demo.config.HttpSessionConfigurator;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint(value = "/chat/",configurator = HttpSessionConfigurator.class)
public class Sockedcontrol {

    private Session session;
    private String username;
    private static Map<String, Sockedcontrol> clients = new ConcurrentHashMap<>();

    /**
     * @name onMessage
     * @param msg Bena.Message对应的json字符串
     * @return void
     */
    @OnMessage
    public void onMessage(String msg) {
        System.out.println("接受到信息:" + msg);
        Message message = JSONArray.parseObject(msg, Message.class);
        message.setDate(new Date());
        message.setId(UUIDGenerator.get());
        //获取发送者的用户名
        HttpSession httpSession = (HttpSession)this.session.getUserProperties().get(HttpSession.class.getName());
        User user = (User)httpSession.getAttribute(UtilSession.USER_SESSION_KEY);
        message.setSend_user(user.getName());
        System.out.println(message.getType());
        switch (message.getType()) {
            case "私聊":
                sendTo(message);
                break;
                default:
                    System.out.println(message.getAccept_user());
        }
    }

    @OnOpen
    public void onOpen(Session session,EndpointConfig config) {
        //获取发送者的用户名
        HttpSession httpSession = (HttpSession)config.getUserProperties().get(HttpSession.class.getName());
        User user = (User)httpSession.getAttribute(UtilSession.USER_SESSION_KEY);
        this.session = session;
        this.username = user.getName();
        clients.put(username, this);
        System.out.println("用户" + username + "上线");
        //sendLoginMsg();     //给上线用户发送测试信息
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose() {
        //获取发送者的用户名
        HttpSession httpSession = (HttpSession)this.session.getUserProperties().get(HttpSession.class.getName());
        User user = (User)httpSession.getAttribute(UtilSession.USER_SESSION_KEY);
        clients.remove(user.getName());
        System.out.println("用户下线");
    }

    @OnError
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        System.out.println("出错了");
    }

    /**
     * 发送消息的函数
     */
    private void sendLoginMsg() {
        Message message = new Message();
        message.setSend_user(username);
        message.setAccept_user(username);
        //演示获取标准化时间而已
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        message.setDate(new Date());
        message.setId(UUIDGenerator.get());
        message.setMessage("这是建立连接返回的测试信息");
        message.setType("建立连接返回信息");
        JSONObject json = new JSONObject();
        json.put("name", this.username);

        //封装返回消息
        for (Sockedcontrol sockedcontrol : clients.values()) {
            sockedcontrol.session.getAsyncRemote().sendText(JSON.toJSONString(message));
        }
    }

    /**
     * @name sendTo 指定接收消息的人
     * @return void
     */
    private void sendTo(Message message) {
        message.setSend_user(this.username);
        System.out.println("sendTo");
        System.out.println(message.toString());
        Session session = clients.get(message.getAccept_user()).session;
        String msg = JSON.toJSONString(message);
        session.getAsyncRemote().sendText(msg);
        System.out.println("发送结束");

    }

}
