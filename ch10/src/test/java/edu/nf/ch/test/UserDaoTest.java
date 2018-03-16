package edu.nf.ch.test;

import edu.nf.ch10.dao.UserDao;
import edu.nf.ch10.dao.impl.UserDaoimpl;
import edu.nf.ch10.entity.Users;
import edu.nf.ch10.utils.UUIDUtil;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void testSaveUser(){
        UserDao dao = new UserDaoimpl();
        Users u = new Users();
        u.setUid(UUIDUtil.createUUID());
        u.setTel("13169618305");
        u.setUserName("黄钰祥");
        dao.saveUser(u);
    }

    @Test
    public void testUpdateUser(){
        UserDao dao = new UserDaoimpl();
        Users u = new Users();
        u.setUid("ba5f5d64acf84f2");
        u.setTel("131696818305");
        u.setUserName("HUANGYUXIANG");
        dao.updateUser(u);
    }
    @Test
    public void testDeleteUser(){
        UserDao dao = new UserDaoimpl();
        dao.deleteUser("82ee05ca-27ed-11e8-8528-34880eac3506");
    }

    @Test
    public void testFindUserById(){
        UserDao dao = new UserDaoimpl();
        Users u = dao.findUserById("9aaa97733fb64f2ca63bd2f9b263b4e1");
        System.out.println(u.getUserName());
        System.out.println(u.getTel());
    }
    @Test
    public void testFindByCondition(){
        UserDao dao = new UserDaoimpl();
        Map<String,Object> map = new HashMap<>();
        map.put("name","黄钰祥");
        map.put("tel","13169618305");
        Users u = dao.findUserByCondition(map);
        System.out.println(u.getUid());
        System.out.println(u.getTel());
        System.out.println(u.getUserName());
    }
    @Test
    public void testFindByCondition2(){
        UserDao dao = new UserDaoimpl();
        Map<String,Object> map = new HashMap<>();
        //map.put("id","9aaa97733fb64f2ca63bd2f9b263b4e1");
        //map.put("name","黄钰祥");
        map.put("tel","13169618305");
        Users u = dao.findUserByCondition2(map);
        System.out.println(u.getUid());
        System.out.println(u.getTel());
        System.out.println(u.getUserName());
    }

}
