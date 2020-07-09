package com.example.demo.Controller;

import com.example.demo.Bean.User;
import com.example.demo.Service.ContaceService;
import com.example.demo.Util.UtilMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description: 通讯录的控制层
 */
@RestController
@RequestMapping("/contace")
public class ContaceController {
    @Autowired
    ContaceService contaceService;
    @Autowired
    UtilMsg utilMsg;

    /**
     * @name findMyselfCont 查找出自己的好友列表
     * @param session
     * @return com.example.demo.Util.UtilMsg
     */
    @GetMapping("/findMyselfCont")
    public UtilMsg findMyselfCont(HttpSession session){
        List<User> myselfCont = contaceService.findMyselfCont(session);
        utilMsg.setHeader("返回的好友列表");
        utilMsg.setData(myselfCont);
        return utilMsg;
    }

    /**
     * @name deleteContByName 通过好友名删除好友
     * @param session
     * @param name
     * @return com.example.demo.Util.UtilMsg
     */
    @GetMapping("/deleteContByName")
    public UtilMsg deleteContByName(HttpSession session, @RequestParam String name){
        if(contaceService.deleteContace(session, name) == 1){
            utilMsg.setHeader("删除成功");
        }
        else{
            utilMsg.setHeader("删除失败");
        }
        return utilMsg;
    }

    /**
     * @name addByName 通过名字添加好友
     * @param session
     * @param name
     * @return com.example.demo.Util.UtilMsg
     */
    @GetMapping("/addByName")
    public UtilMsg addByName(HttpSession session, @RequestParam String name){
        if(contaceService.addContace(session, name) > 0){
            utilMsg.setHeader("添加成功");
        }
        else {
            utilMsg.setHeader("添加失败");
        }
        return utilMsg;
    }

    /**
     * @name JoinToBlackList 加入黑名单
     * @param session
     * @param name 被加者的名字
     * @return com.example.demo.Util.UtilMsg
     */
    @GetMapping("/joinToBlackList")
    public UtilMsg JoinToBlackList(HttpSession session, String name){
        if(contaceService.joinToBlackList(session, name) > 0){
            utilMsg.setHeader("加入成功");
        }
        else {
            utilMsg.setHeader("加入失败");
        }
        return utilMsg;
    }


}
