package edu.nf.ch07.dao.impl;

import edu.nf.ch07.dao.UserDao;
import edu.nf.ch07.entity.Users;
import edu.nf.ch07.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

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
}
