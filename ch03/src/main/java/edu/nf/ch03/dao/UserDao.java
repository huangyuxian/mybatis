package edu.nf.ch03.dao;

import edu.nf.ch03.entity.Users;

import java.util.List;
import java.util.Map;

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

    /**
     * 统计用户总人数
     * @return
     */
    int countUser();

    /**
     * 根据id查询用户信息，并封装成map对象
     * @param uid
     * @return
     */
    Map<String, Object> findUserByIdToMap(String uid);

    /**
     * 查询所有用户，并封装成Map的List集合,每一个Map对应一条记录
     * @return
     */
    List<Map<String, Object>> findUsersToMap();
}
