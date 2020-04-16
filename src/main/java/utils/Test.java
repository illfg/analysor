package utils;

import entity.*;
import mapper.MesMapper;
import mapper.TemperatureMapper;
import mapper.UserMapper;
import mapper.WeekcMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import service.*;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

public class Test {

    @org.junit.Test
    public void test() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = build.openSession();
        //使用SqlSession获取映射器进行操作
        WeekcMapper mapper = sqlSession.getMapper(WeekcMapper.class);
        System.out.println(mapper.queryByWeek(2020,1,1,"1"));
    }

    @org.junit.Test
    public void test2(){
        Sudu40Service sudu40Service = new Sudu40Service();
        CommonService commonService = new CommonService();
        HumidityService humidityService = new HumidityService();
        TemperatureService temperatureService = new TemperatureService();

//        double acc = (double) (Math.random()*2.5);
//        int tem = (int) (Math.random()*40);
        //int hum = (int) (Math.random()*100);
//        Weekc weekc = new Weekc(0,"2020",j,i,day++ + "",hum+"",acc,tem+"","粤123456");
//        commonService.insert(weekc);
        for (int i = 1; i <= 12; i++) {
            int day = 1;
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 7; k++) {
                    for (int l = 6; l <= 22; l++) {
                        double acc = (double) (Math.random()*2.5);
                        Date time = new Date("2020/" + i + "/" + day);
                        Date now = new Date("2020/" + i + "/" + day+" "+l+":00:00");
                        Sudu40 sudu40 = new Sudu40(now, acc, time, "粤123456", "老王");
                        sudu40Service.insertSudu40(sudu40);
                    }
                    day++;
                }

            }
        }

    }
}
