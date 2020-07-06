package com.example.demo.Controller;

import com.example.demo.Bean.User;
import com.example.demo.Service.UserService;
import com.example.demo.Util.UtilMsg;
import com.example.demo.Util.UtilSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @description:
 */
@RestController
@RequestMapping("/u")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UtilMsg utilMsg;

    @PostMapping("/add")
    public UtilMsg addUser(@RequestBody User user){
        if(userService.addUser(user) == 1){
            utilMsg.setHeader("添加成功");
            return utilMsg;
        }
        else {
            utilMsg.setHeader("添加失败");
            return utilMsg;
        }
    }

    /**
     * 查询所有顾客
     * @return
     */
    @RequestMapping("/c")
    public UtilMsg findAllClient(){
        utilMsg.setHeader("所有顾客");
        utilMsg.setData(userService.findAllClient());
        return utilMsg;
    }

    /**
     * 查询所有商家
     * @return
     */
    @RequestMapping("/s")
    public UtilMsg findAllSeller(){
        utilMsg.setHeader("所有商家");
        utilMsg.setData(userService.findAllSeller());
        return utilMsg;
    }

    /**
     * 更新用户
     */
    @PostMapping("/update")
    public UtilMsg updateUser(@RequestBody User user){
        if(userService.updateUser(user)){
            utilMsg.setHeader("修改成功");
        }
        else {
            utilMsg.setHeader("修改失败");
        }
        return utilMsg;
    }

    /**
     * 删除用户
     */
    @GetMapping("/deleteById")
    public UtilMsg deleteUser(@RequestParam String id){
        if(userService.deleteUserById(id)){
            utilMsg.setHeader("删除成功");
        }
        else {
            utilMsg.setHeader("添加失败");
        }
        return utilMsg;
    }

    /**
     * 查找用户
     */
    @PostMapping("/findUser")
    public UtilMsg findUser(@RequestBody User user){
        utilMsg.setHeader("返回列表");
        utilMsg.setData(userService.addUser(user));
        return utilMsg;
    }

    /**
     * 通过名字查询用户
     */
    @GetMapping("/findUserByName")
    public UtilMsg findByUserName(@RequestParam String name){
        User user = new User();
        user.setName(name);
        utilMsg.setHeader("返回列表");
        utilMsg.setData(userService.findByUser(user));
        return utilMsg;
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    public UtilMsg userLogin(@RequestBody User user, HttpSession session){
        if(userService.userLogin(user,session) == true){
            utilMsg.setHeader("验证通过");
            User u = (User) session.getAttribute(UtilSession.USER_SESSION_KEY);
            System.out.println(u.toString());
        }
        else
        {
            utilMsg.setHeader("验证失败");
        }
        return utilMsg;
    }
}
