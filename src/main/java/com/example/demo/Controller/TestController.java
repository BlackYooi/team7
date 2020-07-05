package com.example.demo.Controller;

import com.example.demo.Bean.Test;
import com.example.demo.Service.TestService;
import com.example.demo.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: test
 */
@RestController
@CrossOrigin
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;
    @Autowired
    TestMapper testMapper;

    @RequestMapping("/hello")
    public String SayHello(){
        return "hello";
    }

    @PostMapping("/add")
    public String addTest(@RequestBody Test test){
        int i = testService.addTest(test);
        return String.valueOf(i);
    }

    @RequestMapping("/find")
    public List<Test> findTestByName(@RequestParam String name){
        return testMapper.findByName(name);
    }
}
