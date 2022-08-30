

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class test_jdbc {
    @Test
    public void testConnection(){
        try{
            //提供 java.sql.Driver 接口实现类的对象
            Driver driver = null;
            driver = new com.mysql.jdbc.Driver();
            //提供url,知名具体操作的数据
            String url = "jdbc:mysql://localhost:3306/book";
            //提供Properties的对象，指明用户名和密码
            Properties info = new Properties();
            info.setProperty("user","root");
            info.setProperty("password","bhfz1226");
            //调用driver的connect(),获取连接
            Connection conn = driver.connect(url, info);
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //通过配置文件连接
    @Test
    public void testConnection2() throws Exception{
        //加载配置文件
        InputStream is = test_jdbc.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        //读取配置信息
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //加载驱动
        Class.forName(driverClass);

        //获取连接
        Connection conn = DriverManager.getConnection(url,user,password);
        System.out.println(conn);

    }
}
