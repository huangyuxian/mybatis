package edu.nf.ch01.utils;

import jdk.management.resource.ResourceRequest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {

    /**
     * 定义SqlSessionFactory，用于创建SqlSession实例
     */
    private static SqlSessionFactory sqlSessionFactory;

    /**
     * 在静态代码块中初始化SqlSessionFactory实例
     */
    static {
        try {
            //通过查找mybatis的核心配置文件，并创建一个输入流用于读取xml文件
            InputStream is = Resources.getResourceAsStream("mybatis.xml");
            //创建一个SqlSessionFactoryBuilder构建器来实例化一个SqlSessionFactory，
            //build方法传入一个输入流来解析配置文件，从而创建SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Read mybatis.xml fail.");
        }
    }

    /**
     * 提供一个获取SqlSession的静态方法
     * @return
     */
    public static SqlSession getSqlSession(){
        //通过sqlSessionFactory的openSession方法来获取sqlSession
        //注意：这个方法可以带一个boolean类型的参数
        //使用不带参数的方法得到的sqlSession是需要我们手动提交事务
        //使用带参数的方法并将其设置为true，这样得到sqlSession是会自动提交事务
        return sqlSessionFactory.openSession(true);
    }

    public static void main(String[] args) {
        System.out.println(getSqlSession());
    }
}
