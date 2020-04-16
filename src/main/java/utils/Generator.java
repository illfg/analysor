package utils;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;

public class Generator {
    //逆向工程
    @Test
    public void test() throws Exception {
        //配置文件
        File file = new File(this.getClass().getResource("/").getPath(),"generator.xml");
        //集合保存异常信息
        ArrayList<String> warning = new ArrayList<String>();
        //
        ConfigurationParser configurationParser = new ConfigurationParser(warning);
        Configuration config = configurationParser.parseConfiguration(file);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        //逆向工程的核心类
        MyBatisGenerator generator = new MyBatisGenerator(config, callback, warning);

        generator.generate(null);

    }

}
