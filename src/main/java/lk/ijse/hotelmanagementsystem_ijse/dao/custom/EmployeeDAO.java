package lk.ijse.hotelmanagementsystem_ijse.dao.custom;

import lk.ijse.hotelmanagementsystem_ijse.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    public boolean saveEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException;
    public boolean updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException;
    public boolean deleteEmployee(String employeeId) throws SQLException;
    public EmployeeDTO searchEmployee(String employeeId) throws SQLException, ClassNotFoundException;
    public List<EmployeeDTO> getAllEmployees() throws SQLException;
    public String generateNextEmployeeId() throws SQLException;
}
