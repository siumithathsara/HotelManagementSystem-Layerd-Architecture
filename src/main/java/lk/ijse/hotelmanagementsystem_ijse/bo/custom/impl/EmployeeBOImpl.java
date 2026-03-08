package lk.ijse.hotelmanagementsystem_ijse.bo.custom.impl;

import lk.ijse.hotelmanagementsystem_ijse.bo.custom.EmployeeBO;
import lk.ijse.hotelmanagementsystem_ijse.dao.DAOFactory;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.EmployeeDAO;
import lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl.EmployeeImpl;
import lk.ijse.hotelmanagementsystem_ijse.dto.EmployeeDTO;
import lk.ijse.hotelmanagementsystem_ijse.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    private EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    @Override
    public boolean deleteEmployee(String employeeId) throws Exception {
        return employeeDAO.delete(employeeId);
    }

    @Override
    public boolean saveEmployee(EmployeeDTO employeeDTO) throws Exception {
        return employeeDAO.save(new Employee(
                employeeDTO.getEmployeeId(),
                employeeDTO.getName(),
                employeeDTO.getEmail(),
                employeeDTO.getContact(),
                employeeDTO.getAddress(),
                employeeDTO.getJoining_date(),
                employeeDTO.getJob_role()));
    }

    @Override
    public boolean updateEmployee(EmployeeDTO employeeDTO) throws Exception {
        return employeeDAO.update(new Employee(
                employeeDTO.getName(),
                employeeDTO.getEmail(),
                employeeDTO.getContact(),
                employeeDTO.getAddress(),
                employeeDTO.getJoining_date(),
                employeeDTO.getJob_role()));
    }

    @Override
    public EmployeeDTO searchEmployee(String employeeId) throws Exception {
        Employee employee =employeeDAO.search(employeeId);
        return new EmployeeDTO(
                employee.getEmployeeId(),
                employee.getName(),
                employee.getEmail(),
                employee.getContact(),
                employee.getJoining_date(),
                employee.getJob_role()
        );
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() throws SQLException, ClassNotFoundException {
      List<Employee> employees = employeeDAO.getAll();
      ArrayList<EmployeeDTO> employeesDTO = new ArrayList<>();

      for (Employee employee : employees) {
          EmployeeDTO employeeDTOs= new EmployeeDTO(
                  employee.getEmployeeId(),
                  employee.getName(),
                  employee.getEmail(),
                  employee.getContact(),
                  employee.getJoining_date(),
                  employee.getJob_role()
          );
          employeesDTO.add(employeeDTOs);
      }
      return employeesDTO;
    }

    @Override
    public String generateNextEmployeeId() throws Exception {
        return employeeDAO.generateNextId();
    }
}
