package edu.nf.ch05.test;

import edu.nf.ch05.dao.UserDao;
import edu.nf.ch05.dao.impl.UserDaoImpl;
import edu.nf.ch05.entity.Users;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void testFindByCondition1(){
        UserDao dao = new UserDaoImpl();
        Users user = dao.findUserByCondition1("wangl", "123456789");
        System.out.println(user.getUserName());
        System.out.println(user.getTel());
    }

    @Test
    public void testFindByCondition2(){
        UserDao dao = new UserDaoImpl();
        //将查询参数封装到map中
        Map<String, Object> map = new HashMap<>();
        map.put("userName", "wangl");
        map.put("tel", "123456789");
        Users user = dao.findUserByCondition2(map);
        System.out.println(user.getUserName());
        System.out.println(user.getTel());
    }

    @Test
    public void testFindUserByCondition3(){
        UserDao dao = new UserDaoImpl();
        //将查询参数封装到实体对象中
        Users user = new Users();
        user.setUserName("wangl");
        user.setTel("123456789");
        user = dao.findUserByCondition3(user);
        System.out.println(user.getUid());
        System.out.println(user.getUserName());
        System.out.println(user.getTel());
    }

    @Test
    public void testFindUsers(){
        UserDao dao = new UserDaoImpl();
        List<Users> list = dao.findUsers("123");
        for (Users user : list) {
            System.out.println(user.getTel());
        }
    }
}
