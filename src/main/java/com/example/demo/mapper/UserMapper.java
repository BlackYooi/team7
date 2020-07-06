package com.example.demo.mapper;

import com.example.demo.Bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户管理的dao层
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * @name findAll 查找所有用户，用于用户管理的用户列表
     * @param 无查询条件
     * @return java.util.List<com.example.demo.Bean.User>
     */
    List<User> findAll();

    /**
     * @name addUser 添加用户
     * @param user 待添加用户的实体对象
     * @return int 插入数据库的条数 0 false 1 true
     */
    int addUser(@Param("user")User user);

    /**
     * @name updateUser 更新用户列表
     * @param user 待更新用户的实体对象
     * @return int 数据库中的匹配条数 0 false >0 true
     */
    int updateUser(@Param("user")User user);

    /**
     * @name deleteUser 删除用户
     * @param user 待删除的用户实体对象，这个实体对象必然封装了id，并只起封装作用，其它参数无效
     * @return int 0 false  >0 true
     */
    int deleteUser(@Param("user")User user);

    /**
     * @name findByUser 通过条件查询用户
     * @param user 封装查询条件
     * @return java.util.List<com.example.demo.Bean.User>
     */
    List<User> findByUser(@Param("user")User user);
}
