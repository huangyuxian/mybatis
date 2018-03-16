package edu.nf.ch07.dao;

import edu.nf.ch07.entity.Users;

public interface UserDao {

    /**
     * 根据ID查询用户信息
     * @param uid
     * @return
     */
    Users findUserById(int uid);
}
