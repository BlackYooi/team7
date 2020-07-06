package com.example.demo.Service;

import com.example.demo.Bean.Contace;
import com.example.demo.Util.UUIDGenerator;
import com.example.demo.mapper.ContaceMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 通讯录管理
 */
@Service
public class ContaceService {

    @Autowired
    ContaceMapper contaceMapper;

    public List<Contace> findByContace(Contace contace){
        return contaceMapper.findByContace(contace);
    }

    public int addContace(Contace contace){
        contace.setId(UUIDGenerator.get());
        return contaceMapper.addContace(contace);
    }

    public int deleteContace(Contace contace){
        return contaceMapper.deleteContace(contace);
    }

}
