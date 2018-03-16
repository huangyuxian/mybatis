package edu.nf.ch04.dao;

import edu.nf.ch04.entity.Users;

import java.util.List;

public interface UserDao {

    /**
     * 根据ID查询用户信息
     * @param uid
     * @return
     */
    Users findUserById(String uid);

    /**
     * 查询用户列表
     * @return
     */
    List<Users> findUsers();
}
