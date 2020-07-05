package com.example.demo.mapper;

import com.example.demo.Bean.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: TestMapper.xml
 */

@Repository
@Mapper
public interface TestMapper {

    /**
     * 通过测试的名字找到测试实体,由于name不是主键，可能返回多个
     * @return Bean.Test
     */
    List<Test> findByName(@Param("name") String name);

    /**
     * @name deleteTest 删除测试
     * @param 无
     * @return 返回值是：匹配数据的行数，即满足sql语句中 where 语句的个数
     */
    int deleteTest(@Param("name") String name);

    /**
     * @name addTest 添加测试
     * @param test
     * @return int 在数据库插入的条数
     */
    int addTest(@Param("test")Test test);
}
