package com.example.demo.Util;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

/**
 * @description: 这个类用于封装返回数据
 */
@Component
public class UtilMsg {

    /**
     * 返回数据的头部，用来指示返回数据的类型
     */
    private  String header;

    /**
     * 返回数据
     */
    private  Object data;

    /**
     * @name MakeMsgToJsonString 得到msg的json字符串
     * @param
     * @return java.lang.String
     */
    public  String MakeMsgToJsonString(){
        String strMsg = JSON.toJSONString(this);
        return strMsg;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
