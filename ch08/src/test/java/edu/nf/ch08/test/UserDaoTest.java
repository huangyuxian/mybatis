package edu.nf.ch08.test;

import edu.nf.ch08.dao.UserDao;
import edu.nf.ch08.dao.impl.UserDaoImpl;
import edu.nf.ch08.entity.Users;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testSaveUser(){
        Users user = new Users();
        user.setUserName("boy");
        user.setTel("1312356789");
        UserDao dao = new UserDaoImpl();
        dao.saveUser(user);
    }

    @Test
    public void testUpdateUser(){
        Users user = new Users();
        user.setUid("297e62e561f525710161f52575320000");
        user.setUserName("lisi");
        user.setTel("13100000000");
        UserDao dao = new UserDaoImpl();
        dao.updateUser(user);
    }

    @Test
    public void testDeleteUser(){
        UserDao dao = new UserDaoImpl();
        dao.deleteUser("297e62e561f525710161f52575320000");
    }
}
