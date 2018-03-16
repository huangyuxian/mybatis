package edu.nf.ch10.dao.provider;

import com.sun.org.apache.regexp.internal.RE;
import edu.nf.ch10.entity.Users;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;

import javax.jws.soap.SOAPBinding;

import java.util.Map;

import static com.sun.org.apache.xerces.internal.util.Status.SET;

/**
 * Provider类中的方法都应该返回一个String类型
 * 因为返回的都是一个Sql语句的字符串
 * 方法中使用Sql语句构建器来动态构建Sql语句
 */
public class UserDaoProvider {
    //添加
    public String saveUser(Users user){
        return new SQL(){{
                INSERT_INTO("USER_INFO");
                VALUES("U_ID","#{uid}");
                VALUES("U_TEL","#{tel}");
                VALUES("U_NAME","#{userName}");
            }}.toString();
    }
    //修改
    public String updateUser(Users user){
        return new SQL(){{
            UPDATE("USER_INFO");
                if (user.getUserName() != null) {
                    SET("U_NAME=#{userName}");
                }if (user.getTel() != null) {
                    SET("U_TEL=#{tel}");
                }
                WHERE("U_ID=#{uid}");
            }}.toString();
    }

    public String deleteUser(String uid){
        return new SQL(){{
            DELETE_FROM("USER_INFO");
            WHERE("U_ID = #{uid}");
        }}.toString();
    }

    public String findUserById(){
        return new SQL(){{
            //可以使用一个SELECT方法查询多个列
            //SELECT("U_ID AS uid,U_TEL AS tel,U_NAME AS userName");
            //也可以使用多个SELECT方法查询不同的列
            SELECT("U_ID AS uid");
            SELECT("U_TEL AS tel");
            SELECT("U_NAME AS userName");
            FROM("USER_INFO");
            WHERE("U_ID=#{uid}");
        }}.toString();
    }
    /*//多条件查询有两种方法
    public String findByCondition(Map<String,Object> map ){
        return new SQL(){{
            SELECT("*");
            FROM("USER_INFO");
            WHERE("U_TEL = #{tel}");
            WHERE("U_NAME = #{uname}");
        }}.toString();
    }*/
    public String findByCondition(){
        return new SQL(){{
            SELECT("*");
            FROM("USER_INFO");
            if ("tel" != null){
                WHERE("U_TEL = #{tel}");
            }
            if ("name" != null){
                WHERE("U_NAME = #{name}");
            }
        }}.toString();
    }

    //动态条件查询
    public String findByCondition2(Map<String,Object> map){
        return new SQL(){
            {
                SELECT("*");
                FROM("USER_INFO");
                if(map.get("id") != null){
                    WHERE("U_ID = #{id}");
                }
                if(map.get("name") != null){
                    WHERE("U_NAME = #{name}");
                }
                if (map.get("tel") != null){
                    WHERE("U_TEL = #{tel}");
                }
            }
        }.toString();
    }


}
