package edu.nf.ch01.dao;

import edu.nf.ch01.entity.Users;

import java.util.Map;

public interface UserDao {

    /**
     * 添加用户
     * @param user
     */
    void saveUser(Users user);


    void saveUser2(Map<String, Object> params);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(Users user);

    /**
     * 删除用户
     * @param uid
     */
    void deleteUser(String uid);
}
