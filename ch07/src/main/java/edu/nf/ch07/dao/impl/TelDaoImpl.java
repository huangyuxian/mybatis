package edu.nf.ch07.dao.impl;

import edu.nf.ch07.dao.TelDao;
import edu.nf.ch07.entity.Tel;
import edu.nf.ch07.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class TelDaoImpl implements TelDao{

    @Override
    public Tel findTelByTelNumber(String tel) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Tel t = null;
        try {
            t = sqlSession.getMapper(TelDao.class).findTelByTelNumber(tel);
        } finally {
            sqlSession.close();
        }
        return t;
    }
}
