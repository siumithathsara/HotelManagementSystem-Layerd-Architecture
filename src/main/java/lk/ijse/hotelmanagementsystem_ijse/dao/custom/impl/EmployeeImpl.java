package lk.ijse.hotelmanagementsystem_ijse.dao.custom.impl;

import lk.ijse.hotelmanagementsystem_ijse.dao.custom.EmployeeDAO;
import lk.ijse.hotelmanagementsystem_ijse.entity.Employee;
import lk.ijse.hotelmanagementsystem_ijse.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeImpl implements EmployeeDAO {
    public boolean save(Employee employee) throws SQLException, ClassNotFoundException {


        String sql = "INSERT INTO Employee (employee_id, name, email, contact, address, job_role) VALUES (?,?,?,?,?,?)";

        return CrudUtil.execute(
                sql,
                employee.getEmployeeId(),
                employee.getName(),
                employee.getEmail(),
                employee.getContact(),
                employee.getAddress(),
                employee.getJob_role()
        );
    }

    public boolean update(Employee employee) throws SQLException, ClassNotFoundException {



        String sql = "UPDATE Employee SET name=?, email=?, contact=?, address=?, job_role=? " +
                "WHERE employee_id=?";

        return CrudUtil.execute(
                sql,
                employee.getName(),
                employee.getEmail(),
                employee.getContact(),
                employee.getAddress(),
                employee.getJob_role(),
                employee.getEmployeeId()
        );
    }

    public  boolean delete(String employeeId) throws SQLException {
        String sql = "DELETE FROM Employee WHERE employee_id=?";
        return CrudUtil.execute(sql, employeeId);
    }



    public Employee search(String employeeId) throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM Employee WHERE employee_id=?";
        ResultSet rs = CrudUtil.execute(sql, employeeId);

        if (rs.next()) {

            return new Employee(
                    rs.getString("employee_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("contact"),
                    rs.getString("address"),
                    String.valueOf(rs.getDate("join_date")),
                    rs.getString("job_role")
            );
        }
        return null;
    }

    public List<Employee> getAll() throws SQLException {

        ResultSet rs = CrudUtil.execute("SELECT * FROM Employee ORDER BY employee_id DESC");
        List<Employee> employeeList = new ArrayList<>();

        while (rs.next()) {
            String[] nameParts = rs.getString("name").split(" ", 2);
            String firstName = nameParts[0];
            String lastName = nameParts.length > 1 ? nameParts[1] : "";

            employeeList.add(
                    new Employee(
                            rs.getString("employee_id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            String.valueOf(rs.getDate("join_date")),
                            rs.getString("job_role")
                    )
            );
        }
        return employeeList;
    }


    public String generateNextId() throws SQLException {
        ResultSet rs = CrudUtil.execute(
                "SELECT employee_id FROM Employee ORDER BY employee_id DESC LIMIT 1"
        );

        if (rs.next()) {
            String lastId = rs.getString(1); // E.g., C005
            int number = Integer.parseInt(lastId.substring(1));
            number++;
            return String.format("E%03d", number);
        }
        return "E001";

    }
}
