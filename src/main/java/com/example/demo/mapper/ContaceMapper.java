package com.example.demo.mapper;

import com.example.demo.Bean.Contace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: 通讯录，双向
 */
@Mapper
@Repository
public interface ContaceMapper {

    /**
     * @name findByContace 通过contace查询
     * @param contace 封装查询信息的contace，因为Conrace.user1和Contace.user2地位相同，将以不管但条件，还是多条件都把查询信息封装进来
     *                故封装查询条件的时候，随便封装到user1 user2都行
     * @return java.util.List<com.example.demo.Bean.Contace>
     */
    List<Contace> findByContace(@Param("contace")Contace contace);

    /**
     * @name addContace 添加通讯录
     * @param contace 待添加
     * @return int 0 false 1 true
     */
    int addContace(@Param("contace")Contace contace);

    /**
     * @name deleteCOntace 通讯录删除共功能
     * @param contace 待删除的通讯录，根据使用环境来见user1和user2不为空
     * @return int
     */
    int deleteContace(@Param("contace")Contace contace);
}
