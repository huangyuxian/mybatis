package edu.nf.ch05.dao;

import edu.nf.ch05.entity.Users;

import java.util.List;
import java.util.Map;

public interface UserDao {

    /**
     * 多条件查询
     * @return
     */
    Users findUserByCondition1(String userName, String tel);

    /**
     * 多条件查询，使用map封装参数
     * @return
     */
    Users findUserByCondition2(Map<String, Object> map);

    /**
     * 多条件查询,使用实体对象封装参数
     * @param user
     * @return
     */
    Users findUserByCondition3(Users user);

    /**
     * 根据电话号码模糊查询
     * @param tel
     * @return
     */
    List<Users> findUsers(String tel);
}
