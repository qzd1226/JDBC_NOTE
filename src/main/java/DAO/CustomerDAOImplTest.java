package DAO;

import utils.JDBCUtils;
import Bean.Customer;
import DAO.CustomerDAOImpl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.util.List;
import org.junit.Test;

public class CustomerDAOImplTest {
    private CustomerDAOImpl dao = new CustomerDAOImpl();

    public CustomerDAOImplTest() {
    }

    @Test
    public void testInsert() {
        Connection conn = null;

        try {
            conn = JDBCUtils.getConnection();
            Customer cust = new Customer(1, "张小飞", "zhang@126.com", new Date(43534646435L));
            Customer cust2 = new Customer(2, "网小飞", "zhang@126.com", new Date(43534646435L));
            Customer cust3 = new Customer(3, "孙小飞", "sun@126.com", new Date(43534646435L));
            Customer cust4 = new Customer(4, "思小飞", "si@126.com", new Date(43534646435L));
            Customer cust5 = new Customer(5, "由小飞", "you@126.com", new Date(43534646435L));
            this.dao.insert(conn, cust);
            this.dao.insert(conn, cust2);
            this.dao.insert(conn, cust3);
            this.dao.insert(conn, cust4);
            this.dao.insert(conn, cust5);
            System.out.println("添加成功");
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, (Statement)null);
        }

    }

    @Test
    public void testDeleteById() {
        Connection conn = null;

        try {
            conn = JDBCUtils.getConnection();
            this.dao.deleteById(conn, 2);
            System.out.println("删除成功");
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, (Statement)null);
        }

    }

    @Test
    public void testUpdateConnectionCustomer() {
        Connection conn = null;

        try {
            conn = JDBCUtils.getConnection();
            Customer cust = new Customer(1, "贝多芬", "beiduofen@126.com", new Date(453465656L));
            this.dao.update(conn, cust);
            System.out.println("修改成功");
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, (Statement)null);
        }

    }

    @Test
    public void testGetCustomerById() {
        Connection conn = null;

        try {
            conn = JDBCUtils.getConnection();
            Customer cust = this.dao.getCustomerById(conn, 4);
            System.out.println(cust);
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, (Statement)null);
        }

    }

    @Test
    public void testGetAll() {
        Connection conn = null;

        try {
            conn = JDBCUtils.getConnection();
            List<Customer> list = this.dao.getAll(conn);
            list.forEach(System.out::println);
            System.out.println("");
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, (Statement)null);
        }

    }

    @Test
    public void testGetCount() {
        Connection conn = null;

        try {
            conn = JDBCUtils.getConnection();
            Long count = this.dao.getCount(conn);
            System.out.println("表中的记录数为：" + count);
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, (Statement)null);
        }

    }

    @Test
    public void testGetMaxBirth() {
        Connection conn = null;

        try {
            conn = JDBCUtils.getConnection();
            Date maxBirth = this.dao.getMaxBirth(conn);
            System.out.println("最大的生日为：" + maxBirth);
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, (Statement)null);
        }

    }
}
