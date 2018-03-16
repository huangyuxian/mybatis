package edu.nf.ch11.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.nf.ch11.dao.UserDao;
import edu.nf.ch11.dao.impl.UserDaoImpl;
import edu.nf.ch11.entity.Users;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    /**
     * 使用RowBounds
     */
    @Test
    public void testFindUsers(){
        //创建RowBounds对象，第一个参数表示从第几条开始查询
        //第二个参数是取多少条记录
        RowBounds rowBounds = new RowBounds(0,2);
        UserDao dao = new UserDaoImpl();
        List<Users> list = dao.findUsers(rowBounds);
        for (Users u : list){
            System.out.println(u.getUid()+" : "+u.getUserName()+" : "+u.getTel());
        }
    }

    /**
     * 使用PageHelper插件
     */
    @Test
    public void testFindUser2(){
        UserDao dao = new UserDaoImpl();
        //通过PageHelper的startPage静态方法设置参数
        PageHelper.startPage(1,2);
        //执行dao查询
        List<Users> list = dao.findUser2();
        //创建pageInfo对象封装list
        PageInfo<Users> page = new PageInfo<>(list);
        System.out.println("当前页:"+page.getPageNum());
        System.out.println("第一页:"+page.getNavigateFirstPage());
        System.out.println("上一页:"+page.getPrePage());
        System.out.println("下一页："+page.getNextPage());
        System.out.println("最后一页:"+page.getNavigateLastPage());
        System.out.println("总页数:"+page.getPages());
        for (Users u : list){
            System.out.println(u.getUid()+" : "+u.getTel()+" : "+u.getUserName());
        }
    }
}
