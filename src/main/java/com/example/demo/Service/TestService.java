package com.example.demo.Service;

import com.example.demo.Bean.Test;
import com.example.demo.mapper.TestMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 */
@Service
public class TestService {

    @Autowired
    TestMapper testMapper;

    public List<Test> findByName(String name){
        List<Test> list = testMapper.findByName(name);
        return list;
    }

    public int deleteTest(String name){
        return testMapper.deleteTest(name);
    }

    public int addTest(Test test){
        return testMapper.addTest(test);
    }

}
