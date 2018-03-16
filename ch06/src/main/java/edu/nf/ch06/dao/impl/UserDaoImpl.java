package edu.nf.ch06.dao.impl;

import edu.nf.ch06.dao.UserDao;
import edu.nf.ch06.entity.Users;
import edu.nf.ch06.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;

public class UserDaoImpl implements UserDao {

    @Override
    public Users findByCondition1(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Users user = null;
        try {
            user = sqlSession.getMapper(UserDao.class).findByCondition1(map);
        } finally {
            sqlSession.close();
        }
        return user;
    }

    @Override
    public Users findByCondition2(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Users user = null;
        try {
            user = sqlSession.getMapper(UserDao.class).findByCondition2(map);
        } finally {
            sqlSession.close();
        }
        return user;
    }

    @Override
    public Users findByCondition3(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Users user = null;
        try {
            user = sqlSession.getMapper(UserDao.class).findByCondition3(map);
        } finally {
            sqlSession.close();
        }
        return user;
    }

    @Override
    public Users findByCondition4(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Users user = null;
        try {
            user = sqlSession.getMapper(UserDao.class).findByCondition4(map);
        } finally {
            sqlSession.close();
        }
        return user;
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
}
