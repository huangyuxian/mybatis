package edu.nf.ch09.test;

import edu.nf.ch09.dao.UserDao;
import edu.nf.ch09.dao.impl.UserDaoImpl;
import edu.nf.ch09.entity.IdCard;
import edu.nf.ch09.entity.Tel;
import edu.nf.ch09.entity.Users;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void testFindUserById(){
        UserDao dao = new UserDaoImpl();
        Users user = dao.findUserById(1);
        System.out.println(user.getUid());
        System.out.println(user.getUserName());
    }

    @Test
    public void testFindUserById2(){
        UserDao dao = new UserDaoImpl();
        Users user = dao.findUserById2(1);
        System.out.println(user.getUid());
        System.out.println(user.getUserName());
    }

    @Test
    public void testFindUserById3(){
        UserDao dao = new UserDaoImpl();
        Users user = dao.findUserById3(1);
        System.out.println(user.getUid());
        System.out.println(user.getUserName());
    }

    @Test
    public void testFindUserById4(){
        UserDao dao = new UserDaoImpl();
        Users user = dao.findUserById4(1);
        System.out.println(user.getUid());
        System.out.println(user.getUserName());
        System.out.println(user.getCard().getCardNumber());
        for (Tel tel : user.getTels()) {
            System.out.println(tel.getTelNumber());
        }
    }

    @Test
    public void testFindUser(){
        UserDao dao = new UserDaoImpl();
        Users user = dao.findUser("张三","13033090878");
        System.out.println(user.getUserName());
        System.out.println(user.getCard().getCardNumber());
    }

    @Test
    public void testFindUser2(){
        UserDao dao = new UserDaoImpl();
        Map<String, Object> map = new HashMap<>();
        map.put("userName", "张三");
        map.put("telNumber", "13169618305");
        Users user = dao.findUser2(map);
        System.out.println(user.getUserName());
        System.out.println(user.getCard().getCardNumber());
    }

    @Test
    public void testFindUser3(){
        UserDao dao = new UserDaoImpl();
        Users user = new Users();
        user.setUserName("张三");
        IdCard card = new IdCard();
        card.setCardNumber("440902198505500098");
        user.setCard(card);
        user = dao.findUser3(user);
        System.out.println(user.getUserName());
        System.out.println(user.getCard().getCardNumber());
        for (Tel tel : user.getTels()) {
            System.out.println(tel.getTelNumber());
        }
    }
}
