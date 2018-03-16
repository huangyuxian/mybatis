package edu.nf.ch10.dao.impl;

import edu.nf.ch10.dao.UserDao;
import edu.nf.ch10.entity.Users;
import edu.nf.ch10.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;

public class UserDaoimpl implements UserDao {
    @Override
    public void saveUser(Users u) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            sqlSession.getMapper(UserDao.class).saveUser(u);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

    }

    @Override
    public void updateUser(Users u) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            sqlSession.getMapper(UserDao.class).updateUser(u);
        }  catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteUser(String uid) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            sqlSession.getMapper(UserDao.class).deleteUser(uid);
        }  catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public Users findUserById(String uid) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            return sqlSession.getMapper(UserDao.class).findUserById(uid);
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public Users findUserByCondition(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        try {
            return sqlSession.getMapper(UserDao.class).findUserByCondition(map);
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Users findUserByCondition2(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            return sqlSession.getMapper(UserDao.class).findUserByCondition2(map);
        } finally {
            sqlSession.close();
        }

    }
}
