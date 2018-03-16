package edu.nf.ch07.test;

import edu.nf.ch07.dao.UserDao;
import edu.nf.ch07.dao.impl.UserDaoImpl;
import edu.nf.ch07.entity.Address;
import edu.nf.ch07.entity.Tel;
import edu.nf.ch07.entity.Users;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testFindUserById(){
        UserDao dao = new UserDaoImpl();
        Users user = dao.findUserById(1);
        System.out.println(user.getUserName());
        System.out.println(user.getCard().getCardNumber());
        for (Tel tel : user.getTels()) {
            System.out.println(tel.getTelNumber());
        }
        for (Address addr :user.getAddresses()) {
            System.out.println(addr.getAddress());
        }
    }
}
