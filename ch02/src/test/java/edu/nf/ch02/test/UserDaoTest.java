package edu.nf.ch02.test;

import edu.nf.ch02.dao.UserDao;
import edu.nf.ch02.dao.impl.UserDaoImpl;
import edu.nf.ch02.entity.Users;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void testSaveUser(){
        Users user = new Users();
        user.setTel("12345678");
        user.setUserName("ooooo");
        UserDao dao = new UserDaoImpl();
        dao.saveUser(user);
    }

    @Test
    public void testFindUsers(){
        UserDao dao = new UserDaoImpl();
        List<Users> list = dao.findUsers();
        for (Users u : list) {
            System.out.println(u.getUserName());
        }
    }
}
