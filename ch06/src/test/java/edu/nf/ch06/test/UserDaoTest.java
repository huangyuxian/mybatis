package edu.nf.ch06.test;

import edu.nf.ch06.dao.UserDao;
import edu.nf.ch06.dao.impl.UserDaoImpl;
import edu.nf.ch06.entity.Users;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void testFindByCondition1(){
        UserDao dao = new UserDaoImpl();
        //封装查询参数
        Map<String, Object> map = new HashMap<>();
        //map.put("uname", "wangl");
        map.put("tel", "13570566657");
        Users user = dao.findByCondition1(map);
        System.out.println(user.getUid());
        System.out.println(user.getUserName());
        System.out.println(user.getTel());
    }

    @Test
    public void testFindByCondition2(){
        UserDao dao = new UserDaoImpl();
        //封装查询参数
        Map<String, Object> map = new HashMap<>();
        //map.put("uname", "wangl");
        map.put("tel", "13570566657");
        Users user = dao.findByCondition2(map);
        System.out.println(user.getUid());
        System.out.println(user.getUserName());
        System.out.println(user.getTel());
    }

    @Test
    public void testFindByCondition3(){
        UserDao dao = new UserDaoImpl();
        //封装查询参数
        Map<String, Object> map = new HashMap<>();
        List<String> telList = new ArrayList<>();
        telList.add("12345678911");
        telList.add("13570566657");
        telList.add("12356789022");
        map.put("telList", telList);
        Users user = dao.findByCondition3(map);
        System.out.println(user.getUid());
        System.out.println(user.getUserName());
        System.out.println(user.getTel());
    }

    @Test
    public void testFindByCondition4(){
        UserDao dao = new UserDaoImpl();
        //封装查询参数
        Map<String, Object> map = new HashMap<>();
        List<String> telList = new ArrayList<>();
        telList.add("12345678911");
        telList.add("13570566657");
        telList.add("12356789022");
        map.put("telList", telList);
        Users user = dao.findByCondition4(map);
        System.out.println(user.getUid());
        System.out.println(user.getUserName());
        System.out.println(user.getTel());
    }

    @Test
    public void testUpdateUser(){
        UserDao dao = new UserDaoImpl();
        Users user = new Users();
        user.setUid("297e989d61f0112f0161f01131810000");
        user.setTel("11111111111");
        dao.updateUser(user);
    }
}
