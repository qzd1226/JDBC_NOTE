import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
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
}
