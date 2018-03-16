package edu.nf.ch11.dao;

import edu.nf.ch11.entity.Users;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 分页查询
 */
public interface UserDao {
    /**
     * 使用RowBounds对象进行分页查询
     * (这种方式是不推荐使用的，因为是基于逻辑分页，当有大量数据的时候，由于会先将所有的记录查询出来的再执行分页，
     * 因此性能极低)
     * @return
     */
    @Select("SELECT * FROM USER_INFO")
    @ResultMap("edu.nf.ch11.dao.UserDao.userMap")
    List<Users> findUsers(RowBounds rowBounds);


    /**
     * 使用PageHelper插件执行分页查询（推荐）
     * 要在mybatis.xml里面配置
     */
    @Select("SELECT * FROM USER_INFO")
    @ResultMap("edu.nf.ch11.dao.UserDao.userMap")
    List<Users> findUser2();
}
