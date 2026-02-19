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
}
