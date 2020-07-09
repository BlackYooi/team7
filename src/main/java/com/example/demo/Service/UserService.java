package com.example.demo.Service;

import com.example.demo.Bean.User;
import com.example.demo.Util.Md5Util;
import com.example.demo.Util.UUIDGenerator;
import com.example.demo.Util.UtilSession;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description: 用户管理
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> findAll(){
        return userMapper.findAll();
    }

    public int addUser(User user){
        user.setId(UUIDGenerator.get());
        user.setPassword(Md5Util.md5(user.getPassword()));
        return userMapper.addUser(user);
    }

   public int deleteUser(User user){return userMapper.deleteUser(user);}

   public List<User> findByUser(User user){
        return userMapper.findByUser(user);
   }

   /**
    * @name findAllClient 查询所有顾客
    * @param
    * @return java.util.List<com.example.demo.Bean.User>
    */
   public List<User> findAllClient(){
        User user = new User();
        user.setIdentity("顾客");
        return userMapper.findByUser(user);
   }


   /**
    * @name findAllSeller 查询所有商家
    * @param
    * @return java.util.List<com.example.demo.Bean.User>
    */
   public List<User> findAllSeller(){
        User user = new User();
        user.setIdentity("商家");
        return userMapper.findByUser(user);
   }

   /**
    * @name updateUser 更新用户
    * @param user 待更新的信息
    * @return boolean
    */
   public boolean updateUser(User user){
       if(userMapper.updateUser(user) >= 1){
           return true;
       }
       else {
           return false;
       }
   }

    /**
     * 通过id删除用户
     */
    public boolean deleteUserById(String id){
        User user = new User();
        user.setId(id);
        //删除 消息表 黑名单 通讯录相关信息
        if(this.deleteUser(user) == 1){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean userLogin(User user, HttpSession session){
        user.setPassword(Md5Util.md5(user.getPassword()));
        List<User> list = userMapper.findByUser(user);
        if(list.size() == 1){
            //登录成功
            //添加session
            session.setAttribute(UtilSession.USER_SESSION_KEY, user);
            session.setMaxInactiveInterval(15 * 60);
            return true;
        }
        else {
            //登录失败
            return false;
        }
    }


}
