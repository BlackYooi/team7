package com.example.demo.Bean;

/**
 * @description: 黑名单
 */
public class Blacklist {

    /**
     * 添加者的id
     */
    private String add_user;

    /**
     * 被添加者的id
     */
    private String black_user;

    /**
     * 编号
     */
    private String id;

    public String getAdd_user() {
        return add_user;
    }

    public void setAdd_user(String add_user) {
        this.add_user = add_user;
    }

    public String getBlack_user() {
        return black_user;
    }

    public void setBlack_user(String black_user) {
        this.black_user = black_user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Blacklist{" +
                "add_user='" + add_user + '\'' +
                ", black_user='" + black_user + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
