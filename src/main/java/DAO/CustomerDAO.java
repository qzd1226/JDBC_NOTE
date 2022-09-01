package DAO;

import Bean.Customer;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public interface CustomerDAO {
    void insert(Connection var1, Customer var2);

    void deleteById(Connection var1, int var2);

    void update(Connection var1, Customer var2);

    Customer getCustomerById(Connection var1, int var2);

    List<Customer> getAll(Connection var1);

    Long getCount(Connection var1);

    Date getMaxBirth(Connection var1);
}