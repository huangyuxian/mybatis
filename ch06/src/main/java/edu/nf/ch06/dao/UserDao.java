package edu.nf.ch06.dao;

import edu.nf.ch06.entity.Users;

import java.util.Map;

/**
 * 动态条件查询
 */
public interface UserDao {

    Users findByCondition1(Map<String, Object> map);

    Users findByCondition2(Map<String, Object> map);

    Users findByCondition3(Map<String, Object> map);

    Users findByCondition4(Map<String, Object> map);

    void updateUser(Users user);
}
