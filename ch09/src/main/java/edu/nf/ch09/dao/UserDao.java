package edu.nf.ch09.dao;

import edu.nf.ch09.entity.Users;
import org.apache.ibatis.annotations.*;

import java.util.Map;

public interface UserDao {

    /**
     * 根据ID查询用户信息,以映射别名的方式封装结果集
     * AS关键字后的别名对应实体中的字段名
     * @param uid
     * @return
     */
    @Select("SELECT U_ID AS uid, U_NAME AS userName FROM USER_INFO WHERE U_ID = #{uid}")
    Users findUserById(int uid);

    /**
     * 使用@Results注解来映射结果集,
     * 在这个注解中使用多个@Result来映射每一个字段和表的列
     * @param uid
     * @return
     */
    @Select("SELECT * FROM USER_INFO WHERE U_ID = #{uid}")
    @Results({
       @Result(property = "uid", column = "u_id"),
       @Result(property = "userName", column = "U_NAME")
    })
    Users findUserById2(int uid);

    /**
     * 使用@ResultMap来映射结果集，结合xml来配置resultMap
     * @param uid
     * @return
     */
    @Select("SELECT * FROM USER_INFO WHERE U_ID = #{uid}")
    //@ResultMap的value对应的是xml中namespace的值加上resultMap的id
    @ResultMap("edu.nf.ch09.dao.UserDao.userMap")
    Users findUserById3(int uid);

    /**
     * 关联查询，使用@ResultMap指定映射配置
     * @param uid
     * @return
     */
    @Select("SELECT * FROM USER_INFO U INNER JOIN CARD_INFO C ON C.U_ID = U.U_ID " +
            "INNER JOIN TEL_INFO T ON T.U_ID = U.U_ID WHERE U.U_ID = #{uid}")
    @ResultMap("edu.nf.ch09.dao.UserDao.userMap")
    Users findUserById4(int uid);

    /**
     * 使用@Param注解映射多个查询参数,value属性对应#{}中的名称
     * @param userName
     * @param tel
     * @return
     */
    @Select("SELECT * FROM USER_INFO U INNER JOIN CARD_INFO C ON C.U_ID = U.U_ID " +
            "INNER JOIN TEL_INFO T ON T.U_ID = U.U_ID WHERE U.U_NAME = #{uname} AND T.T_NUMBER = #{telNumber}")
    @ResultMap("edu.nf.ch09.dao.UserDao.userMap")
    Users findUser(@Param("uname") String userName, @Param("telNumber")String tel);

    /**
     * 将多个查询参数封装成map对象,#{}中的名称对应map的key
     * @param map
     * @return
     */
    @Select("SELECT * FROM USER_INFO U INNER JOIN CARD_INFO C ON C.U_ID = U.U_ID " +
            "INNER JOIN TEL_INFO T ON T.U_ID = U.U_ID WHERE U.U_NAME = #{userName} AND T.T_NUMBER = #{telNumber}")
    @ResultMap("edu.nf.ch09.dao.UserDao.userMap")
    Users findUser2(Map<String, Object> map);

    /**
     * 将多个查询参数封装成实体对象，#{}中的名称对用实体的字段名
     * @param user
     * @return
     */
    @Select("SELECT * FROM USER_INFO U INNER JOIN CARD_INFO C ON C.U_ID = U.U_ID " +
            "INNER JOIN TEL_INFO T ON T.U_ID = U.U_ID WHERE U.U_NAME = #{userName} AND C.C_NUMBER = #{card.cardNumber}")
    @ResultMap("edu.nf.ch09.dao.UserDao.userMap")
    Users findUser3(Users user);
}
