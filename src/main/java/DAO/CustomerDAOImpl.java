package DAO;

import Bean.Customer;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class CustomerDAOImpl extends BaseDAO implements CustomerDAO {
    public CustomerDAOImpl() {
    }

    public void insert(Connection conn, Customer cust) {
        String sql = "insert into customers(name,email,birth)values(?,?,?)";
        this.update(conn, sql, new Object[]{cust.getName(), cust.getEmail(), cust.getBirth()});
    }

    public void deleteById(Connection conn, int id) {
        String sql = "delete from customers where id = ?";
        this.update(conn, sql, new Object[]{id});
    }

    public void update(Connection conn, Customer cust) {
        String sql = "update customers set name = ?,email = ?,birth = ? where id = ?";
        this.update(conn, sql, new Object[]{cust.getName(), cust.getEmail(), cust.getBirth(), cust.getId()});
    }

    public Customer getCustomerById(Connection conn, int id) {
        String sql = "select id,name,email,birth from customers where id = ?";
        Customer customer = (Customer)this.getInstance(conn, Customer.class, sql, new Object[]{id});
        return customer;
    }

    public List<Customer> getAll(Connection conn) {
        String sql = "select id,name,email,birth from customers";
        List<Customer> list = this.getForList(conn, Customer.class, sql, new Object[0]);
        return list;
    }

    public Long getCount(Connection conn) {
        String sql = "select count(*) from customers";
        return (Long)this.getValue(conn, sql, new Object[0]);
    }

    public Date getMaxBirth(Connection conn) {
        String sql = "select max(birth) from customers";
        return (Date)this.getValue(conn, sql, new Object[0]);
    }
}
