package com.example.demo.Service;

import com.example.demo.Bean.User;
import com.example.demo.Util.UUIDGenerator;
import com.example.demo.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userMapper.addUser(user);
    }

    public int updateUser(User user){
        return updateUser(user);
    }

   public int deleteUser(User user){return userMapper.deleteUser(user);}


}
