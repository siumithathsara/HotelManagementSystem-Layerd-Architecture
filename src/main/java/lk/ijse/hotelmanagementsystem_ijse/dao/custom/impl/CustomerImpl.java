package lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl;

import lk.ijse.hotelmanagementsystem_ijse.dao.custom.CustomerDAO;
import lk.ijse.hotelmanagementsystem_ijse.entity.Customer;
import lk.ijse.hotelmanagementsystem_ijse.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements CustomerDAO {

    public boolean save(Customer customer) throws Exception {
        return CrudUtil.execute(
                "INSERT INTO Customer (customer_id, name, contact, email, nic_passport, address) VALUES (?,?,?,?,?,?)",
                customer.getCustomer_id(),
                customer.getName(),
                customer.getContact(),
                customer.getEmail(),
                customer.getNic_passport(),
                customer.getAddress()
        );
    }

    public boolean update(Customer customer) throws Exception {
        String sql = "UPDATE Customer SET name=?, contact=?, email=?, nic_passport=?, address=? WHERE customer_id=?";

        return CrudUtil.execute(
                sql,
                customer.getName(),
                customer.getContact(),
                customer.getEmail(),
                customer.getNic_passport(),
                customer.getAddress(),
                customer.getCustomer_id()
        );
    }

    public boolean delete(String customer_id) throws Exception {
        return CrudUtil.execute(
                "DELETE FROM Customer WHERE customer_id=?",
                customer_id
        );
    }

    public Customer search(String customerId) throws Exception {
        ResultSet rs = CrudUtil.execute(
                "SELECT * FROM Customer WHERE customer_id=?",
                customerId
        );

        if (rs.next()) {
            return new Customer(
                    rs.getString("customer_id"),
                    rs.getString("name"),
                    rs.getString("contact"),
                    rs.getString("email"),
                    rs.getString("nic_passport"),
                    rs.getString("address")
            );
        }
        return null;
    }

    public List<Customer> getAll() throws SQLException {
        ResultSet rs = CrudUtil.execute(
                "SELECT * FROM Customer ORDER BY customer_id DESC"
        );

        List<Customer> customerList = new ArrayList<>();
        while (rs.next()) {
            customerList.add(new Customer(
                    rs.getString("customer_id"),
                    rs.getString("name"),
                    rs.getString("contact"),
                    rs.getString("email"),
                    rs.getString("nic_passport"),
                    rs.getString("address")
            ));
        }
        return customerList;
    }

    public String generateNextId() throws Exception {
        ResultSet rs = CrudUtil.execute(
                "SELECT customer_id FROM Customer ORDER BY customer_id DESC LIMIT 1"
        );

        if (rs.next()) {
            String lastId = rs.getString(1); // E.g., C005
            int number = Integer.parseInt(lastId.substring(1));
            number++;
            return String.format("C%03d", number);
        }
        return "C001";
    }

}
