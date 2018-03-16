package edu.nf.ch01.dao.impl;

import edu.nf.ch01.dao.UserDao;
import edu.nf.ch01.entity.Users;
import edu.nf.ch01.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;

public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser(Users user) {
        //获取SqlSession
        SqlSession session = MybatisUtil.getSqlSession();
        try {
            //执行保存操作
            session.getMapper(UserDao.class).saveUser(user);
        }catch(RuntimeException e){
            e.printStackTrace();
            //事务回滚
            session.rollback();
        }finally{
            //关闭session
            session.close();
        }
    }

    @Override
    public void saveUser2(Map<String, Object> params) {
        SqlSession session = MybatisUtil.getSqlSession();
        try {
            session.getMapper(UserDao.class).saveUser2(params);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateUser(Users user) {
        SqlSession session = MybatisUtil.getSqlSession();
        try {
            session.getMapper(UserDao.class).updateUser(user);
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteUser(String uid) {
        SqlSession session = MybatisUtil.getSqlSession();
        try {
            session.getMapper(UserDao.class).deleteUser(uid);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }
}
