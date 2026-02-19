package lk.ijse.hotelmanagementsystem_ijse.dao.custom;

import lk.ijse.hotelmanagementsystem_ijse.dao.CrudDAO;
import lk.ijse.hotelmanagementsystem_ijse.dto.CustomerDTO;
import lk.ijse.hotelmanagementsystem_ijse.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO extends CrudDAO<Customer> {
    /*public boolean saveCustomer(CustomerDTO customerDTO) throws Exception;
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception;
    public boolean deleteCustomer(String customer_id) throws Exception;
    public CustomerDTO searchCustomer(String customerId) throws Exception;
    public List<CustomerDTO> getCustomers() throws SQLException;
    public String generateNextCustomerId() throws Exception;*/
}