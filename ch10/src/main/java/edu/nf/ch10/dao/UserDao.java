package edu.nf.ch10.dao;

import edu.nf.ch10.dao.provider.UserDaoProvider;
import edu.nf.ch10.entity.Users;
import org.apache.ibatis.annotations.*;

import java.util.Map;

/**
 * 使用Provider实现动态sql
 */
public interface UserDao {
    /**
     * 添加用户
     * 使用@InsertProvider注解，type指定自定义的Provider的class,method指定要调用Provider中的那个方法
      * @param u
     */
    @InsertProvider(type = UserDaoProvider.class,method = "saveUser")
    void saveUser(Users u);

    /**
     * 修改用户
     * @param u
     */
    @UpdateProvider(type = UserDaoProvider.class,method = "updateUser")
    void updateUser(Users u);

    /**
     * 删除用户
     * @param uid
     */
    @DeleteProvider(type = UserDaoProvider.class,method = "deleteUser")
    void deleteUser(String uid);

    /**
     * 根据ID查询用户
     * @param uid
     * @return
     */
    @SelectProvider(type = UserDaoProvider.class,method = "findUserById")
    Users findUserById(String uid);

    /**
     * 多条件查询
     * @param map
     * @return
     */
    @SelectProvider(type = UserDaoProvider.class,method = "findByCondition")
    @ResultMap("edu.nf.ch10.dao.UserDao.userMap")
    Users findUserByCondition(Map<String,Object> map);

    /**
     * 动态条件查询
     * @param map
     * @return
     */
    @SelectProvider( type = UserDaoProvider.class,method = "findByCondition2")
    @ResultMap("edu.nf.ch10.dao.UserDao.userMap")
    Users findUserByCondition2(Map<String,Object> map);

}
