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

    public BookingDetails(String bookingId, String roomId, Date checkInDate) {
        this.bookingId = bookingId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
    }

    public BookingDetails(String roomId, Date checkInDate, String bookingId) {
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.bookingId = bookingId;
    }
}
