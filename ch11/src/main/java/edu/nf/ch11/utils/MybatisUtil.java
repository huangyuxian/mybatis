package edu.nf.ch11.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Pares mybatis.xml fail");
        }
    }

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);
    }

}
