package edu.nf.ch03.dao.impl;

import edu.nf.ch03.dao.UserDao;
import edu.nf.ch03.entity.Users;
import edu.nf.ch03.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao{

    @Override
    public Users findUserById(String uid) {
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
    public List<Users> findUsers() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        List<Users> list = null;
        try {
            list = sqlSession.getMapper(UserDao.class).findUsers();
        } finally {
            sqlSession.close();
        }
        return list;
    }

    @Override
    public int countUser() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        int count = 0;
        try {
            count = sqlSession.getMapper(UserDao.class).countUser();
        } finally {
            sqlSession.close();
        }
        return count;
    }

    @Override
    public Map<String, Object> findUserByIdToMap(String uid) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Map<String, Object> map = null;
        try {
            map = sqlSession.getMapper(UserDao.class).findUserByIdToMap(uid);
        } finally {
            sqlSession.close();
        }
        return map;
    }

    @Override
    public List<Map<String, Object>> findUsersToMap() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        List<Map<String, Object>> list = null;
        try {
            list = sqlSession.getMapper(UserDao.class).findUsersToMap();
        } finally {
            sqlSession.close();
        }
        return list;
    }
}
