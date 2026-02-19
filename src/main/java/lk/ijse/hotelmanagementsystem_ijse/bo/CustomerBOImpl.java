package lk.ijse.hotelmanagementsystem_ijse.bo;

import lk.ijse.hotelmanagementsystem_ijse.dao.custom.CustomerDAO;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl.CustomerImpl;
import lk.ijse.hotelmanagementsystem_ijse.dto.CustomerDTO;
import lk.ijse.hotelmanagementsystem_ijse.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO{

    private CustomerDAO customerDAO =new CustomerImpl();
    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws Exception {
        return customerDAO.save(new Customer(
                customerDTO.getCustomer_id(),
                customerDTO.getName(),
                customerDTO.getContact(),
                customerDTO.getEmail(),
                customerDTO.getNic_passport(),
                customerDTO.getAddress()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        return customerDAO.update(new Customer(
                customerDTO.getName(),
                customerDTO.getContact(),
                customerDTO.getEmail(),
                customerDTO.getNic_passport(),
                customerDTO.getAddress()));
    }

    @Override
    public boolean deleteCustomer(String customer_id) throws Exception {
        return customerDAO.delete(customer_id);
    }

    @Override
    public CustomerDTO searchCustomer(String customerId) throws Exception {
        Customer customer = customerDAO.search(customerId);
        return new CustomerDTO(
                customer.getCustomer_id(),
                customer.getName(),
                customer.getContact(),
                customer.getEmail(),
                customer.getNic_passport(),
                customer.getAddress()
        );
    }

    @Override
    public List<CustomerDTO> getCustomers() throws SQLException, ClassNotFoundException {

        List<Customer> customers = customerDAO.getAll();
       ArrayList<CustomerDTO> customerDTOS=new ArrayList<>();

       for (Customer customer : customers) {
           CustomerDTO customerDTO=new CustomerDTO(
                   customer.getCustomer_id(),
                   customer.getName(),
                   customer.getContact(),
                   customer.getEmail(),
                   customer.getNic_passport(),
                   customer.getAddress());
       }
       return customerDTOS;
    }

    @Override
    public String generateNextCustomerId() throws Exception {
        return customerDAO.generateNextId();
    }
}
