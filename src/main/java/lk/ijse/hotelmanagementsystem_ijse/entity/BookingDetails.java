package lk.ijse.hotelmanagementsystem_ijse.entity;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookingDetails {
    private String bookingId;
    private String roomId;
    private Date checkInDate;
    private Date checkOutDate;
}
