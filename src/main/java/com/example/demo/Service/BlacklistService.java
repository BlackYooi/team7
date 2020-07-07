package com.example.demo.Service;

import com.example.demo.Bean.Blacklist;
import com.example.demo.Bean.Contace;
import com.example.demo.Bean.User;
import com.example.demo.Util.UUIDGenerator;
import com.example.demo.Util.UtilSession;
import com.example.demo.mapper.BlacklistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 黑名单管理
 */
@Service
public class BlacklistService {

    @Autowired
    BlacklistMapper blacklistMapper;
    @Autowired
    Blacklist blacklist;
    @Autowired
    UserService userService;
    @Autowired
    User user;
    @Autowired
    Contace contace;
    @Autowired
    ContaceService contaceService;

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

    /**
     * @name findMyself 查询自己的通讯录黑名单
     * @param session
     * @return java.util.List<com.example.demo.Bean.Contace>
     */
    public List<User> findMyself(HttpSession session){
        User u = (User)session.getAttribute(UtilSession.USER_SESSION_KEY);
        if( u == null){
            return null;
        }
        blacklist.setAdd_user(u.getName());
        //查找出自己有哪些黑名单用户
        List<Blacklist> byBlacklist = blacklistMapper.findByBlacklist(blacklist);
        //通过好友名字查询出好友信息
        List<User> list = new ArrayList<User>();
        byBlacklist.forEach(item->{
            user.setName(item.getBlack_user());
            //通过名字只能查出一个用户，前提：用户名唯一，但是用户名唯一的验证模块我们没做
            list.add(userService.findByUser(user).get(0));
        });
        return list;
    }

    /**
     * @name deleteBlack 删除黑名单用户
     * @param session
     * @param black_name
     * @return int
     */
    public int deleteBlack(HttpSession session, String black_name){
        User u = (User)session.getAttribute(UtilSession.USER_SESSION_KEY);
        if( u == null){
            return 0;
        }
        blacklist.setAdd_user(u.getName());
        blacklist.setBlack_user(black_name);
        return blacklistMapper.deleteBlackList(blacklist);
    }

    /**
     * @name backToCont 撤销拉黑操作
     * @param session
     * @param black_name
     * @return int
     */
    public int backToCont(HttpSession session, String black_name){
        User u = (User)session.getAttribute(UtilSession.USER_SESSION_KEY);
        if( u == null){
            return 0;
        }
        blacklist.setAdd_user(u.getName());
        blacklist.setBlack_user(black_name);
        //通讯录添加
        contace.setUser1(u.getName());
        contace.setUser2(black_name);
        int i = contaceService.addContace(contace);
        //返回操作结果
        int i1 = blacklistMapper.deleteBlackList(blacklist);
        if(i > 0 && i1 > 0){
            return 1;
        }
        else {
            return 0;
        }
    }

}
