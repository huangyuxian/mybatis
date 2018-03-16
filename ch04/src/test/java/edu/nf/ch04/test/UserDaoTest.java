package edu.nf.ch04.test;

import edu.nf.ch04.dao.UserDao;
import edu.nf.ch04.dao.impl.UserDaoImpl;
import edu.nf.ch04.entity.Users;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void testFindUserById(){
        UserDao dao = new UserDaoImpl();
        Users user = dao.findUserById("297e989d61f0112f0161f01131810000");
        System.out.println(user.getUserName());
    }

    @Test
    public void testFindUsers(){
        UserDao dao = new UserDaoImpl();
        List<Users> list = dao.findUsers();
        for (Users user : list) {
            System.out.println(user.getUserName());
        }
    }
}
