package edu.nf.ch09.dao.impl;

import edu.nf.ch09.dao.UserDao;
import edu.nf.ch09.entity.Users;
import edu.nf.ch09.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;

public class UserDaoImpl implements UserDao{

    @Override
    public Users findUserById(int uid) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Users user = null;
        try {
            user = sqlSession.getMapper(UserDao.class).findUserById(uid);
        } finally {
            sqlSession.close();
        }
        return user;
    }

    @Override
    public Users findUserById2(int uid) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Users user = null;
        try {
            user = sqlSession.getMapper(UserDao.class).findUserById2(uid);
        } finally {
            sqlSession.close();
        }
        return user;
    }

    @Override
    public Users findUserById3(int uid) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Users user = null;
        try {
            user = sqlSession.getMapper(UserDao.class).findUserById3(uid);
        } finally {
            sqlSession.close();
        }
        return user;
    }

    @Override
    public Users findUserById4(int uid) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Users user = null;
        try {
            user = sqlSession.getMapper(UserDao.class).findUserById4(uid);
        } finally {
            sqlSession.close();
        }
        return user;
    }

    @Override
    public Users findUser(String userName, String tel) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Users user = null;
        try {
            user = sqlSession.getMapper(UserDao.class).findUser(userName, tel);
        } finally {
            sqlSession.close();
        }
        return user;
    }

    @Override
    public Users findUser2(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Users user = null;
        try {
            user = sqlSession.getMapper(UserDao.class).findUser2(map);
        } finally {
            sqlSession.close();
        }
        return user;
    }

    @Override
    public Users findUser3(Users user) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            user = sqlSession.getMapper(UserDao.class).findUser3(user);
        } finally {
            sqlSession.close();
        }
        return user;
    }
}
