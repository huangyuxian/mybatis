package edu.nf.ch08.dao;

import edu.nf.ch08.entity.Users;
import org.apache.ibatis.annotations.*;

import javax.annotation.Generated;

public interface UserDao {

    /**
     * 添加用户
     * @param user
     */
    @Insert("INSERT INTO USER_INFO(U_ID,U_TEL,U_NAME) VALUES(#{uid}, #{tel}, #{userName})")
    /*主键生成策略
        1. 使用@Options来实现自增长，将useGeneratedKey设置为true，表示启用自增长
           keyProperty指定实体中的id主键字段
        @Options(useGeneratedKeys = true, keyProperty = "uid")

        2. 使用@SelectKey注解来实现Sequence或UUID的主键生成策略,
           keyProperty指定实体中的id主键字段, resultType指定生成主键的类型,
           statement指定执行数据库的主键生成函数语句，before设置为true
           表示在执行SQL之前生成主键
    */
    @SelectKey(keyProperty = "uid", before = true,
            resultType = String.class, statement = "SELECT UUID() FROM DUAL")
    void saveUser(Users user);

    /**
     * 更新用户
     * @param user
     */
    @Update("UPDATE USER_INFO SET U_NAME = #{userName}, U_TEL = #{tel} WHERE U_ID = #{uid}")
    void updateUser(Users user);

    /**
     * 删除用户
     * @param uid
     */
    @Delete("DELETE FROM USER_INFO WHERE U_ID = #{uid}")
    void deleteUser(String uid);
}
