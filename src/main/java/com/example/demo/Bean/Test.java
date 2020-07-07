package com.example.demo.Bean;

import org.springframework.stereotype.Component;

/**
 * @description: 用于测试
 */
@Component
public class Test {
    /**
     * 测试的名字
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
