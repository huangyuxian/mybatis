package edu.nf.ch02.dao.impl;

import edu.nf.ch02.dao.UserDao;
import edu.nf.ch02.entity.Users;
import edu.nf.ch02.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser(Users user) {
        SqlSession session = MybatisUtil.getSqlSession();
        try {
            session.getMapper(UserDao.class).saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }

}
