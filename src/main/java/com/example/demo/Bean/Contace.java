package com.example.demo.Bean;

/**
 * @description: 双向通讯录
 */
public class Contace {

    /**
     * 第一个用户的id
     */
    private String user1;

    /**
     * 第二个用户的id
     */
    private String  user2;

    /**
     * id
     */
    private String id;

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contace{" +
                "user1='" + user1 + '\'' +
                ", user2='" + user2 + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
