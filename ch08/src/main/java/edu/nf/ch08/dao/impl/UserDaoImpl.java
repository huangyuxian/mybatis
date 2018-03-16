package edu.nf.ch08.dao.impl;

import edu.nf.ch08.dao.UserDao;
import edu.nf.ch08.entity.Users;
import edu.nf.ch08.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser(Users user) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            sqlSession.getMapper(UserDao.class).saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateUser(Users user) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            sqlSession.getMapper(UserDao.class).updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteUser(String uid) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            sqlSession.getMapper(UserDao.class).deleteUser(uid);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
