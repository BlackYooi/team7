package com.example.demo.Service;

import com.example.demo.Bean.Blacklist;
import com.example.demo.Bean.Contace;
import com.example.demo.Bean.User;
import com.example.demo.Util.UUIDGenerator;
import com.example.demo.Util.UtilSession;
import com.example.demo.mapper.ContaceMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 通讯录管理
 */
@Service
public class ContaceService {

    @Autowired
    ContaceMapper contaceMapper;
    @Autowired
    UserService userService;
    @Autowired
    BlacklistService blacklistService;

    public List<Contace> findByContace(Contace contace){
        return contaceMapper.findByContace(contace);
    }

    /**
     * @name addContace 添加通讯录
     * @param session
     * @param name 被添加好友的名字
     * @return int
     */
    public int addContace(HttpSession session,String name){
        User u = (User)session.getAttribute(UtilSession.USER_SESSION_KEY);
        Contace contace = new Contace();
        contace.setUser1(u.getName());
        contace.setUser2(name);
        contace.setId(UUIDGenerator.get());
        return contaceMapper.addContace(contace);
    }

    public int addContace(Contace contace){
        contace.setId(UUIDGenerator.get());
        return contaceMapper.addContace(contace);
    }

    /**
     * @name deleteContace 删除好友
     * @param session
     * @param name 被删除好友的名字
     * @return int
     */
    public int deleteContace(HttpSession session,String name){
        User u = (User)session.getAttribute(UtilSession.USER_SESSION_KEY);
        Contace contace = new Contace();
        contace.setUser1(u.getName());
        contace.setUser2(name);
        return contaceMapper.deleteContace(contace);
    }

    /**
     * @name findMyselfCont 查询自己的通讯录
     * @param session
     * @return java.util.List<com.example.demo.Bean.Contace>
     */
    public List<User> findMyselfCont(HttpSession session){
        User u = (User)session.getAttribute(UtilSession.USER_SESSION_KEY);
        if( u == null){
            return null;
        }
        Contace contace = new Contace();
        contace.setUser1(u.getName());
        //查找出自己有哪些好友
        List<Contace> contaces = contaceMapper.findByContace(contace);
        //通过好友名字查询出好友信息
        List<User> list = new ArrayList<User>();
        User user = new User();
        contaces.forEach(item->{
            user.setName(item.getUser2());
            //通过名字只能查出一个用户，前提：用户名唯一，但是用户名唯一的验证模块我们没做
            list.add(userService.findByUser(user).get(0));
        });
        return list;
    }

    @Autowired
    Blacklist blacklist;
    @Autowired
    Contace contace;
    /**
     * @name joinToBlackList 加入黑名单那
     * @param session
     * @param name 被加者的名字
     * @return int
     */
    public int joinToBlackList(HttpSession session,String name){
        User u = (User)session.getAttribute(UtilSession.USER_SESSION_KEY);
        if( u == null){
            return 0;
        }
        blacklist.setAdd_user(u.getName());
        blacklist.setBlack_user(name);
        //通讯录先删除
        contace.setUser1(u.getName());
        contace.setUser2(name);
        contaceMapper.deleteContace(contace);
        //加入黑名单并返回
        return blacklistService.addBlackList(blacklist);
    }
}
