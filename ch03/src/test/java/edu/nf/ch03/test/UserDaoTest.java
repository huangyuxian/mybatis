package edu.nf.ch03.test;

import edu.nf.ch03.dao.UserDao;
import edu.nf.ch03.dao.impl.UserDaoImpl;
import edu.nf.ch03.entity.Users;
import org.junit.Test;

import java.util.List;
import java.util.Map;

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

    @Test
    public void testCountUser(){
        UserDao dao = new UserDaoImpl();
        int count = dao.countUser();
        System.out.println(count);
    }

    @Test
    public void testFindUserByIdToMap(){
        UserDao dao = new UserDaoImpl();
        Map<String, Object> map = dao.findUserByIdToMap("297e989d61f0112f0161f01131810000");
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }

    @Test
    public void testFindUsersToMap(){
        UserDao dao = new UserDaoImpl();
        List<Map<String, Object>> list = dao.findUsersToMap();
        for (Map<String, Object> map : list) {
            for (String key : map.keySet()) {
                System.out.println(key + " : " +map.get(key));
            }
            System.out.println();
        }
    }
}
