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


    public CustomerDTO(String contact, String email, String name, String nic, String address) {
        this.contact = contact;
        this.email = email;
        this.name = name;
        this.nic_passport = nic;
        this.address = address;
    }



}
