package edu.nf.ch11.dao.impl;

import edu.nf.ch11.dao.UserDao;
import edu.nf.ch11.entity.Users;
import edu.nf.ch11.utils.MybatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<Users> findUsers(RowBounds rowBounds) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        List<Users> list = null;
        try {
            list = sqlSession.getMapper(UserDao.class).findUsers(rowBounds);
        } finally {
            sqlSession.close();
        }
        return list;
    }

    @Override
    public List<Users> findUser2() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        List<Users> list = null;
        try {
            list = sqlSession.getMapper(UserDao.class).findUser2();
        } finally {
            sqlSession.close();
        }
        return list;
    }
}
