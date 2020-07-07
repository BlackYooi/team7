package com.example.demo.Controller;

import com.example.demo.Service.BlacklistService;
import com.example.demo.Util.UtilMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @description: 黑名单管理
 */
@RestController
@RequestMapping("/black")
@CrossOrigin
public class BlacklistController {
    @Autowired
    BlacklistService blacklistService;
    @Autowired
    UtilMsg utilMsg;

    /**
     * @name findMyself 返回自己有哪些黑名单用户
     * @param session
     * @return com.example.demo.Util.UtilMsg
     */
    @GetMapping("/findMyself")
    public UtilMsg findMyself(HttpSession session){
        utilMsg.setHeader("返回的黑名单列表");
        utilMsg.setData(blacklistService.findMyself(session));
        return utilMsg;
    }

    /**
     * @name deleteBlack 删除黑名单用户
     * @param session
     * @param black_name 黑名单名字
     * @return com.example.demo.Util.UtilMsg
     */
    @GetMapping("/deleteBlack")
    public UtilMsg deleteBlack(HttpSession session, @RequestParam String black_name){
        if(blacklistService.deleteBlack(session, black_name ) > 0){
            utilMsg.setHeader("删除成功");
        }
        else {
            utilMsg.setHeader("删除失败");
        }
        return utilMsg;
    }

    /**
     * @name backToCont 移动回通讯录
     * @param session
     * @param black_name 黑名单名字
     * @return com.example.demo.Util.UtilMsg
     */
    @GetMapping("/backToCont")
    public UtilMsg backToCont(HttpSession session, @RequestParam String black_name){
        if(blacklistService.backToCont(session, black_name) > 0){
            utilMsg.setHeader("撤销成功");
        }
        else {
            utilMsg.setHeader("撤销失败");
        }
        return utilMsg;
    }


}
