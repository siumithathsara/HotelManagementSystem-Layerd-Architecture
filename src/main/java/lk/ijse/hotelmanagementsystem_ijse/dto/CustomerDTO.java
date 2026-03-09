package lk.ijse.hotelmanagementsystem_ijse.dto;

import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDTO {

    private String customer_id;
    private String name;
   // private String last_name;
    private String contact;
    private String email;
    private String nic_passport;
    private String  address;


    public CustomerDTO(String name, String contact, String email, String nic_passport, String address) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.nic_passport = nic_passport;
        this.address = address;
    }
}
