package service;

import entity.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

/**这个类是用于提供数据库的连接服务的，由于不用spring等ioc框架，就只能让所有
 * 需要使用数据库读写操作的类继承这个类
 */
public class DaoProvider {
    static SqlSession sqlSession;

    static {
        Reader reader = null;
        try {
            //读取mybatis配置文件
            reader = Resources.getResourceAsReader("mybatis_config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取到sqlsession
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(reader);
        sqlSession = build.openSession();
    }


    public static <T> T getMapper(Class<T> clazz){
        //使用SqlSession获取映射器进行操作
        return sqlSession.getMapper(clazz);
    }
    //提交 插入以及更新操作
    public static void commit(){
        sqlSession.commit();
    }



}
