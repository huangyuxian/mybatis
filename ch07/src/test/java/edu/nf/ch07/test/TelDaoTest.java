package edu.nf.ch07.test;

import edu.nf.ch07.dao.TelDao;
import edu.nf.ch07.dao.impl.TelDaoImpl;
import edu.nf.ch07.entity.Tel;
import org.junit.Test;

public class TelDaoTest {

    @Test
    public void testFindTelByTelNumber(){
        TelDao dao = new TelDaoImpl();
        Tel tel = dao.findTelByTelNumber("13033090878");
        System.out.println(tel.getTelNumber());
        System.out.println(tel.getUser().getUserName());
    }
}
