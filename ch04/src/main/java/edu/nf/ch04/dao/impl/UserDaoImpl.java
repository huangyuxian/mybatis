package edu.nf.ch04.dao.impl;

import edu.nf.ch04.dao.UserDao;
import edu.nf.ch04.entity.Users;
import edu.nf.ch04.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

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
}
