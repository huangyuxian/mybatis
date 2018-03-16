package edu.nf.ch01.test;

import edu.nf.ch01.dao.UserDao;
import edu.nf.ch01.dao.impl.UserDaoImpl;
import edu.nf.ch01.entity.Users;
import edu.nf.ch01.utils.UUIDUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void testSaveUser(){
        Users user = new Users();
        user.setUid(UUIDUtil.createUUID());
        user.setUserName("coco");
        user.setTel("123456789");
        UserDao dao = new UserDaoImpl();
        dao.saveUser(user);
    }

    @Test
    public void testSaveUser2(){
        Map<String, Object> params = new HashMap<>();
        params.put("uid", UUIDUtil.createUUID());
        params.put("tel", "12345678");
        params.put("uname", "lucy");
        UserDao dao = new UserDaoImpl();
        dao.saveUser2(params);
    }

    @Test
    public void testUpdateUser(){
        Users user = new Users();
        user.setUid("9d65f2951cef4e90b9786e03e36eab6f");
        user.setUserName("lili");
        UserDao dao = new UserDaoImpl();
        dao.updateUser(user);
    }

    @Test
    public void testDeleteUser(){
        UserDao dao = new UserDaoImpl();
        dao.deleteUser("005d472d-f15e-4d7f-8a4e-360cc9374ee9");
    }
}
