package lk.ijse.hotelmanagementsystem_ijse.dao;

import lk.ijse.hotelmanagementsystem_ijse.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    public boolean saveCustomer(CustomerDTO customerDTO) throws Exception;
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception;
    public boolean deleteCustomer(String customer_id) throws Exception;
    public CustomerDTO searchCustomer(String customerId) throws Exception;
    public List<CustomerDTO> getCustomers() throws SQLException;
    public String generateNextCustomerId() throws Exception;
}
