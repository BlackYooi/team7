package com.example.demo.mapper;

import com.example.demo.Bean.Blacklist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 黑名单管理
 */
@Mapper
@Repository
public interface BlacklistMapper {

    /**
     * @name addBlackList 添加黑名单
     * @param blacklist 添加的参数
     * @return int 0 false
     */
    int addBlackList(@Param("blacklist")Blacklist blacklist);

    /**
     * @name deleteBlackList 删除黑名单
     * @param blacklist 删除的参数
     * @return int 0 false
     */
    int deleteBlackList(@Param("blacklist")Blacklist blacklist);

    /**
     * @name findByBlacklist 通过条件查询blacklist，因为使用情况只有通过add_user查询，自己查哪些加入了黑名单
     * @param blacklist 封装了add_user
     * @return java.util.List<com.example.demo.Bean.Blacklist>
     */
    List<Blacklist> findByBlacklist(@Param("blacklist")Blacklist blacklist);
}
