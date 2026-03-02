package lk.ijse.hotelmanagementsystem_ijse.bo.custom;

import lk.ijse.hotelmanagementsystem_ijse.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO {
    public boolean saveEmployee(EmployeeDTO dto) throws Exception;
    public boolean updateEmployee(EmployeeDTO dto) throws Exception;
    public boolean deleteEmployee(String employeeId) throws Exception;
    public EmployeeDTO searchEmployee(String employeeId) throws Exception;
    public List<EmployeeDTO> getAllEmployees() throws SQLException, ClassNotFoundException;
    public String generateNextEmployeeId() throws Exception;
}
