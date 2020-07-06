package com.example.demo.Service;

import com.example.demo.Bean.Blacklist;
import com.example.demo.Util.UUIDGenerator;
import com.example.demo.mapper.BlacklistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 黑名单管理
 */
@Service
public class BlacklistService {

    @Autowired
    BlacklistMapper blacklistMapper;

    public int addBlackList(Blacklist blacklist){
        //给id赋值
        blacklist.setId(UUIDGenerator.get());
        return blacklistMapper.addBlackList(blacklist);
    }

    public int deleteBlackList(Blacklist blacklist){
        return blacklistMapper.deleteBlackList(blacklist);
    }

    public List<Blacklist> findByBlacklist(Blacklist blacklist){
        return blacklistMapper.findByBlacklist(blacklist);
    }

}
