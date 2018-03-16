package edu.nf.ch02.dao;

import edu.nf.ch02.entity.Users;

import java.util.List;

public interface UserDao {

    /**
     * 添加用户
     * @param user
     */
    void saveUser(Users user);

}
