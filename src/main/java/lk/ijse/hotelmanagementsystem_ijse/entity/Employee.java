package lk.ijse.hotelmanagementsystem_ijse.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    private String employeeId;
    private String name;
    private String email;
    private String contact;
    private String address;
    private String joining_date;
    private String job_role;

    public Employee(String name, String email, String contact, String address, String joiningDate, String jobRole) {
                                this.name = name;
                                this.email = email;
                                this.contact = contact;
                                this.address = address;
                                this.joining_date = joiningDate;
                                this.job_role = jobRole;

    }


}
