package lk.ijse.hotelmanagementsystem_ijse.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class BookingDetailsDTO {
    private String bookingId;
    private String roomId;
    private Date checkInDate;
    private Date checkOutDate;


    public BookingDetailsDTO(String bookingId, String roomId, Date checkInDate) {
        this.bookingId = bookingId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
    }
}
