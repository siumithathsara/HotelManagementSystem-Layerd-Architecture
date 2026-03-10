package lk.ijse.hotelmanagementsystem_ijse.dto;

import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDTO {

    private String employeeId;
    private String name;
    private String email;
    private String contact;
    private String address;
    private String joining_date;
    private String job_role;




    public EmployeeDTO(String address, String contact, String email, String employee_id, String job_role, String name) {
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.employeeId = employee_id;
        this.job_role = job_role;
        this.name = name;
    }


    public EmployeeDTO(String employeeId, String name, String email, String contact, String address, String joining_date, String job_role) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.joining_date = joining_date;
        this.job_role = job_role;
    }
}
