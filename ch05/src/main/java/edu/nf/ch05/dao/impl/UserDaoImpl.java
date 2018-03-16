package edu.nf.ch05.dao.impl;

import edu.nf.ch05.dao.UserDao;
import edu.nf.ch05.entity.Users;
import edu.nf.ch05.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao{

    @Override
    public Users findUserByCondition1(String userName, String tel) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Users user = null;
        try {
            user = sqlSession.getMapper(UserDao.class).findUserByCondition1(userName, tel);
        } finally {
            sqlSession.close();
        }
        return user;
    }

    @Override
    public Users findUserByCondition2(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Users user = null;
        try {
            user = sqlSession.getMapper(UserDao.class).findUserByCondition2(map);
        } finally {
            sqlSession.close();
        }
        return user;
    }

    @Override
    public Users findUserByCondition3(Users user) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            user = sqlSession.getMapper(UserDao.class).findUserByCondition3(user);
        } finally {
            sqlSession.close();
        }
        return user;
    }

    @Override
    public List<Users> findUsers(String tel) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        List<Users> list = null;
        try {
            list = sqlSession.getMapper(UserDao.class).findUsers(tel);
        } finally {
            sqlSession.close();
        }
        return list;
    }
}
